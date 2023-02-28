package com.poncho.testnumber.entity;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface HistoryEntityDao {

    @Query("SELECT * FROM history")
    List<HistoryEntity> getAll();

    @Insert
    void insert(HistoryEntity... historyEntities);

    @Delete
    void delete(HistoryEntity historyEntity);
}
