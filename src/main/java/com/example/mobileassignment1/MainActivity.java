package com.example.mobileassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startCalcluationOnClick(View view) {
        //Create an explict intent to start new activity using the Calculator class
        Intent intent = new Intent(MainActivity.this,Calculator.class);
        startActivity(intent);
    }
}