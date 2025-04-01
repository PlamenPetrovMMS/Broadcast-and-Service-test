package com.example.acceptanceapp2;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static androidx.core.content.ContextCompat.startActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class TestReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("TEST_ACTION")){
//            Toast.makeText(context, "TEST_ACTION received", Toast.LENGTH_LONG).show();
            Log.d("TestReceiver", "Broadcase received : TEST_ACTION, jumping into ActivityC");
            context.startActivity(new Intent(context, ActivityC.class).setFlags(FLAG_ACTIVITY_NEW_TASK));
        }
    }
}
