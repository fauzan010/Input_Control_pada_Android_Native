package com.example.inputcontrol2;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import android.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText etPhone;
    Button btnDate, btnAlert, btnToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPhone = findViewById(R.id.etPhone);
        btnDate = findViewById(R.id.btnDate);
        btnAlert = findViewById(R.id.btnAlert);
        btnToast = findViewById(R.id.btnToast);

        btnDate.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
                    (view, year1, month1, dayOfMonth) -> {
                        Toast.makeText(MainActivity.this,
                                "Tanggal dipilih: " + dayOfMonth + "/" + (month1 + 1) + "/" + year1,
                                Toast.LENGTH_SHORT).show();
                    }, year, month, day);
            dialog.show();
        });

        btnAlert.setOnClickListener(v -> {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Konfirmasi")
                    .setMessage("Apakah kamu yakin ingin keluar?")
                    .setPositiveButton("Ya", (dialog, which) -> {
                        Toast.makeText(MainActivity.this, "Kamu memilih YA", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Tidak", null)
                    .show();
        });

        btnToast.setOnClickListener(v -> {
            String nomor = etPhone.getText().toString();
            Toast.makeText(MainActivity.this, "Nomor Anda: " + nomor, Toast.LENGTH_SHORT).show();
        });
    }
}
