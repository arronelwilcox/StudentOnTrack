package DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;

import Entity.Assessment;

@Dao
public interface AssessmentDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Assessment assessment);

    @Update
    void update(Assessment assessment);

    @Delete
    void delete(Assessment assessment);

    @Query(value = "SELECT * FROM assessmentTable ORDER BY assessmentID ASC")
    ArrayList<Assessment> getAllAssessments();

    @Query(value = "SELECT * FROM assessmentTable WHERE assessmentCourseID = assessmentCourseID")
    ArrayList<Assessment> getAssocAssessments();

}
