package hk.ust.cse.comp107x.notificationclick;

import android.app.Notification;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.button:
                NotificationCompat.Builder notificationBuilder = (NotificationCompat.Builder) new NotificationCompat
                        .Builder(MainActivity.this)
                        .setSmallIcon(android.R.drawable.stat_notify_error)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .setContentTitle("Hello!")
                        .setContentText("Hello World xD");
                notificationBuilder.setDefaults(
                        Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(MainActivity.this);
                notificationManager.notify(1, notificationBuilder.build());
                break;
            default:
                break;
        }
    }
}
