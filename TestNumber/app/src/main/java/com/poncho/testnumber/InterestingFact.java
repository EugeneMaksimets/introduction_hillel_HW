package com.poncho.testnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.poncho.testnumber.database.DatabaseService;
import com.poncho.testnumber.entity.RequestEntity;
import com.poncho.testnumber.service.JSONGetResponse;
import com.poncho.testnumber.service.StringSplitService;

public class InterestingFact extends AppCompatActivity {

    private static RequestEntity requestEntity;

    private final String URL_API = "http://numbersapi.com/%d/math?callback=showNumber";
    private final String URL_RANDOM_API = "http://numbersapi.com/random/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interesting_fact);

        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        TextView textViewFact = findViewById(R.id.factText);
        DatabaseService databaseService = new DatabaseService();

        if(!requestEntity.isHistory()) {
            String currentUrl = requestEntity.isRandom() ? URL_RANDOM_API : String.format(URL_API, requestEntity.getNumber());
            JSONGetResponse jsonGetResponse = new JSONGetResponse(this, currentUrl,
                    databaseService, textViewFact, requestEntity, progressBar);
        } else {
            textViewFact.setText(requestEntity.getHistoryInfo());
            progressBar.setVisibility(View.INVISIBLE);
            databaseService.saveToDatabase(StringSplitService.splitString(requestEntity.getHistoryInfo()),
                    requestEntity.getHistoryInfo(),
                    this);
        }

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public static void setResponseEntity(RequestEntity requestEntity) {
        InterestingFact.requestEntity = requestEntity;
    }
}
