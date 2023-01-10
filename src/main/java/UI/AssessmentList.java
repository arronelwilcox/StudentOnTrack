package UI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentontrack.R;

import java.util.ArrayList;

import Database.Repository;
import Entity.Assessment;

public class AssessmentList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment_list);
        RecyclerView recyclerView = findViewById(R.id.recyclerTermView);
        Repository repo = new Repository(getApplication());
        ArrayList<Assessment> courseArrayList = repo.getAllAssessments();
        final AssessmentAdapter courseAdapter = new AssessmentAdapter(this);
        recyclerView.setAdapter(courseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        courseAdapter.setAssessmentItems(courseArrayList);
    }
    @SuppressLint("ResourceType")
    public boolean onAssessmentOption(Menu menu){
        getMenuInflater().inflate(R.layout.activity_assessment_list,menu);
        return  true;
    }

    public boolean onAssessmentSelected(MenuItem item){
        if (item.getItemId()==android.R.id.home){
            this.finish();
            return  true;
        }
        else {
            return onAssessmentSelected(item);
        }
    }
    public void EnterHome(View view) {
        Intent intent = new Intent(AssessmentList.this,AssessmentList.class);
        startActivity(intent);
    }

    public void EnterAssessmentDetail(View view) {
        Intent intent = new Intent(AssessmentList.this, AssessmentDetail.class);
        startActivity(intent);
    }
}