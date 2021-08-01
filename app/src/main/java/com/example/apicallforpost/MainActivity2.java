package com.example.apicallforpost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView email;
    private TextView passow;
    private TextView title;
    private TextView body;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        email=findViewById(R.id.name);
        passow=findViewById(R.id.age);
        title=findViewById(R.id.title);
        body=findViewById(R.id.body);
    }
}