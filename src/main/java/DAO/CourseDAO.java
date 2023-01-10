package DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;

import Entity.Course;

@Dao
public interface CourseDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Course course);

    @Update
    void update(Course course);

    @Delete
    void delete(Course course);

    @Query(value = "SELECT * FROM courseTable ORDER BY courseID ASC")
    ArrayList<Course> getAllCourses();

    @Query(value = "SELECT * FROM courseTable WHERE courseID = courseID")
    ArrayList<Course> getAssocCourses();

}
