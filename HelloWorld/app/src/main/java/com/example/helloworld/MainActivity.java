package com.example.helloworld;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();
    Button btn_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_click = (Button) findViewById(R.id.btn_click);

        btn_click.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //int num = Integer.parseInt()
        Log.d(TAG, "");
    }
}
