package com.careeradviser.LearningRoute;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.careeradviser.Auxiliar.Generics;
import com.careeradviser.Model.LearningRoute;
import com.careeradviser.R;

import java.util.ArrayList;

public class LearningRouteAdapter extends RecyclerView.Adapter<LearningRouteAdapter.myViewHolder> {

    private ArrayList<LearningRoute> array;

    public LearningRouteAdapter(ArrayList<LearningRoute> learningRoutes){
        this.array = learningRoutes;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.learning_route_item, null, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, final int position) {
        holder.tvJob.setText("Cargo: " + array.get(position).getJob());
        holder.tvTotalYears.setText("Duración del proceso: " + String.valueOf( array.get(position).getStudyingYears() + array.get(position).getWorkingYears() ) );
        holder.goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewActivity = new Intent(holder.goButton.getContext(), ViewActivity.class);
                viewActivity.putExtra(Generics.ID_LEARNING_ROUTE, array.get(position));
                holder.goButton.getContext().startActivity(viewActivity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        private TextView tvJob, tvTotalYears;
        private Button goButton;

        public myViewHolder(@NonNull View view){
            super(view);

            tvJob = view.findViewById(R.id.item_view_job_title);
            tvTotalYears = view.findViewById(R.id.item_view_process_years);
            goButton = view.findViewById(R.id.item_view_button);
        }
    }
}
