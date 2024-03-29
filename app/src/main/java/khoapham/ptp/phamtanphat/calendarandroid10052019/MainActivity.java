package khoapham.ptp.phamtanphat.calendarandroid10052019;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
    SimpleDateFormat simpleDateFormat;
    long tongngay = 0;
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
        calendarMax = Calendar.getInstance();


        edtNgaymin.setOnClickListener(this);
        edtNgaymax.setOnClickListener(this);
        btnTinh.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edittextNgaymin:
//                timepickerdialogMin();
                datepickerdialogMin();
                return;
            case R.id.edittextNgaymax:
                datepickerdialogMax();
                return;
            case R.id.buttonTinhngay:
                calcalutorDate();
                return;
            default:
                return;
        }
    }

    private void calcalutorDate() {
        if (calendarMax.getTimeInMillis() - calendarMin.getTimeInMillis() > 0){
            tongngay = calendarMax.getTimeInMillis() - calendarMin.getTimeInMillis();
            txtSoluong.setText((tongngay / (24 * 60 * 60 * 1000) + " ngày"));
        }
    }

    private void datepickerdialogMax() {
        int year = calendarMax.get(Calendar.YEAR);
        int month = calendarMax.get(Calendar.MONTH);
        int date = calendarMax.get(Calendar.DATE);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this , new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendarMax.set(year , month , dayOfMonth);
                edtNgaymax.setText(formatDate(calendarMax.getTimeInMillis()));
            }
        },year,month,date);
        datePickerDialog.getDatePicker().setMinDate(calendarMin.getTimeInMillis() + (24 * 60 * 60 * 1000));
        datePickerDialog.show();
    }

    private String formatDate(long time){
        if (simpleDateFormat == null){
            simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        }
        return simpleDateFormat.format(time);
    }
    private void datepickerdialogMin() {
        int year = calendarMin.get(Calendar.YEAR);
        int month = calendarMin.get(Calendar.MONTH);
        int date = calendarMin.get(Calendar.DATE);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this , new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendarMin.set(year , month , dayOfMonth);
                edtNgaymin.setText(formatDate(calendarMin.getTimeInMillis()));
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
