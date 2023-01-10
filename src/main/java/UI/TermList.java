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
import Entity.Term;

public class TermList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerView recyclerView = findViewById(R.id.recyclerTermView);
        Repository repo = new Repository(getApplication());
        ArrayList<Term> termArrayList = repo.getAllTerms();
        final TermAdapter termAdapter = new TermAdapter(this);
        recyclerView.setAdapter(termAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        termAdapter.setTermItems(termArrayList);
    }

    @SuppressLint("ResourceType")
    public boolean onTermOption(Menu menu){
        getMenuInflater().inflate(R.layout.activity_term_list,menu);
        return  true;
    }

    public boolean onTermSelected(MenuItem item){
        if (item.getItemId()==android.R.id.home){
                this.finish();
                return  true;
        }
        else {
            return onTermSelected(item);
        }
    }

    /**
     * Navigates to a list of the courses associated with the term.
     * @param view
     */
    public void EnterCourseList(View view) {
        Intent intent = new Intent(TermList.this, CourseList.class);
        startActivity(intent);
    }

    public void EnterHome(View view) {
        Intent intent = new Intent(TermList.this,TermList.class);
        startActivity(intent);
    }

    public void EnterTermDetail(View view) {
        Intent intent = new Intent(TermList.this, TermDetail.class);
        startActivity(intent);
    }
}