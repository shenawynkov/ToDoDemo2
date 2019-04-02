package com.example.shenawynkov.tododemo.dbBackground;

import android.content.Context;
import android.os.AsyncTask;

import com.example.shenawynkov.tododemo.adapter.MyAdapter;
import com.example.shenawynkov.tododemo.data.AppDatabase;
import com.example.shenawynkov.tododemo.data.TodoEntity;

import java.util.ArrayList;
import java.util.List;

public class Tasks {
    public  class InsertTask extends AsyncTask<TodoEntity,Void,Void>
    { public  Context context;
        AppDatabase db;

        public InsertTask(Context tcontext) {
            context = tcontext;
             db = AppDatabase.getAppDatabase(context);

        }



        @Override
        protected Void doInBackground(TodoEntity... todoEntities) {
            db.todoDao().insertAll(todoEntities[0]);
            return null;
        }
    }
    public  class getTasks extends AsyncTask<Void,Void,List<TodoEntity>>
    { public  Context context;
     MyAdapter mAdapter;
        AppDatabase db;
         List<TodoEntity> todoEntities ;

        public getTasks(Context tcontext,MyAdapter myAdapter) {
            context = tcontext;
           mAdapter= myAdapter;
             db = AppDatabase.getAppDatabase(context);

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            todoEntities=new ArrayList<>();
        }

        @Override
        protected List<TodoEntity> doInBackground(Void... voids) {
            todoEntities = db.todoDao().getAll();

            return todoEntities;
        }

        @Override
        protected void onPostExecute(List<TodoEntity> todoEntities) {
            super.onPostExecute(todoEntities);
            mAdapter.setData(todoEntities);
            mAdapter.notifyDataSetChanged();

        }
    }



    public  class UpdateTask extends AsyncTask<TodoEntity,Void,Void>
    { public  Context context;
        AppDatabase db;
        public UpdateTask(Context tcontext) {
             db = AppDatabase.getAppDatabase(context);
            context = tcontext;
        }




        @Override
        protected Void doInBackground(TodoEntity... todoEntities) {
            db.todoDao().updateEntity(todoEntities[0].tid,todoEntities[0].isTodoFinished());

            return null;
        }
    }
    }
