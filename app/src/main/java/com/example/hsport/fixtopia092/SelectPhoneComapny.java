package com.example.hsport.fixtopia092;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class SelectPhoneComapny extends AppCompatActivity {
    private FirebaseFirestore firebaseFirestore;
    private ArrayList<Phones> list;
    private RecyclerView recyclerView;
    private AdapterClass adapterClass;
    private static final String TAG = "Firelog";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_phone_comapny);
        recyclerView = findViewById(R.id.rvList);
        list = new ArrayList<>();
        adapterClass = new AdapterClass(list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapterClass);
        firebaseFirestore = FirebaseFirestore.getInstance();

        firebaseFirestore.collection("Phones").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if(e != null){
                    Log.d(TAG, "Error :" + e.getMessage());
                }
                for(DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()){
                    if(doc.getType() == DocumentChange.Type.ADDED){
                        Phones phones = doc.getDocument().toObject(Phones.class);
                        list.add(phones);

                        adapterClass.notifyDataSetChanged();
                    }
                }
            }
        });
    }
}
