package UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.studentontrack.R;

import Database.Repository;
import Entity.Assessment;
import Entity.Course;
import Entity.Term;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void EnterTermList(View view) {
        Intent intent = new Intent(MainActivity.this, TermList.class);
        startActivity(intent);
        Repository repo = new Repository(getApplication());
        Term term1 = new Term(1,"Fall Term","August 1, 2022","November 1,2022");
        Term term2 = new Term(2,"Winter Term","November 1, 2022","February 1,2022");
        Term term3 = new Term(3,"Spring Term","February 1, 2022","June 1,2022");
        Term term4 = new Term(4,"Summer Term","June 1, 2022","August 1,2022");
        repo.insertTerm(term1);
        repo.insertTerm(term2);
        repo.insertTerm(term3);
        repo.insertTerm(term4);
    }

    public void EnterCourseList(View view) {
        Intent intent = new Intent(MainActivity.this, CourseList.class);
        startActivity(intent);
        Repository repo = new Repository(getApplication());
        Course course1 = new Course(111,"Software Engineering",
                "Complete","Professor Pedro","ppedro@school.edu",
                111-111-1111, 1);
        Course course2 = new Course(222,"Biology",
                "Complete","Professor Chuck","pchuck@school.edu",
                111-222-1111, 2);
        Course course3 = new Course(333,"Chemistry",
                "Progress","Professor Billy","pbilly@school.edu",
                111-222-3333, 3);
        Course course4 = new Course(444,"Physics",
                "Progress","Professor Dawn","pdawn@school.edu",
                111-222-3333, 4);

        repo.insertCourse(course1);
        repo.insertCourse(course2);
        repo.insertCourse(course3);
        repo.insertCourse(course4);
    }

    public void EnterAssessmentList(View view) {
        Intent intent = new Intent(MainActivity.this, AssessmentList.class);
        startActivity(intent);
        Repository repo = new Repository(getApplication());

        Assessment assessment1 = new Assessment(1,"Software Assessment",
                "PA","project file","11-11-2022",111);
        Assessment assessment2 = new Assessment(2,"Biology Assessment",
                "OA","na","11-11-2022",222);
        Assessment assessment3 = new Assessment(3,"Chemistry Assessment",
                "PA","na","11-11-2022",333);
        Assessment assessment4 = new Assessment(4,"Physics Assessment",
                "OA","na","11-11-2022",444);

        repo.insertAssessment(assessment1);
        repo.insertAssessment(assessment2);
        repo.insertAssessment(assessment3);
        repo.insertAssessment(assessment4);

    }

}