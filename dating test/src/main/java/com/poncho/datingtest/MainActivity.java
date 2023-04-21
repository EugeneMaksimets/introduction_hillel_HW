package com.poncho.datingtest;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.facebook.FacebookSdk;
import com.facebook.applinks.AppLinkData;
import com.onesignal.OneSignal;

import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static NetworkInfo netInfo;

    // For save last page
    private SharedPreferences sharedPreferences;
    private static final String APP_PREFERENCES = "myurl";
    private static final String APP_PREFERENCES_URL = "url";
    SharedPreferences.Editor editor;

    // For Load Image
    private ValueCallback<Uri[]> uploadMessage;
    private ValueCallback<Uri> mUploadMessage;
    private static final int REQUEST_SELECT_FILE = 100;
    private final static int FILE_CHOOSER_RESULT_CODE = 1;

    private WebView webView;
    private WebSettings webSettings;
    private HttpURLConnectionService httpURLConnectionService;

    private final String URL_KEITARO = "url"; //url main keitaro
    private String urlLoad = ""; //final url with end from link
    private String urlHost = ""; //get naming from facebook sub1=? NEED TEST

    private static final String ONESIGNAL_APP_ID = ""; //One Signal key

    private static final String AF_DEV_KEY = ""; //ApsFlayer key

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); // open full screen

        // get last page
        sharedPreferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        appsFlayerStart();

        runOneSignal();

        deepLinkValidation();

    }

    @SuppressLint("SetJavaScriptEnabled")
    private void openMainActivity() {
//        urlLoad = URL_KEITARO + urlHost; // url keitaro + url end link add to load in web view change start
//         Load last page if page save another use page keitaro + sub NEED TEST
        if(sharedPreferences.contains(APP_PREFERENCES_URL)) {
            urlLoad = sharedPreferences.getString(APP_PREFERENCES_URL, "");
        } else {
            urlLoad = URL_KEITARO + urlHost;
        }

        httpURLConnectionService = new HttpURLConnectionService();
        httpURLConnectionService.start();
        try {
            httpURLConnectionService.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (httpURLConnectionService.getResponseCodeConnection() != 404) {
            webView = findViewById(R.id.webview); // get web view from xml by ID

            webView.post(new Runnable() {
                @Override
                public void run() {
                    webSettings = webView.getSettings(); // get setting from xml web view

                    webSettings.setJavaScriptEnabled(true); // show JavaScript
                    webSettings.setDomStorageEnabled(true); // save cookie for user
                    webSettings.setBuiltInZoomControls(true); // can zoom site with Finger
                    webSettings.setSupportZoom(false); // delete + and - on site for zoom
                    webSettings.setDisplayZoomControls(false); // delete + and - on site for zoom

                    webView.setInitialScale(1); // if site haven't mobile version

                    webSettings.setLoadWithOverviewMode(true); // size site with width
                    webSettings.setUseWideViewPort(true); // view port enable

                    webView.setWebChromeClient(new MyWebChromeClient()); // 3 down lines for load image
                    webView.getSettings().setAllowContentAccess(true);
                    webView.getSettings().setAllowFileAccess(true);

                    webView.loadUrl(urlLoad); //change to urlLoad

                    webView.addJavascriptInterface(new WhitePageForModer(), "HTMLOUT"); // check html from bot next in onPageFinished

                    webView.setWebViewClient(new WebViewClient() {
                        // Don't open url in web browser set new client
                        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest request) {
                            return false;
                        }

                        // When new page load save cookie
                        public void onPageFinished(WebView view, String url) {
                            //load html next showHTML
                            view.loadUrl("javascript:window.HTMLOUT.showHTML" +
                                    "('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
                            CookieSyncManager.getInstance().sync();

                            // save last page for load
                            urlLoad = webView.getUrl(); // when page load save to urlLoad last page
                            editor = sharedPreferences.edit();
                            editor.putString(APP_PREFERENCES_URL, urlLoad);
                            editor.apply();
                        }
                    });
                }
            });

        } else
            openWhitePage();
    }

    private void appsFlayerStart() {
        AppsFlyerConversionListener conversionListener =  new AppsFlyerConversionListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onConversionDataSuccess(Map<String, Object> conversionDataMap) {
                for (String attrName : conversionDataMap.keySet())
                    Log.d(LOG_TAG, "Conversion attribute: " + attrName + " = " + conversionDataMap.get(attrName));
                String status = Objects.requireNonNull(conversionDataMap.get("af_status")).toString();
                if(status.equals("Organic")) {
                    // Business logic for Organic conversion goes here.
                }
                else {
                    // Business logic for Non-organic conversion goes here.
                }
            }

            @SuppressLint("RestrictedApi")
            @Override
            public void onConversionDataFail(String errorMessage) {
                Log.d(LOG_TAG, "error getting conversion data: " + errorMessage);
            }

            @Override
            public void onAppOpenAttribution(Map<String, String> attributionData) {
                // Must be overriden to satisfy the AppsFlyerConversionListener interface.
                // Business logic goes here when UDL is not implemented.
            }

            @SuppressLint("RestrictedApi")
            @Override
            public void onAttributionFailure(String errorMessage) {
                // Must be overriden to satisfy the AppsFlyerConversionListener interface.
                // Business logic goes here when UDL is not implemented.
                Log.d(LOG_TAG, "error onAttributionFailure : " + errorMessage);
            }

        };

        AppsFlyerLib.getInstance().init(AF_DEV_KEY, conversionListener, this);
        AppsFlyerLib.getInstance().start(this);

    }

    // For Facebook
    private void deepLinkValidation() {
        Intent intent = getIntent();
//        String action = intent.getAction();
        Uri data = intent.getData();
        try {
            urlHost = data.getQuery();
            urlHost = "?" + urlHost;
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (isOnline(this)) {
//            FacebookSdk.sdkInitialize(this);
            FacebookSdk.setAutoInitEnabled(true);
            FacebookSdk.fullyInitialize();
            AppLinkData.fetchDeferredAppLinkData(this,
                    new AppLinkData.CompletionHandler() {
                        @Override
                        public void onDeferredAppLinkDataFetched(AppLinkData appLinkData) {
                            if (appLinkData != null) {
                                final String getEndLink = appLinkData.getTargetUri().getQuery();
                                urlHost = "?" + getEndLink;
                                openMainActivity();
                            } else {
                                openMainActivity();
                            }
                        }
                    }
            );
        } else
            openWhitePage();
    }

    private void runOneSignal() {
        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);

        // promptForPushNotifications will show the native Android notification permission prompt.
        // We recommend removing the following code and instead using an In-App Message to prompt for notification permission (See step 7)
        OneSignal.promptForPushNotifications();
    }

    private class WhitePageForModer {

        @JavascriptInterface
        public void showHTML(String html_data) {
            // drop in keitaro filter with bot <!--welcome_ooo_pulsar-->
            if (html_data.compareToIgnoreCase("<html><head><style>body{margin:0}</style></head><body><!--welcome_ooo_pulsar--></body></html>") == 0)
                openWhitePage();
        }

    }

    // When press back button don't close app
    @Override
    public void onBackPressed() {
        if (webView.canGoBack())
            webView.goBack();
        else
            webView.loadUrl(urlLoad);
//            super.onBackPressed();
    }

    private static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting())
            return true;
        return false;
    }

    private void openWhitePage() {
        Intent intent = new Intent(this, WhitePage.class);
        startActivity(intent);
    }

    //For Load Image
    class MyWebChromeClient extends WebChromeClient {
        // For 3.0+ Devices (Start)
        // onActivityResult attached before constructor
        protected void openFileChooser(ValueCallback uploadMsg, String acceptType) {
            mUploadMessage = uploadMsg;
            Intent i = new Intent(Intent.ACTION_GET_CONTENT);
            i.addCategory(Intent.CATEGORY_OPENABLE);
            i.setType("image/*");
            startActivityForResult(Intent.createChooser(i, "File Chooser"), FILE_CHOOSER_RESULT_CODE);
        }


        // For Lollipop 5.0+ Devices
        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        public boolean onShowFileChooser(WebView mWebView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
            if (uploadMessage != null) {
                uploadMessage.onReceiveValue(null);
                uploadMessage = null;
            }

            uploadMessage = filePathCallback;

            Intent intent = fileChooserParams.createIntent();
            try {
                startActivityForResult(intent, REQUEST_SELECT_FILE);
            } catch (ActivityNotFoundException e) {
                uploadMessage = null;
                Toast.makeText(MainActivity.this, "Файл невозможно открыть", Toast.LENGTH_LONG).show();
                return false;
            }
            return true;
        }

        //For Android 4.1 only 19
        protected void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
            mUploadMessage = uploadMsg;
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent, "Выбор файла"), FILE_CHOOSER_RESULT_CODE);
        }

        protected void openFileChooser(ValueCallback<Uri> uploadMsg) {
            mUploadMessage = uploadMsg;
            Intent i = new Intent(Intent.ACTION_GET_CONTENT);
            i.addCategory(Intent.CATEGORY_OPENABLE);
            i.setType("image/*");
            startActivityForResult(Intent.createChooser(i, "Выбор файла"), FILE_CHOOSER_RESULT_CODE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (requestCode == REQUEST_SELECT_FILE) {
                if (uploadMessage == null)
                    return;
                uploadMessage.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(resultCode, intent));
                uploadMessage = null;
            }
        } else if (requestCode == FILE_CHOOSER_RESULT_CODE) {
            if (null == mUploadMessage)
                return;
            // Use MainActivity.RESULT_OK if you're implementing WebView inside Fragment
            // Use RESULT_OK only if you're implementing WebView inside an Activity
            Uri result = intent == null || resultCode != RESULT_OK ? null : intent.getData();
            mUploadMessage.onReceiveValue(result);
            mUploadMessage = null;
        } else
            Toast.makeText(this, "Failed to Upload Image", Toast.LENGTH_LONG).show();
    }

}
