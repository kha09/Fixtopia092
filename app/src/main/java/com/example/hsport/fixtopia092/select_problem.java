package com.example.hsport.fixtopia092;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class select_problem extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Problems> list;
    private AdapterProblemsClass adapterClass;
    private FirebaseFirestore firebaseFirestore;
    private static final String TAG = "FireLog";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_problem);
        recyclerView = findViewById(R.id.rvSelectProblem);

        list = new ArrayList<>();
        adapterClass = new AdapterProblemsClass(list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterClass);
        firebaseFirestore = FirebaseFirestore.getInstance();

        firebaseFirestore.collection("Problems").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if(e != null){
                    Log.d(TAG, "Error :" + e.getMessage());
                }
                for(DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()){
                    if(doc.getType() == DocumentChange.Type.ADDED){
                        Problems problems = doc.getDocument().toObject(Problems.class);
                        list.add(problems);

                        adapterClass.notifyDataSetChanged();
                    }
                }
            }
        });
    }
}
