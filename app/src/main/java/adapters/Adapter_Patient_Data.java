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
import models.response.PatientData;

public class Adapter_Patient_Data extends RecyclerView.Adapter<Adapter_Patient_Data.ViewHolder> {


    private ArrayList<PatientData> patientDataArrayList;

    public Adapter_Patient_Data(ArrayList<PatientData> patientDataArrayList) {
        this.patientDataArrayList = patientDataArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_patientdata, parent, false);
        return new Adapter_Patient_Data.ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.bind(patientDataArrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return  ((patientDataArrayList == null) ? 0 : patientDataArrayList.size());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView_weight,textView_height,textView_bmi;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_weight=itemView.findViewById(R.id.textView_weight);
            textView_height = itemView.findViewById(R.id.textView_height);
            textView_bmi =itemView.findViewById(R.id.textView_bmi);
        }

        public void bind(PatientData patientData){
            textView_weight.setText(patientData.getWeight());
            textView_height.setText(patientData.getHeight());
        }
    }
}
