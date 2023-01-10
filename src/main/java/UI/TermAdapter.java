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
import Entity.Term;

public class TermAdapter extends RecyclerView.Adapter<TermAdapter.TermViewHolder> {

    class TermViewHolder extends RecyclerView.ViewHolder{
        private final TextView termView;
        /**
         * Constructor for the ViewHolder.
         * @param view
         */
        private TermViewHolder(View view){
            super(view);
            termView = view.findViewById(R.id.textView2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    final Term current = aTermList.get(position);
                    Intent intent = new Intent(context,TermDetail.class);
                    intent.putExtra("Term ID",current.getTermID());
                    intent.putExtra("Term Title",current.getTerm_title());
                    intent.putExtra("Term Start",current.getTerm_start_date());
                    intent.putExtra("Term End",current.getTerm_end_date());
                    context.startActivity(intent);
                }
            });
        }
    }
    private ArrayList<Term> aTermList ;
    private final Context context;
    private final LayoutInflater inflater;

    /**
     * Constructor for the adapter
     * @param context
     */
    public TermAdapter(Context context){
        inflater=LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public TermAdapter.TermViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View termItemView = inflater.inflate(R.layout.term_list_item,parent,false);
        return new TermViewHolder(termItemView);
    }

    /**
     * Where data is actually displayed on the textview.
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull TermViewHolder holder, int position) {
        if(aTermList!=null){
            Term current = aTermList.get(position);
            String name = current.getTerm_title();
            holder.termView.setText(name);
        }else{
            holder.termView.setText("No term name");
        }
    }

    /**
     * Tells the system which Term items need displayed. This inflates the Items on the GUI
     * @param termItems
     */
    public void setTermItems(ArrayList<Term> termItems){
        aTermList = termItems;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if(aTermList!=null){
            return aTermList.size();
        }else{
            return 0;
        }
    }
}
