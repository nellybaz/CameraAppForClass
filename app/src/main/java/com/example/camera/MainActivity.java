package com.example.camera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private static final int requestCode_ = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image_view);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == requestCode_ && resultCode == RESULT_OK){
            Bundle bundle = data.getExtras();
            Bitmap imageBitmap = (Bitmap) bundle.get("data");
            imageView.setImageBitmap(imageBitmap);
        }


    }

    public void handleCamera(View view) {
        Intent takeImageIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(takeImageIntent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(takeImageIntent, requestCode_);
        }

    }
}
