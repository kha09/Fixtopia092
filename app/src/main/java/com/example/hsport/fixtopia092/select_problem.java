package com.example.hsport.fixtopia092;

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

public class select_problem extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Problems> list;
    Button button;
    private AdapterProblemsClass adapterClass;
    private FirebaseFirestore firebaseFirestore;
    private static final String TAG = "FireLog";
    private String company;
    private String getVersion;




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
        button = findViewById(R.id.btnSelectProblem);
        Intent intent = getIntent();
        company = intent.getStringExtra("passCompany2");
        getVersion = intent.getStringExtra("passVersion");


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

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(AdapterProblemsClass.vvv.isEmpty()){
                    Toast.makeText(select_problem.this, " Problem isEmpty", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(select_problem.this, AdapterProblemsClass.vvv, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(select_problem.this, UserCart.class);
                    intent.putExtra("passCompany3" , company);
                    intent.putExtra("passVersion2", getVersion);
                    intent.putExtra("passProblem", AdapterProblemsClass.vvv);
                    startActivity(intent);
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AdapterProblemsClass.vvv = "";
        AdapterVersionClass.ccc = "";
        AdapterProblemsClass.row_index2 = -1;

    }
}
