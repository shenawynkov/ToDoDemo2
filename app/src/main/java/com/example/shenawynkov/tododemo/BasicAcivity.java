package com.example.shenawynkov.tododemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.shenawynkov.tododemo.service.NotificationService;

public class BasicAcivity extends AppCompatActivity {

    @Override
    protected void onPause() {
        super.onPause();

        Intent intent=new Intent(getApplicationContext(),NotificationService.class);
        startService(intent);
    }
}
