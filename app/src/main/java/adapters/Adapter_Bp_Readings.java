package adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moyoapp.R;

import java.util.ArrayList;

import models.response.BpReadings;

public class Adapter_Bp_Readings extends RecyclerView.Adapter<Adapter_Bp_Readings.ViewHolder> {

    private ArrayList<BpReadings> bpReadingsArrayList;

    public Adapter_Bp_Readings(ArrayList<BpReadings> bpReadingsArrayList) {
        this.bpReadingsArrayList = bpReadingsArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_bpreadings, parent, false);
        return new Adapter_Bp_Readings.ViewHolder(itemView);

    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.bind(bpReadingsArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return  ((bpReadingsArrayList == null) ? 0 : bpReadingsArrayList.size());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewSystolicDiastolic,textViewHeartRate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewSystolicDiastolic=itemView.findViewById(R.id.textViewSystolic);
            textViewHeartRate=itemView.findViewById(R.id.textViewHeartRate);
        }

        public void bind(BpReadings bpReadings){
            textViewSystolicDiastolic.setText(bpReadings.getSystolic_diastolic());
            textViewHeartRate.setText(bpReadings.getHeart_rate());
        }
    }

}
