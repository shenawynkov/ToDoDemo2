package com.example.shenawynkov.tododemo.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TodoDao {
    @Query("SELECT * FROM TodoEntity")
    List<TodoEntity> getAll();


    @Query("SELECT * FROM todoEntity WHERE todo_finished =0 ")
    List<TodoEntity> loadAllunfinished();

    @Query("UPDATE TodoEntity SET  todo_finished = :finished WHERE id = :id")
            void  updateEntity(int id, boolean finished);

    @Insert
    void insertAll(TodoEntity... entities);
    @Update
    void update(TodoEntity todoEntity);
    @Delete
    void delete(TodoEntity entity);
}
