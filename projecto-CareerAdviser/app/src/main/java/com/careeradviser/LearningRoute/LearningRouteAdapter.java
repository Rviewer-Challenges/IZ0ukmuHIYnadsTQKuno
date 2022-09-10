package com.careeradviser.LearningRoute;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.careeradviser.Model.LearningRoute;
import com.careeradviser.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class LearningRouteAdapter extends FirebaseRecyclerAdapter<LearningRoute, LearningRouteAdapter.myViewHolder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public LearningRouteAdapter(@NonNull FirebaseRecyclerOptions<LearningRoute> options) {
        super(options);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.learning_route_item, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull LearningRoute model) {
        holder.jobTitle.setText(model.getJob());
        holder.process.setText(model.getTotalYears());
        holder.description.setText(model.getExplanation());
        holder.goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Crear activity de vista de Learning Routes View Activity
                holder.ctx.startActivity(new Intent(holder.ctx, AddCareerActivity.class));
            }
        });
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        Context ctx;
        TextView jobTitle, description, process;
        Button goButton;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            ctx = itemView.getContext();
            jobTitle = itemView.findViewById(R.id.item_view_job_title);
            description = itemView.findViewById(R.id.item_view_description);
            process = itemView.findViewById(R.id.item_view_process_years);
            goButton = itemView.findViewById(R.id.item_view_button);
        }
    }
}
