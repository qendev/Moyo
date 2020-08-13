package adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moyoapp.R;

import java.util.ArrayList;
import java.util.Arrays;

import models.response.PatientData;
import models.response.Prescription;
import models.response.ResponseNewPatientData;

public class AdapterNewPatientData extends RecyclerView.Adapter<AdapterNewPatientData.ViewHolder> {


    private ArrayList<ResponseNewPatientData> responseNewPatientData;

    public AdapterNewPatientData(ArrayList<ResponseNewPatientData> responseNewPatientData) {
        this.responseNewPatientData = responseNewPatientData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_patientdata, parent, false);
        return new AdapterNewPatientData.ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.bind(responseNewPatientData.get(position));

    }

    @Override
    public int getItemCount() {
        return ((responseNewPatientData == null) ? 0 : responseNewPatientData.size());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView_weight, textView_height, textView_bmi;

        RecyclerView recyclerview_prescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_weight = itemView.findViewById(R.id.textView_weight);
            textView_height = itemView.findViewById(R.id.textView_height);
            textView_bmi = itemView.findViewById(R.id.textView_bmi);
            recyclerview_prescription = itemView.findViewById(R.id.recyclerview_prescription);

        }

        public void bind(ResponseNewPatientData responseNewPatientData) {
            textView_weight.setText(responseNewPatientData.getWeight());
            textView_height.setText(responseNewPatientData.getHeight());
            textView_bmi.setText(String.valueOf(calculateBMI(responseNewPatientData.getHeight(),responseNewPatientData.getWeight())));

            ArrayList<Prescription> prescriptions=new ArrayList<Prescription> (Arrays.asList(responseNewPatientData.getPrescription()));
            recyclerview_prescription.setAdapter(new AdapterNewPatientPrescriptionData(prescriptions));
        }

        //create a function that gets the bmi from height and weight
        public float calculateBMI(String heightStr, String weightStr) {

            float bmi = 0;


            if (heightStr != null && !"".equals(heightStr)
                    && weightStr != null && !"".equals(weightStr)) {
                float heightValue = Float.parseFloat(heightStr) / 100;
                float weightValue = Float.parseFloat(weightStr);

                bmi = weightValue / (heightValue * heightValue);

            }
            return bmi;
        }

    }
}
