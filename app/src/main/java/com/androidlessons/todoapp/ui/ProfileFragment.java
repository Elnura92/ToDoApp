package com.androidlessons.todoapp.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.androidlessons.todoapp.R;


public class ProfileFragment extends Fragment {

    private ImageView imgFromGallery;
    private Button btnOpen;
    public static final int REQUEST_CODE_PHOTO = 101;
    private Uri imgUri;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imgFromGallery = view.findViewById(R.id.img_from_gallery);
        btnOpen = view.findViewById(R.id.btn_open_gallery);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQUEST_CODE_PHOTO);
            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_PHOTO && resultCode == requireActivity().RESULT_OK && data!= null) {
            imgUri = data.getData();
            imgFromGallery.setImageURI(imgUri);
        }else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}