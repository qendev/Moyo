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
import models.response.ResponseBloodPressure;

public class Adapter_Bp_Readings extends RecyclerView.Adapter<Adapter_Bp_Readings.ViewHolder> {

    private ArrayList<ResponseBloodPressure> bpReadingsArrayList;


    public Adapter_Bp_Readings(ArrayList<ResponseBloodPressure> bpReadingsArrayList) {
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

        TextView textViewSystolic,textViewDiastolic,textViewHeartRate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewSystolic=itemView.findViewById(R.id.textViewSystolic);
            textViewDiastolic =itemView.findViewById(R.id.textViewDiastolic);
            textViewHeartRate=itemView.findViewById(R.id.textViewHeartRate);
        }

        public void bind(ResponseBloodPressure bpReadings){
            textViewSystolic.setText(bpReadings.getSys());
            textViewDiastolic.setText(bpReadings.getDia());
            textViewHeartRate.setText(bpReadings.getHeart_rate());
        }
    }

}
