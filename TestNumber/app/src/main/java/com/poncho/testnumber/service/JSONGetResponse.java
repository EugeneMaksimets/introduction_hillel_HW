package com.poncho.testnumber.service;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.poncho.testnumber.database.DatabaseService;
import com.poncho.testnumber.entity.RequestEntity;

public class JSONGetResponse {
    public JSONGetResponse(Context context, String url, DatabaseService databaseService,
                           TextView textViewFact, RequestEntity requestEntity, ProgressBar progressBar) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String info;
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                textViewFact.setText(response);
                                progressBar.setVisibility(View.INVISIBLE);
                                int numberToSave = requestEntity.getNumber();
                                if(requestEntity.isRandom()) {
                                    numberToSave = StringSplitService.splitString(response);
                                }
                                databaseService.saveToDatabase(numberToSave, response, context);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                RequestQueue requestQueue = Volley.newRequestQueue(context);
                requestQueue.add(stringRequest);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

}
