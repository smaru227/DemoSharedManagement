package com.example.demosharedmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    TextView textView;
    String key = "count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(key,MODE_PRIVATE);
        textView = findViewById(R.id.txtCount);

        setCounter(key);

    }

    protected int getCount(String key){
        return preferences.getInt(key,0);
    }
    protected void setCounter(String key){
        int count = getCount(key);

        textView.setText(String.valueOf(count));
    }
    public void getIncrement(View view) {
        int count = getCount(key);
        count++;
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key,count);
        editor.commit();
        setCounter(key);
    }

    public void getReset(View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key,0);
        editor.commit();
        setCounter(key);
    }

    public void getRemove(View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key);
        editor.commit();
        setCounter(key);
    }
}