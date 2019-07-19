package khoapham.ptp.phamtanphat.calendarandroid10052019;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calendar calendar = Calendar.getInstance();
//        int ngay = calendar.get(Calendar.DATE);
//        int thang = calendar.get(Calendar.MONTH);
//        int nam = calendar.get(Calendar.YEAR);
//        Notifcation,
//                BroadcastReceiver,
//                PendingIntent,
//                Alarm,
//                Calendar
        long currentTime = calendar.getTimeInMillis();
        long currentTimeSystem = System.currentTimeMillis();

//        int ngay = (int) (currentTime / (60 * 60 * 24 * 1000));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Log.d("BBB",simpleDateFormat.format(currentTime));
    }
}
