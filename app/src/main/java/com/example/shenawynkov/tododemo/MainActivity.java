package com.example.shenawynkov.tododemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.shenawynkov.tododemo.data.AppDatabase;
import com.example.shenawynkov.tododemo.data.TodoEntity;
import com.example.shenawynkov.tododemo.dbBackground.Tasks;

public class MainActivity extends BasicAcivity {
   private EditText editText ;
   private Button button;
   private  Button myTodos;
   Tasks.InsertTask insertTask;
  AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String todo= editText.getText().toString();
                TodoEntity entity=new TodoEntity();
                entity.setTodoFinished(false);
                entity.setTodoString(todo);
                insertTask=new  Tasks().new InsertTask(getApplicationContext());
                insertTask.execute(entity);
                Intent intent =new Intent(MainActivity.this,ListActivity.class);
                startActivity(intent);



            }
        });
        myTodos=findViewById(R.id.button2);
        myTodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,ListActivity.class);
                startActivity(intent);
            }
        });


    }
}
