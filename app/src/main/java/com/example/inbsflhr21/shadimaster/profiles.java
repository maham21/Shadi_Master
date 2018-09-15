package com.example.inbsflhr21.shadimaster;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class profiles extends Fragment
{

    ListView list;
    String[] Names = new String[]{"Amna","Shahid","Saba","Ali"};
    String[] age = new String[]{"24","27","25","29"};
       int[] images = {R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background};
    ArrayList<HashMap<String, String>> mProfiles= new ArrayList<HashMap<String, String>>();

    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_profiles, container, false);
        display_list(view);
        return view;
    }
    public void display_list(View view)
    {
        list = (ListView) view.findViewById(R.id.Listview);
        for (int i = 0; i < Names.length; i++)
        {
            HashMap<String, String> hash = new HashMap<>();
            hash.put("KEY_IMG", images[i] + "");  //image is an integer while hashmap is string thats why we concatenate,add an empty string
            hash.put("KEY_name", Names[i]);
            hash.put("KEY_age", age[i]);

            mProfiles.add(hash);
        }
        SimpleAdapter adapter = new SimpleAdapter(this.getActivity(), mProfiles, R.layout.single_row, new String[]{"KEY_IMG", "KEY_name", "KEY_age"}, new int[]{R.id.imageView2, R.id.textView4, R.id.textView7});
        list.setAdapter(adapter);
    }
}
