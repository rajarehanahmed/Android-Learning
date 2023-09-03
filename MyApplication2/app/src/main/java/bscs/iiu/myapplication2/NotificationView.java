package bscs.iiu.myapplication2;

import android.app.Activity;
import android.app.NotificationManager;

public class NotificationView extends Activity {

    //---look up the notification manager service---
    NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//---cancel the notification that we started---
nm.cancel(getIntent().getExtras().getInt("notificationID"));
}
