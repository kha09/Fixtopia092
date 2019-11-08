package com.example.hsport.fixtopia092;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserCart extends AppCompatActivity {
    TextView tvCompany;
    TextView tvMobileVer;
    TextView tvProblems;
    Button btnCart;
//    String [][] listString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_cart);
        setupUi();
        setValues();
//        listString[0][0] = "Table";
//        listString[0][1] = "عطل بالشاشة";

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserCart.this, UserInfo.class);
                startActivity(intent);
            }
        });


    }

    private void setValues(){
        Intent intent = getIntent();
        String low = intent.getStringExtra("passCompany3");
        String bow = intent.getStringExtra("passVersion2");
        String sow = intent.getStringExtra("passProblem");

        tvCompany.setText(low);
        tvMobileVer.setText(bow);
        tvProblems.setText(sow);
    }

    private void setupUi(){
        tvCompany = findViewById(R.id.tvComapny);
        tvMobileVer = findViewById(R.id.tvMobileVer);
        tvProblems = findViewById(R.id.tvProblems);

        btnCart = findViewById(R.id.btnCart);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AdapterProblemsClass.vvv = "";

    }
}
