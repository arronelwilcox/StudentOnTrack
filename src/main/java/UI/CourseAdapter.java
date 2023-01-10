package UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentontrack.R;

import java.util.ArrayList;

import Entity.Course;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
    
    class CourseViewHolder extends RecyclerView.ViewHolder{
        private final TextView courseView;
        /**
         * Constructor for the ViewHolder.
         * @param view
         */
        private CourseViewHolder(View view){
            super(view);
            courseView = view.findViewById(R.id.textView2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /**
                     * needs lloked at
                     */
                    int position = getAdapterPosition();
                    final Course current = aCourseList.get(position);
                    Intent intent = new Intent(context,CourseDetail.class);
                    intent.putExtra("Course ID",current.getCourseID());
                    intent.putExtra("Course Title",current.getCourse_title());
                    intent.putExtra("Course Status",current.getStatus());
                    intent.putExtra("Course Instructor Name",current.getInstructorName());
                    intent.putExtra("Course Instructor email",current.getEmail());
                    intent.putExtra("Associated Term ID",current.getCourseTermID());
                    context.startActivity(intent);
                    /**
                     * needs lloked at
                     */
                }
            });
        }
    }
    private ArrayList<Course> aCourseList ;
    private final Context context;
    private final LayoutInflater inflater;

    /**
     * Constructor for the adapter
     * @param context
     */
    public CourseAdapter(Context context){
        inflater=LayoutInflater.from(context);
        this.context = context;
    }

    /**
     * needs lloked at
     */
    @NonNull
    @Override
    public CourseAdapter.CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View courseItemView = inflater.inflate(R.layout.course_list_item,parent,false);
        return new CourseViewHolder(courseItemView);
        /**
         * needs lloked at
         */
    }


    /**
     * Where data is actually displayed on the textview.
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        if(aCourseList!=null){
            Course current = aCourseList.get(position);
            String name = current.getCourse_title();
            holder.courseView.setText(name);
        }else{
            holder.courseView.setText("No course name");
        }
    }

    /**
     * Tells the system which Course items need displayed. This inflates the Items on the GUI
     * @param courseItems
     */
    public void setCourseItems(ArrayList<Course> courseItems){
        aCourseList = courseItems;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if(aCourseList!=null){
            return aCourseList.size();
        }else{
            return 0;
        }
    }
}
