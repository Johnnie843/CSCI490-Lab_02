package com.example.johnniecooper.intentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class SelectImage extends AppCompatActivity {

        public  static final String DEBUG_TAG = "Image Selection Logging";
        private ImageView superMoon;
        private ImageView waterFall;
        private int imageID;

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.image_select);

            superMoon = findViewById(R.id.supermoon);
            waterFall = findViewById(R.id.waterfall);

            superMoon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    imageID = R.drawable.supermoon;
                    Log.i(DEBUG_TAG, "Supermoon Image Selected:" + imageID);
                    finish();
                }
            });

            waterFall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    imageID = R.drawable.waterfall;
                    Log.i(DEBUG_TAG, "Waterfall Image Selected:" + imageID);
                    finish();
                }
            });
        }
        @Override
        public void finish() {


            Intent intent = new Intent();
            intent.putExtra("imageID", imageID);

            setResult(RESULT_OK, intent);
            super.finish();
    }

}
