package com.example.hsport.fixtopia092;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

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



    }
}
