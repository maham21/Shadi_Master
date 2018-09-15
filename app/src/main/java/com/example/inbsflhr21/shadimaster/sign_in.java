package com.example.inbsflhr21.shadimaster;

import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class sign_in extends Fragment {

    Button signup;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_sign_in, container, false);
       //  signup_btn = (Button) view.findViewById(R.id.btn_signup);
        signup = (Button) view.findViewById(R.id.btn_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               mreplaceFragment( new profiles());

            }
        });
        return view;
    }
    public void mreplaceFragment(Fragment fragment)
    {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.your_placeholder, fragment);
        ft.commit();
    }
}
