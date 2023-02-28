package com.poncho.testnumber.database;

import android.content.Context;
import com.poncho.testnumber.entity.HistoryEntity;
import java.util.List;

public class DatabaseService {

    public void saveToDatabase (int number, String info, Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        HistoryEntity historyEntity = new HistoryEntity();
        historyEntity.setNumber(number);
        historyEntity.setInfo(info);
        db.historyEntityDao().insert(historyEntity);
    }

    public List<HistoryEntity> getAll(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        return db.historyEntityDao().getAll();
    }
}
