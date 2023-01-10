package Database;

import android.app.Application;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import DAO.AssessmentDAO;
import DAO.CourseDAO;
import DAO.TermDAO;
import Entity.Assessment;
import Entity.Course;
import Entity.Term;

public class Repository {
    private TermDAO termDAO;
    private CourseDAO courseDAO;
    private AssessmentDAO assessmentDAO;
    private ArrayList<Term> allTerms;
    private ArrayList<Course> allCourse;
    private ArrayList<Assessment> allAssessments;

    private ArrayList<Term> relatedTerms;
    private ArrayList<Course> relatedCourse;
    private ArrayList<Assessment> relatedAssessments;

    private static int NUMBER_OF_THREADS = 4;
    static  final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public Repository(Application application){
        StudentDatabaseBuilder db = StudentDatabaseBuilder.getDatabase(application);
        termDAO = db.termDAO();
        courseDAO = db.courseDAO();
        assessmentDAO =db.assessmentDAO();
    }

    /**
     * Lambda Expression which creates a separate thread to asynchronously build the Term table
     * in the database as the program executes other functions.
     * @param term
     */
    public void insertTerm(Term term){
        databaseExecutor.execute(()->{
            termDAO.insert(term);
        });
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }


    /**
     * Lambda Expression which creates a separate thread to asynchronously build the Course table
     * in the database as the program executes other functions.
     * @param course
     */
    public void insertCourse(Course course){
        databaseExecutor.execute(()->{
            courseDAO.insert(course);
        });
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * Lambda Expression which creates a separate thread to asynchronously build the Assessment table
     * in the database as the program executes other functions.
     * @param assessment
     */
    public void insertAssessment(Assessment assessment){
        databaseExecutor.execute(()->{
            assessmentDAO.insert(assessment);
        });
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * This queries the database for the entire list of Terms available.
     * @param
     * @return
     */
    public ArrayList<Term> getAllTerms(){
        databaseExecutor.execute(()->{
            allTerms = termDAO.getAllTerms();
        });
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return allTerms;
    }

    /**
     * This queries the database for all the Courses available.
     * @param
     * @return
     */
    public ArrayList<Course> getAllCourse(){
        databaseExecutor.execute(()->{
            allCourse = courseDAO.getAllCourses();
        });
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return allCourse;
    }
    /**
     * This queries the database for all the Assessment available.
     * @return
     */
    public ArrayList<Assessment> getAllAssessments(){
        databaseExecutor.execute(()->{
            allAssessments = assessmentDAO.getAllAssessments();
            });
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return allAssessments;
    }

    /**
     * This function collects all the Assessments associated with a specific course and generates a
     * list of all the assessments pertaining to that course.
     * @param course
     * @return
     */
    public ArrayList<Assessment> getAssocAssessments(Course course){
        databaseExecutor.execute(()->{
            allAssessments = assessmentDAO.getAllAssessments();
            for (Assessment currentAssessment:allAssessments) {
                if(currentAssessment.getAssessmentCourseID() == course.getCourseID()){
                    allAssessments = getAssocAssessments(course);
                }
                else {
                    System.out.println("Associated Courses not loaded or apparent");
                    return;
                }
            }
        });
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return allAssessments;
    }


    /**
     * This function collects all the courses associated with a specific Term and generates a
     * list of all the Courses pertaining to that Term.
     * @param term
     * @return
     */
    public ArrayList<Course> getAssocCourses(Term term) {
        databaseExecutor.execute(() -> {
            allCourse = courseDAO.getAllCourses();
            for (Course currentCourse : allCourse) {
                if (currentCourse.getCourseTermID() == term.getTermID()) {
                    allCourse = getAssocCourses(term);
                } else {
                    System.out.println("Associated Terms not loaded or apparent");
                    return;
                }
            }
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return allCourse;
    }

}
