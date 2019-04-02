package com.example.shenawynkov.tododemo.service;

import android.app.IntentService;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.example.shenawynkov.tododemo.data.AppDatabase;
import com.example.shenawynkov.tododemo.R;
import java.util.Timer;
import java.util.TimerTask;


public class NotificationService extends IntentService {
    private AppDatabase db;
    final static String CHANNEL_ID = "1";

    @Override
    public void onCreate() {
        super.onCreate();
        db = AppDatabase.getAppDatabase(getApplicationContext());
        createNotificationChannel();
    }


    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public NotificationService(String name) {
        super(name);
    }

    public NotificationService() {
        super("sd");
    }

    @Override
    protected void onHandleIntent(Intent intent) {



        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle("Tasks")
                        .setContentText("you have unfinished  : " + db.todoDao().loadAllunfinished().size() + "  tasks.")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());
                notificationManager.notify(2, builder.build());

            }
        };
        Timer timer = new Timer();	    long delay = 2000;	    long intevalPeriod = 100 * 1000;
        timer.scheduleAtFixedRate(task,delay,intevalPeriod);


    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "tasks";
            String description = "show num of tasks";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
