package com.example.myfriend;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.os.Environment.getExternalStoragePublicDirectory;

public class MesageAtivity extends AppCompatActivity {

    private ImageButton btnSend, btnCamera, btnGallery;
    private ImageView img;
    private int GALLERY_REQUEST_CODE = 123;
    String pathToFile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesage_ativity);
        Mapping();
        if(Build.VERSION.SDK_INT>=23){
            requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
        }
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleBtnCamera();
            }
        });

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleBtnGallery();
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });
    }

    private void handleBtnGallery() {

            //Create an Intent with action as ACTION_PICK
            Intent intent=new Intent(Intent.ACTION_PICK);
            // Sets the type as image/*. This ensures only components of type image are selected
            intent.setType("image/*");
            //We pass an extra array with the accepted mime types. This will ensure only components with these MIME types as targeted.
            String[] mimeTypes = {"image/jpeg", "image/png"};
            intent.putExtra(Intent.EXTRA_MIME_TYPES,mimeTypes);
            // Launching the Intent
            startActivityForResult(intent,GALLERY_REQUEST_CODE);
    }

    private void handleBtnCamera() {
                Intent takePic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(takePic.resolveActivity(getPackageManager())!=null){
                    File photoFile = null;
                    photoFile = createPhotoFile();
                    if(photoFile!=null) {
                        pathToFile = photoFile.getAbsolutePath();
                        Uri photoUri = FileProvider.getUriForFile(MesageAtivity.this, "com.example.myfriend.fileprovider", photoFile);
                        takePic.putExtra(MediaStore.EXTRA_OUTPUT,photoUri);
                        startActivityForResult(takePic, 1);
                    }

                }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode==1){
                Bitmap bitmap = BitmapFactory.decodeFile(pathToFile);
                img.setImageBitmap(bitmap);
            }
            if(requestCode == GALLERY_REQUEST_CODE){
                Uri selectedImage = data.getData();
                img.setImageURI(selectedImage);
            }
        }

    }
    private File createPhotoFile() {
        String name = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File storageDir = getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File image = null;
        try {
            image = File.createTempFile(name, ".jpg", storageDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    private void Mapping() {
        btnCamera = (ImageButton) findViewById(R.id.btnCamera);
        btnGallery = (ImageButton) findViewById(R.id.btnGallery);
        btnSend = (ImageButton) findViewById(R.id.btnSend);
        img = (ImageView) findViewById(R.id.img);
    }
}
