package com.example.inbsflhr21.shadimaster;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;


public class register_form2 extends Fragment implements ImageInputHelper.ImageActionListener{


    Button back, submit, add;
    private ImageInputHelper imageInputHelper;
    ImageView imgprofile;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_register_form2, container, false);

        imageInputHelper = new ImageInputHelper(getActivity());
        imageInputHelper.setImageActionListener(this);

        imgprofile =  view.findViewById(R.id.imgprofile);

        back = (Button) view.findViewById(R.id.backbtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             mreplaceFragment(new register_form());
            }
        });

        submit = (Button) view.findViewById(R.id.btnsubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
                adb.setMessage("Your Profile has been submitted!");
                adb.show();
            }
        });
        add = (Button) view.findViewById(R.id.pic_btn);
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                  //      imgprofile(getActivity()getContext());
                        
                    }
                });

         return view;
    }

    public void mreplaceFragment(Fragment fragment) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.your_placeholder, fragment);
        ft.commit();


    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        imageInputHelper.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onImageSelectedFromGallery(Uri uri, File imageFile) {
        // cropping the selected image. crop intent will have aspect ratio 16/9 and result image
        // will have size 800x450
        imageInputHelper.requestCropImage(uri, 1000, 850, 16, 16);
    }

    @Override
    public void onImageTakenFromCamera(Uri uri, File imageFile) {
        imageInputHelper.requestCropImage(uri, 1000, 850, 16, 9);
    }

    @Override
    public void onImageCropped(Uri uri, File imageFile) {
        try {
            // getting bitmap from uri
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
            imgprofile.setImageBitmap(bitmap);
            Log.d("IMGARERRERER", "onImageCropped: " + bitmap);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}