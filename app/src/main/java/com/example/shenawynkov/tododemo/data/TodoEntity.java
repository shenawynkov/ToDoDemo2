package com.example.shenawynkov.tododemo.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity

public class TodoEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int tid;

    public String getTodoString() {
        return todoString;
    }

    public void setTodoString(String todoString) {
        this.todoString = todoString;
    }

    public boolean isTodoFinished() {
        return todoFinished;
    }

    public void setTodoFinished(boolean todoFinished) {
        this.todoFinished = todoFinished;
    }

    @ColumnInfo(name = "todo_string")
    public String todoString;
    @ColumnInfo(name = "todo_finished")
    public boolean todoFinished;


}
