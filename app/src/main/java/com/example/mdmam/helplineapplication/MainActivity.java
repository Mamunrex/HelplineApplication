package com.example.mdmam.helplineapplication;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;
    private ImageView onClickMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickMessage = findViewById(R.id.onClickMessage);
    }
    //--------Call Permissions----------
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case MY_PERMISSIONS_REQUEST_CALL_PHONE:{
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

                }else {
                    switch (requestCode) {
                        case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                            } else {

                            }
                        }
                    }
                }
            }
        }
    }
    //-----onClickCall -------
    public void onClickCall(View v) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+999));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},MY_PERMISSIONS_REQUEST_CALL_PHONE);
            return;
        }
        startActivity(intent);
    }

    public void onClickMessage(View v) {
       try {
           Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("smsto:"+999));
           if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
               ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);
               return;
           }
           startActivity(intent);
       }catch (Exception e){
       }
    }
    public void onClickEmail(View v) {
        Intent intent = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"+"mamun@gmail.com"));
        startActivity(intent);
    }
    public void onClickVisit(View v) {
        Intent intent = new Intent(Intent.ACTION_SEND, Uri.parse("https://help.com"));
            startActivity(intent);

    }

}
