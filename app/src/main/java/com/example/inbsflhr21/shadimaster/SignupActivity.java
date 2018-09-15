package com.example.inbsflhr21.shadimaster;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
//import android.support.v4.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

public class SignupActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment newFragment = new log_in();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.your_placeholder, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
