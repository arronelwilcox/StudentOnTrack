package Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "courseTable")
public class Course{
    /**
     * The course title
     *
     * •  The start date
     *
     * •  The end date
     *
     * •  The status (in progress, completed, dropped, plan to take)
     *
     * •  The course instructors’ names, phone numbers, and e-mail addresses
     */

    @PrimaryKey(autoGenerate = false)
    private int courseID ;

    private String course_title,status, instructorName, email;
    private long phone;
    private int courseTermID;

   // private ArrayList<Course> courseList ;

    public Course(int courseID,String course_title, String status, String name, String email, long phone,int courseTermID) {
        this.courseID = courseID;
        this.course_title = course_title;
        this.status = status;
        this.instructorName = name;
        this.email = email;
        this.phone = phone;
        this.courseTermID = courseTermID;
    }

    public Course() {

    }


    public String getCourse_title() {
        return course_title;
    }

    public void setCourse_title(String term_title) {
        this.course_title = term_title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public int getCourseTermID() {
        return courseTermID;
    }

    public void setCourseTermID(int courseTermID) {
        this.courseTermID = courseTermID;
    }
//
//    public ArrayList<Course> getCourseList() {
//        return courseList;
//    }
//
//    public void setCourseList(ArrayList<Course> courseList) {
//        this.courseList = courseList;
//    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + courseID +
                ", course_title='" + course_title + '\'' +
                ", status='" + status + '\'' +
                ", name='" + instructorName + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                //    ", courseList=" + courseList +
                ", termID=" + courseTermID +
                '}';
    }
}
