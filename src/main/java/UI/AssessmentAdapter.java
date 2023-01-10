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

import Entity.Assessment;

public class AssessmentAdapter extends RecyclerView.Adapter<AssessmentAdapter.AssessmentViewHolder> {

    class AssessmentViewHolder extends RecyclerView.ViewHolder{
        private final TextView termView;
        /**
         * Constructor for the ViewHolder.
         * @param view
         */
        private AssessmentViewHolder(View view){
            super(view);
            termView = view.findViewById(R.id.textView2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    final Assessment current = aAssessmentList.get(position);
                    Intent intent = new Intent(context,AssessmentDetail.class);
                    intent.putExtra("Assessment ID",current.getAssessmentID());
                    intent.putExtra("Assessment Title",current.getAssessment_title());
                    intent.putExtra("Assessment Due Date",current.getAssessment_end_date());
                    intent.putExtra("Assessment Course ID",current.getAssessmentCourseID());
                    intent.putExtra("Notes",current.getNotes());
                    intent.putExtra("Assessment Type",current.getType());
                    context.startActivity(intent);
                }
            });
        }
    }
    private ArrayList<Assessment> aAssessmentList ;
    private final Context context;
    private final LayoutInflater inflater;

    /**
     * Constructor for the adapter
     * @param context
     */
    public AssessmentAdapter(Context context){
        inflater=LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public AssessmentAdapter.AssessmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View termItemView = inflater.inflate(R.layout.term_list_item,parent,false);
        return new AssessmentViewHolder(termItemView);
    }

    /**
     * Where data is actually displayed on the textview.
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull AssessmentViewHolder holder, int position) {
        if(aAssessmentList!=null){
            Assessment current = aAssessmentList.get(position);
            String name = current.getAssessment_title();
            holder.termView.setText(name);
        }else{
            holder.termView.setText("No term name");
        }
    }

    /**
     * Tells the system which Assessment items need displayed. This inflates the Items on the GUI
     * @param termItems
     */
    public void setAssessmentItems(ArrayList<Assessment> termItems){
        aAssessmentList = termItems;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if(aAssessmentList!=null){
            return aAssessmentList.size();
        }else{
            return 0;
        }
    }
}
