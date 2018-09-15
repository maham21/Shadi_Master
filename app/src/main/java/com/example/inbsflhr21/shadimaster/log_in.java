package com.example.inbsflhr21.shadimaster;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class log_in extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private EditText et_email;
    private EditText et_pass;

    View view;
    Button button;
    public static final String TAG_login_fragment = "TAG_fragment_log_in";
    public log_in() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       /* //Fragment newFragment = new ExampleFragment();
        sign_in newFragment = new sign_in();
        Fragment sign_in = new Fragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack if needed
        transaction.replace(R.id.your_placeholder, sign_in);
       /// transaction.addToBackStack(null);
        transaction.commit();*/
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_log_in, container, false);
        //final log_in getActivity = this;
        //final log_in obj1 = new log_in();
        TextView txt;
        button = (Button) view.findViewById(R.id.btn_login);
        txt = (TextView) view.findViewById(R.id.txtsignup);
        et_email = view.findViewById(R.id.et_email);//for validation
        et_pass = view.findViewById(R.id.et_pass);
        //Button buttonSayHi = (Button) view.findViewById(R.id.btn_login);
        button.setOnClickListener(new View.OnClickListener()
        {
           // this.et_email = et_email;
            //this.b = et_pass;
            @Override
            public void onClick(View view)
            {

                final String email = et_email.getText().toString();
                final String pass = et_pass.getText().toString();

                if (email.equals("maham") && pass.equals("okay"))
                {
                    Intent intent = new Intent(getActivity().getApplication(), Drawer_activity.class);
                    startActivity(intent);

                }
                else
                {
                        et_email.setError("Invalid Email");
                        et_pass.setError("Invalid Email");
                       // final AlertDialog.Builder adb = new AlertDialog.Builder(getActivity().getApplicationContext());

                    final AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());

                        adb.setMessage("Invalid email or password");
                        adb.setTitle("Error");
                       /*adb.setNeutralButton("Sign up", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                Intent intent = new Intent(getActivity().getApplication(), sign_in.class);
                                startActivity(intent);

                            }
                        });adb.show();
                        adb.setPositiveButton("Sign up",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent intent = new Intent(getActivity().getApplication(), sign_in.class);
                                startActivity(intent);

                            }
                        });
*/
                    adb.show();
                 }
            }
        });
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             //   Intent intent = new Intent(getActivity().getApplication(), sign_in.class);
               // startActivity(intent);
               mreplaceFragment(new sign_in());
            }
        });
         return view;
       // break;
        //return ;
    }
    public void mreplaceFragment(Fragment fragment) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.your_placeholder, fragment);
        ft.commit();
    }


}

