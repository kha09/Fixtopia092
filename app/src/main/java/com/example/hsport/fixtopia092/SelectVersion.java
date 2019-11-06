package com.example.hsport.fixtopia092;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SelectVersion extends AppCompatActivity {
//    ExpandableLinearLayout exp ;
    RecyclerView recyclerView;
    ArrayList<Versions> list;
    Button button;
    private AdapterVersionClass adapterClass;
    private FirebaseFirestore firebaseFirestore;
    private static final String TAG = "FireLog";
    private String company2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_version);
        recyclerView = findViewById(R.id.rvSelectPhoneVersion);
        list = new ArrayList<>();
        button = findViewById(R.id.btnSelectVersion);
        adapterClass = new AdapterVersionClass(list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterClass);
        firebaseFirestore = FirebaseFirestore.getInstance();
        Intent intent = getIntent();
        company2 = intent.getStringExtra("Logo");


        firebaseFirestore.collection(company2).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if(e != null){
                    Log.d(TAG, "Error :" + e.getMessage());
                }
                for(DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()){
                    if(doc.getType() == DocumentChange.Type.ADDED){
                        Versions versions = doc.getDocument().toObject(Versions.class);
                        list.add(versions);

                        adapterClass.notifyDataSetChanged();
                    }
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(AdapterVersionClass.ccc.isEmpty()) {
                    Toast.makeText(SelectVersion.this, "Version is empty", Toast.LENGTH_SHORT).show();

                } else {
                        Toast.makeText(SelectVersion.this, AdapterVersionClass.ccc, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SelectVersion.this, select_problem.class);
                        intent.putExtra("com" , company2);
                        startActivity(intent);
                    }
                }

        });



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AdapterVersionClass.ccc = "";

    }
}
