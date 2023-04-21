package com.poncho.datingtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WhitePage extends AppCompatActivity {

    private TextView hideText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_white_page);

        hideText = findViewById(R.id.textView3);
        hideText.setVisibility(View.GONE);
    }

    public void signup(View view) {
        hideText.setVisibility(View.VISIBLE);
    }

    public void registration(View view) {
        Intent intentButton = new Intent(this, RegistrationPage.class);
        startActivity(intentButton);
    }
}