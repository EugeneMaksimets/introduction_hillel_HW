package com.poncho.testnumber;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.poncho.testnumber.database.DatabaseService;
import com.poncho.testnumber.entity.HistoryEntity;
import com.poncho.testnumber.entity.RequestEntity;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Intent intent;
    private TextView textView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.editTextNumber);
        textView.setInputType(InputType.TYPE_CLASS_NUMBER);
        listView = findViewById(R.id.listView);
        updateHistory();
    }

    @Override
    public void onBackPressed() {
        intent = new Intent(this, MainActivity.class);
        updateHistory();
        startActivity(intent);
    }

    public void getFact(View view) {
        try {
            int number = Integer.parseInt(textView.getText().toString());
            startSecondActivity(false, false, number, "");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void getRandomFact(View view) {
        startSecondActivity(true, false, 0, "");
    }

    private void startSecondActivity(boolean random, boolean isHistory, int number, String historyInfo) {
        RequestEntity requestEntity = new RequestEntity(random, isHistory, number, historyInfo);
        InterestingFact.setResponseEntity(requestEntity);
        intent = new Intent(this, InterestingFact.class);
        startActivity(intent);
    }

    private void updateHistory() {
        DatabaseService databaseService = new DatabaseService();
        List<HistoryEntity> historyEntitiesList = databaseService.getAll(this);
        Collections.reverse(historyEntitiesList);
        HistoryEntity[] historyEntitiesArray = historyEntitiesList.toArray(new HistoryEntity[0]);
        String[] info = new String[historyEntitiesArray.length];
        for (int i = 0; i < info.length; i++) {
            info[i] = historyEntitiesArray[i].getInfo();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_view_item, R.id.info, info);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                TextView textView = (TextView) view.findViewById(R.id.info);
                String text = textView.getText().toString();
                startSecondActivity(false, true, 0, text);
            }
        });
    }

}