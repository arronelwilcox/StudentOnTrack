//package DAO;
//
//import androidx.room.Dao;
//import androidx.room.Delete;
//import androidx.room.Insert;
//import androidx.room.OnConflictStrategy;
//import androidx.room.Query;
//import androidx.room.Update;
//
//import java.util.ArrayList;
//
//import Entity.Term;
//
//@Dao
//public interface TermDAO {
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    void insert(Term term);
//
//    @Update
//    void update(Term term);
//
//    @Delete
//    void delete(Term term);
//
//    @Query(value = "SELECT * FROM termTable ORDER BY termID ASC")
//    ArrayList<Term>getAllTerms();// ORDER BY termID ASC
//}
