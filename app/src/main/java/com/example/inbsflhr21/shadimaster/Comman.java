package com.example.inbsflhr21.shadimaster;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

/**
 * Created by inbsflhr21 on 9/11/2018.
 */

public class Comman
{
    public static void replaceFragment(Fragment from, Fragment fragment, Bundle bundle){

        //getFragmentManager().popBackStackImmediate();
        FragmentTransaction transaction = from.getFragmentManager().beginTransaction();
        transaction.replace(R.id.your_placeholder, fragment);
        fragment.setArguments(bundle);
        transaction.commit();
    }

}
