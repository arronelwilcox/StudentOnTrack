package Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import DAO.AssessmentDAO;
import DAO.CourseDAO;
import DAO.TermDAO;
import Entity.Assessment;
import Entity.Course;
import Entity.Term;

@Database(entities = {Term.class , Course.class, Assessment.class}, version = 1, exportSchema = false)
public abstract class StudentDatabaseBuilder extends RoomDatabase {
    abstract public TermDAO termDAO();
    abstract public CourseDAO courseDAO();
    abstract public AssessmentDAO assessmentDAO();

    private static volatile StudentDatabaseBuilder INSTANCE ;

    static StudentDatabaseBuilder getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (StudentDatabaseBuilder.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), StudentDatabaseBuilder.class,
                            "studentDatabase").fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }
}
