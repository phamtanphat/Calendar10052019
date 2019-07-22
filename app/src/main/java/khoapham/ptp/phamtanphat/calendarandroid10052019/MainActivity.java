package khoapham.ptp.phamtanphat.calendarandroid10052019;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtSoluong;
    Button btnTinh;
    EditText edtNgaymin, edtNgaymax;
    Calendar calendarMin,calendarMax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Calendar calendar = Calendar.getInstance();
//        int ngay = calendar.get(Calendar.DATE);
//        int thang = calendar.get(Calendar.MONTH);
//        int nam = calendar.get(Calendar.YEAR);
//        Notifcation,
//                BroadcastReceiver,
//                PendingIntent,
//                Alarm,
//                Calendar
//        long currentTime = calendar.getTimeInMillis();
//        long currentTimeSystem = System.currentTimeMillis();

//        int ngay = (int) (currentTime / (60 * 60 * 24 * 1000));
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
//        Log.d("BBB",simpleDateFormat.format(currentTime));
        edtNgaymax = findViewById(R.id.edittextNgaymax);
        edtNgaymin = findViewById(R.id.edittextNgaymin);
        btnTinh = findViewById(R.id.buttonTinhngay);
        txtSoluong = findViewById(R.id.textviewSoluong);

        calendarMin = Calendar.getInstance();
        edtNgaymin.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edittextNgaymin:
//                timepickerdialogMin();
                datepickerdialogMin();
                return;
            case R.id.edittextNgaymax:
                return;
            default:
                return;
        }
    }

    private void datepickerdialogMin() {
        int year = calendarMin.get(Calendar.YEAR);
        int month = calendarMin.get(Calendar.MONTH);
        int date = calendarMin.get(Calendar.DATE);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this , new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendarMin.set(year , month , dayOfMonth);
            }
        },year,month,date);
        datePickerDialog.show();
    }

//    private void timepickerdialogMin() {
//
//        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
//            @Override
//            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//
//            }
//        },10 ,20,true);
//        timePickerDialog.show();
//    }
}
