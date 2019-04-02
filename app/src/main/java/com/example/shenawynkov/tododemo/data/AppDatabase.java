package com.example.shenawynkov.tododemo.data;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {TodoEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TodoDao todoDao();
    private static AppDatabase INSTANCE;

    public  static AppDatabase getAppDatabase(Context context)
    {
 if (INSTANCE ==null)
     INSTANCE=  Room.databaseBuilder(context.getApplicationContext(),
             AppDatabase.class, "database-name").build();
 return INSTANCE;
    }
    public static void destroyInstance() {
        INSTANCE = null;
    }
}
