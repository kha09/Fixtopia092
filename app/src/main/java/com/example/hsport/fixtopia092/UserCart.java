package com.example.hsport.fixtopia092;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class UserCart extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_cart);

        Intent intent = getIntent();
        textView = findViewById(R.id.tvComapny);
        String low = intent.getStringExtra("com2");
        textView.setText("ايفون");


    }
}
