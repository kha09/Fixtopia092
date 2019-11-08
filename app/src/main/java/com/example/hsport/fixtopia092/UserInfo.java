package com.example.hsport.fixtopia092;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class UserInfo extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);


    }



    public void onBackPressed() {
        super.onBackPressed();
        AdapterProblemsClass.vvv = "";
        AdapterProblemsClass.row_index2 = -1;
    }

}
