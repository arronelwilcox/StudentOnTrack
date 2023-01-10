package Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "termTable")
public class Term {
    /**
    titles (e.g., Term 1, Term 2, Spring Term),
    start dates, and end dates for each term.
     */
    @PrimaryKey(autoGenerate = true)
    private int termID ;

    private String term_title;
    private String term_start_date, term_end_date;
   // private ArrayList<Term> termList ;

    public Term(int termID,String term_title, String term_start_date, String term_end_date) {
        this.termID = termID;
        this.term_title = term_title;
        this.term_start_date = term_start_date;
        this.term_end_date = term_end_date;
    }




    public int getTermID() {
        return termID;
    }

    public void setTermID(int termID) {
        this.termID = termID;
    }

    public String getTerm_title() {
        return term_title;
    }

    public void setTerm_title(String term_title) {
        this.term_title = term_title;
    }

    public String getTerm_start_date() {
        return term_start_date;
    }

    public void setTerm_start_date(String term_start_date) {
        this.term_start_date = term_start_date;
    }

    public String getTerm_end_date() {
        return term_end_date;
    }

    public void setTerm_end_date(String end) {
        this.term_end_date = end;
    }
//
//    public ArrayList<Term> getTermList() {
//        return termList;
//    }
//
//    public void setTermList(ArrayList<Term> termList) {
//        this.termList = termList;
//    }
}
