package com.example.collageapp.facutly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collageapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class UpdateFaculty extends AppCompatActivity {

    private Button fab;
    private RecyclerView soetDepartment, somDepartment, solDepartment, soeDepartment;
    private LinearLayout soetNoData, somNoData, solNoData, soeNoData;
    private List<TeacherData> list1, list2, list3, list4;
    private DatabaseReference reference, dbRef;
    private TeacherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);

        soetDepartment = findViewById(R.id.soetDepartment);
        somDepartment = findViewById(R.id.somDepartment);
        solDepartment = findViewById(R.id.solDepartment);
        soeDepartment = findViewById(R.id.soeDepartment);

        soetNoData = findViewById(R.id.soetNoData);
        somNoData = findViewById(R.id.somNoData);
        solNoData = findViewById(R.id.solNoData);
        soeNoData = findViewById(R.id.soeNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        soetDepartment();
        somDepartment();
        solDepartment();
        soeDepartment();

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpdateFaculty.this,AddTeacher.class));
            }
        });
    }

    private void soetDepartment() {
        dbRef = reference.child("SOET");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list1 = new ArrayList<>();
                if(!datasnapshot.exists()){
                    soetNoData.setVisibility(View.VISIBLE);
                    soetDepartment.setVisibility(View.GONE);
                }else{
                    soetNoData.setVisibility(View.GONE);
                    soetDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    soetDepartment.setHasFixedSize(true);
                    soetDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list1, UpdateFaculty.this, "SOET");
                    soetDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void somDepartment() {
        dbRef = reference.child("SOM");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list2 = new ArrayList<>();
                if(!datasnapshot.exists()){
                    somNoData.setVisibility(View.VISIBLE);
                    somDepartment.setVisibility(View.GONE);
                }else{
                    somNoData.setVisibility(View.GONE);
                    somDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    somDepartment.setHasFixedSize(true);
                    somDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list2, UpdateFaculty.this, "SOM");
                    somDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void solDepartment() {
        dbRef = reference.child("SOL");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list3 = new ArrayList<>();
                if(!datasnapshot.exists()){
                    solNoData.setVisibility(View.VISIBLE);
                    solDepartment.setVisibility(View.GONE);
                }else{
                    solNoData.setVisibility(View.GONE);
                    solDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    solDepartment.setHasFixedSize(true);
                    solDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list3, UpdateFaculty.this, "SOL");
                    solDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void soeDepartment() {
        dbRef = reference.child("SOE");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list4 = new ArrayList<>();
                if(!datasnapshot.exists()){
                    soeNoData.setVisibility(View.VISIBLE);
                    soeDepartment.setVisibility(View.GONE);
                }else{
                    soeNoData.setVisibility(View.GONE);
                    soeDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    soeDepartment.setHasFixedSize(true);
                    soeDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list4, UpdateFaculty.this, "SOE");
                    soeDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}