package com.project.art.digital.android.myapplication5;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

        static final int REQUEST_IMAGE_CAPTURE = 1;

        private void dispatchTakePictureIntent() {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);
        }

        public void onClickLogOut(View v) {
            Intent submit = new Intent(Main2Activity.this, MainActivity.class);
            startActivity(submit);
        }

        public void onClickCamera(View v) {
            dispatchTakePictureIntent();
        }

        public void onClickGoogleMap(View v) {
            String addressString = "1600 Amphitheatre Parkway, CA";
            Uri.Builder builder = new Uri.Builder();
            builder.scheme("geo")
                    .path("0,0")
                    .query(addressString);
            Uri addressUri = builder.build();

            showMap(addressUri);
        }

        private void showMap(Uri geoLocation) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(geoLocation);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    }