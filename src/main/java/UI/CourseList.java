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
import Entity.Course;

public class CourseList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerView recyclerView = findViewById(R.id.recyclerTermView);
        Repository repo = new Repository(getApplication());
        ArrayList<Course> courseArrayList = repo.getAllCourse();
        final CourseAdapter courseAdapter = new CourseAdapter(this);
        recyclerView.setAdapter(courseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        courseAdapter.setCourseItems(courseArrayList);
    }
    @SuppressLint("ResourceType")
    public boolean onCourseOption(Menu menu){
        getMenuInflater().inflate(R.layout.activity_course_list,menu);
        return  true;
    }

    public boolean onCourseSelected(MenuItem item){
        if (item.getItemId()==android.R.id.home){
            this.finish();
            return  true;
        }
        else {
            return onCourseSelected(item);
        }
    }
    public void EnterAssessmentList(View view) {
        Intent intent = new Intent(CourseList.this, AssessmentList.class);
        startActivity(intent);
    }

    public void EnterHome(View view) {
        Intent intent = new Intent(CourseList.this,CourseList.class);
        startActivity(intent);
    }

    public void EnterCourseDetail(View view) {
        Intent intent = new Intent(CourseList.this, CourseDetail.class);
        startActivity(intent);
    }
}