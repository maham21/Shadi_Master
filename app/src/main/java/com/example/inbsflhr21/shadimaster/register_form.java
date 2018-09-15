package com.example.inbsflhr21.shadimaster;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;


public class register_form extends Fragment {

    Button next;
    Spinner reg_pfor_spin;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_register_form, container, false);
        //Button next = (Button) view.findViewById(R.id.next);
        next = (Button) view.findViewById(R.id.nextbtn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                mreplaceFragment(new register_form2());

            }
        });
        return view;
    }

  public void initiateview (View view){
      reg_pfor_spin = view.findViewById(R.id.reg_pfor_spin);

  }
public void mreplaceFragment(Fragment fragment) {
      FragmentTransaction ft = getFragmentManager().beginTransaction();
      ft.replace(R.id.your_placeholder, fragment);
      ft.commit();
  }
}
