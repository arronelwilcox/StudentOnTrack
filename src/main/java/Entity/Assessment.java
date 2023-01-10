package Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "assessmentTable")
public class Assessment {
    //private ArrayList <Assessment> assessmentList;

    @PrimaryKey(autoGenerate = true)
    private int assessmentID;

    private String assessment_title, type, notes;
    private String assessment_end_date;
    private int assessmentCourseID;

//    private ArrayList<Assessment> assessmentList=null;

    public Assessment(int assessmentID,String assessment_title, String type, String notes, String assessment_end_date,int assessmentCourseID) {
        this.assessmentID = assessmentID;
        this.assessment_title = assessment_title;
        this.type = type;
        this.notes = notes;
        this.assessment_end_date = assessment_end_date;
        this.assessmentCourseID = assessmentCourseID;
    }

    public String getAssessment_title() {
        return assessment_title;
    }

    public void setAssessment_title(String assessment_title) {
        this.assessment_title = assessment_title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAssessment_end_date() {
        return assessment_end_date;
    }

    public void setAssessment_end_date(String assessment_end_date) {
        this.assessment_end_date = assessment_end_date;
    }

//    public ArrayList<Assessment> getAssessmentList() {
//        return assessmentList;
//    }

    public void setAssessmentList(ArrayList<Assessment> assessmentList) {
        assessmentList = assessmentList;
    }

    public int getAssessmentCourseID() {
        return assessmentCourseID;
    }

    public void setAssessmentCourseID(int assessmentCourseID) {
        this.assessmentCourseID = assessmentCourseID;
    }

    public int getAssessmentID() {
        return assessmentID;
    }

    public void setAssessmentID(int assessmentID) {
        this.assessmentID = assessmentID;
    }

    @Override
    public String toString() {
        return "Assessment{" +
             //   "assessmentList=" + assessmentList +
                ", assessmentID=" + assessmentID +
                ", assessment_title='" + assessment_title + '\'' +
                ", type='" + type + '\'' +
                ", notes='" + notes + '\'' +
                ", assessment_end_date=" + assessment_end_date +
                ", courseID=" + assessmentCourseID +
                '}';
    }
}
