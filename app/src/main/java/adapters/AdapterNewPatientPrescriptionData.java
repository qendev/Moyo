package adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moyoapp.R;

import java.util.ArrayList;

import models.response.Prescription;
import models.response.ResponseNewPatientData;

public class AdapterNewPatientPrescriptionData extends RecyclerView.Adapter<AdapterNewPatientPrescriptionData.ViewHolder> {


    private ArrayList<Prescription> prescriptions;

    public AdapterNewPatientPrescriptionData(ArrayList<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_prescriptions, parent, false);
        return new AdapterNewPatientPrescriptionData.ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.bind(prescriptions.get(position));

    }

    @Override
    public int getItemCount() {
        return ((prescriptions == null) ? 0 : prescriptions.size());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName,textViewDosage,textViewDuration;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewDosage = itemView.findViewById(R.id.textViewDosage);
            textViewDuration = itemView.findViewById(R.id.textViewDuration);

        }

        public void bind(Prescription prescription) {
            textViewName.setText(prescription.getName());
            textViewDosage.setText(prescription.getDosage());
            textViewDuration.setText(prescription.getDuration());
        }



    }
}
