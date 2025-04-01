package com.example.acceptanceapp2;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityB extends AppCompatActivity {

//    private MyReceiver myReceiver = new MyReceiver();
//    private TestReceiver testReceiver = new TestReceiver();
    TextView textView;
    Button startButton;
    Button stopButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_b);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textView = (TextView) findViewById(R.id.textViewActivityB);

        startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
//                registerReceiver(myReceiver, new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));
//                registerReceiver(testReceiver, new IntentFilter("TEST_ACTION"), RECEIVER_EXPORTED);
                textView.setText("ON");
                startService(new Intent(getBaseContext(), MyService.class));
            }
        });

        stopButton = (Button) findViewById(R.id.stopButton);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                unregisterReceiver(myReceiver);
//                unregisterReceiver(testReceiver);
                textView.setText("OFF");
                stopService(new Intent(getBaseContext(), MyService.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
//        unregisterReceiver(myReceiver);
        super.onDestroy();
    }
}