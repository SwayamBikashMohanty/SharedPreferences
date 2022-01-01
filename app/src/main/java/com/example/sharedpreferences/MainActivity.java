package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private TextView total_glasses;

    //Step-1
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        total_glasses=findViewById(R.id.total_glasses);

        //Step-2
        sharedPreferences=getSharedPreferences("water_preferences",MODE_PRIVATE);
        //Before button click save default count value into sharedprefernces
        if(sharedPreferences!=null) {
            int count = sharedPreferences.getInt("Water_Count", 0);
            //Display default count value on textview
            total_glasses.setText(String.valueOf(count));
        }

    }

    public void drinkWater(View view) {
        //Step-3
        if(sharedPreferences!=null){
            //count of no.of glasses
            int count = sharedPreferences.getInt("Water_Count", 0) + 1;
            //Write to shared preferences
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("Water_Count",count);
            //commit
            editor.apply();
            //Display on Textview
            total_glasses.setText(String.valueOf(count));
        }

    }
}