package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvStart = findViewById(R.id.tvStart);
        TextView tvTime = findViewById(R.id.tvTime);

        EditText edMinutes = findViewById(R.id.edMinutes);
        EditText edSeconds = findViewById(R.id.edSeconds);

        tvStart.setOnClickListener(v ->{
            new CountDownTimer(((Integer.parseInt(edMinutes.getText().toString()) * 60 * 1000) + (Integer.parseInt(edSeconds.getText().toString()) * 1000)), 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    tvTime.setText("Осталость: " +  (millisUntilFinished / 1000 / 60) + " минут/(ы) " + (millisUntilFinished / 1000 % 60) + " секунд");
                }

                @Override
                public void onFinish() {
                    Toast.makeText(MainActivity.this, "Время окончено", Toast.LENGTH_LONG).show();
                }
            }.start();
        });
    }
}