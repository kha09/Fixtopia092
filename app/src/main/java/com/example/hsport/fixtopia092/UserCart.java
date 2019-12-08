package com.example.hsport.fixtopia092;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserCart extends AppCompatActivity {
    TextView tvCompany;
    TextView tvMobileVer;
    TextView tvProblems;
    TextView tvPrice;
    Button btnCart;
//    String [][] listString;
    String [] iphone = {"ايفون 7","ايفون 8","ايفون اكس"};
    String [] samsung = {"سامسونج 10","سامسونج نوت 10","سامسونج 10 بلس"};
    String [] problems = {"عطل بالكاميرا","عطل بالشاشة","عطل بالسماعة"};
    String [][] price = {{"150","250","120"},{"170","270","150"},{"180","280","160"}};


//    String[][] price ={{"ايفون 7","ايفون 8"},{"عطل بالكاميرا","عطل بالشاشة"}};



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
        String ooo ="ايفون 7";
        String lll ="عطل بالكاميرا";
//        price[0][0] = "ايفون 7";
//        price[0][1] = "ايفون 8";
//        price[1][0] = "عطل بالكاميرا";
//        price[2][0] = "عطل بالشاشة";
//        price[1][1] = "111";
//        price[1][2] = "222";
//        price[2][1] = "333";
//        price[2][2] = "444";
        String[] bbb = new String[0];

        tvCompany.setText(low);
        tvMobileVer.setText(bow);
        tvProblems.setText(sow);
        // trash method dont use it
//        for(String s : values){
//            for(String b : problems){
//                if(bow.equals(s)&& sow.equals(b)){
//                    tvPrice.setText(price[s.indexOf(bow)][b.indexOf(sow)]);
//                }
//            }
//
//        }

        if(!low.isEmpty()){
            switch (low){
                case "أبل" : {
                    bbb = iphone;
                    break;
                }
                case "سامسونج" : {
                    bbb = samsung;
                    break;
                }
            }
        }
        //working method for setting up price
        for(int i =0; i<bbb.length; i++){
                for(int g=0; g<problems.length;g++){
                    if(bow.equals(bbb[i]) && sow.equals(problems[g])){
                        tvPrice.setText(price[i][g]);
                    }
                }
            }


        }







    private void setupUi(){
        tvCompany = findViewById(R.id.tvComapny);
        tvMobileVer = findViewById(R.id.tvMobileVer);
        tvProblems = findViewById(R.id.tvProblems);
        tvPrice = findViewById(R.id.tvPrice);

        btnCart = findViewById(R.id.btnCart);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AdapterProblemsClass.vvv = "";

    }
}
