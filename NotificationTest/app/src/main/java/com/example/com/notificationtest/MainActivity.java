package com.example.com.notificationtest;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_notice:
                Intent intent = new Intent(this, NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                /*Notification notification = new NotificationCompat.Builder(this)
                        .setContentTitle("This is content title")
                        .setContentText("This is content text")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),
                                R.mipmap.ic_launcher))
                        .build();
                manager.notify(1, notification);*/
                /*Notification notification = new NotificationCompat.Builder(this)
                        .setContentInfo("Content info")
                    .setContentText("Content text")//设置通知内容
                    .setContentTitle("Content title")//设置通知标题
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                    .setSmallIcon(R.mipmap.ic_launcher)//不能缺少的一个属性
                    .setContentIntent(pi)
                    //.setSubText("Subtext")
                    //.setTicker("滚动消息......")
                    .setStyle(new NotificationCompat.BigTextStyle().bigText("Learn how to build" +
                            "notifications, send and sync data, and use voice actions. Get the official" +
                            "Android IDE and developer tools to build apps for Android."))
                    .setAutoCancel(true)
                    .setVibrate(new long[] {0, 1000, 1000, 1000})
                    .setWhen(System.currentTimeMillis()).build();*///设置通知时间，默认为系统发出通知的时间，通常不用设置
                Notification.Builder builder = new Notification.Builder(this);
                builder.setContentInfo("Content info")
                        .setContentText("Content text")//设置通知内容
                        .setContentTitle("Content title")//设置通知标题
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .setSmallIcon(R.mipmap.ic_launcher)//不能缺少的一个属性
                        .setContentIntent(pi)
                        //.setSubText("Subtext")
                        //.setTicker("滚动消息......")
                        .setAutoCancel(true)
                        .setVibrate(new long[] {0, 1000, 1000, 1000})
                        .setWhen(System.currentTimeMillis());//设置通知时间，默认为系统发出通知的时间，通常不用设置

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    NotificationChannel channel = new NotificationChannel("001","my_channel",NotificationManager.IMPORTANCE_DEFAULT);
                    channel.enableLights(true); //是否在桌面icon右上角展示小红点
                    channel.setLightColor(Color.GREEN); //小红点颜色
                    channel.setShowBadge(true); //是否在久按桌面图标时显示此渠道的通知
                    manager.createNotificationChannel(channel);
                    builder.setChannelId("001");
                }

                Notification n = builder.build();
                manager.notify(1,n);
                break;
            default:
                break;
        }
    }
}

