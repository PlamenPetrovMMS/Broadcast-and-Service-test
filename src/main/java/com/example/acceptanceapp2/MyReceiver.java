package com.example.acceptanceapp2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
//            Toast.makeText(context, "Airplane mode changed", Toast.LENGTH_LONG).show();
            Log.d("MyReceiver", "Broadcast receviced : Airplane mode changed");
        }
    }
}
