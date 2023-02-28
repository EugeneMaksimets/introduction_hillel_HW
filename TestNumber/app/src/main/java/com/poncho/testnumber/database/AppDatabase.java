package com.poncho.testnumber.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.poncho.testnumber.entity.HistoryEntity;
import com.poncho.testnumber.entity.HistoryEntityDao;

@Database(entities = {HistoryEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract HistoryEntityDao historyEntityDao();
    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "search-history-test")
                    .allowMainThreadQueries().
                    build();
        }
        return instance;
    }

}