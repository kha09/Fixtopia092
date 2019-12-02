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
    TextView tvPrice;
    Button btnCart;
//    String [][] listString;
    String [] values = {"ايفون 7","ايفون 8","ايفون اكس"};
    String [] problems = {"عطل بالكاميرا","عطل بالشاشة","عطل بالسماعة"};
    String [][] price = {{"111","222","511"},{"333","444","522"},{"311","411","533"}};

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


        //working method for setting up price
        for(int i =0; i<values.length; i++){
                for(int g=0; g<problems.length;g++){
                    if(bow.equals(values[i]) && sow.equals(problems[g])){
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
