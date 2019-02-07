package com.example.johnniecooper.intentdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    public static final int BACKGROUD_CODE = 1;
    Button setBackground;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBackground = findViewById(R.id.setBackgroundButton);


        setBackground.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), SelectImage.class);
                startActivityForResult(myIntent, BACKGROUD_CODE);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode ==BACKGROUD_CODE && resultCode == Activity.RESULT_OK){
            Bundle extras = data.getExtras();

            if(extras!= null){
                int imageID = extras.getInt("imageID");
                ConstraintLayout currentLayout = findViewById(R.id.mainLayout);
                currentLayout.setBackground(getDrawable(imageID));
            }
        }

    }

}
