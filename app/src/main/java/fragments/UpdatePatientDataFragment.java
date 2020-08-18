package fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moyoapp.R;

import models.Post.PostPatientData;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import services.MoyoService;
import services.MyConfig;
import services.RetrofitRequest;


public class UpdatePatientDataFragment extends Fragment {

    Button button_updatepaientdata,button_calculate_bmi;
    EditText editText_weight,editText_height;
    TextView  textView_BMI;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_update_patient_data, container, false);

        setView(view);
        return  view;
    }

    private void setView(View view) {
        button_updatepaientdata=view.findViewById(R.id.button_updatepaientdata);
        button_calculate_bmi=view.findViewById(R.id.button_calculate_bmi);
        editText_weight =view.findViewById(R.id.editText_weight);
        editText_height =view.findViewById(R.id.editText_height);
        textView_BMI =view.findViewById(R.id.textView_BMI);

        button_updatepaientdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPref = getContext().getSharedPreferences(MyConfig.SHARED_PREF_USER, Context.MODE_PRIVATE);
                String token = sharedPref.getString("token", "");

                String patient_id= sharedPref.getString("id", "");
                //send patient data
                String weight=editText_weight.getText().toString();
                String height=editText_height.getText().toString();
                PostPatientData postPatientData=new PostPatientData(patient_id,weight,height);

                postPAtientData(token,postPatientData);
            }
        });

        button_calculate_bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });


    }

    private void postPAtientData(String token, PostPatientData postPatientData) {
       MoyoService moyoService = RetrofitRequest.getRetrofitInstance().create(MoyoService.class);
       Call<ResponseBody> responseBodyCall=moyoService.postPatientData("Baerer "+token,postPatientData);
       responseBodyCall.enqueue(new Callback<ResponseBody>() {
           @Override
           public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
               Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onFailure(Call<ResponseBody> call, Throwable t) {

               Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

           }
       });
    }

    public void calculateBMI() {
        String heightStr = editText_height.getText().toString();
        String weightStr = editText_weight.getText().toString();

        if (heightStr != null && !"".equals(heightStr)
                && weightStr != null  &&  !"".equals(weightStr)) {
            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * heightValue);

            displayBMI(bmi);
        }
    }
    private void displayBMI(float bmi) {
        String bmiLabel = "";

        if (Float.compare(bmi, 15f) <= 0) {
            bmiLabel = getString(R.string.very_severely_underweight);
        } else if (Float.compare(bmi, 15f) > 0  &&  Float.compare(bmi, 16f) <= 0) {
            bmiLabel = getString(R.string.severely_underweight);
        } else if (Float.compare(bmi, 16f) > 0  &&  Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = getString(R.string.underweight);
        } else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 25f) <= 0) {
            bmiLabel = getString(R.string.normal);
        } else if (Float.compare(bmi, 25f) > 0  &&  Float.compare(bmi, 30f) <= 0) {
            bmiLabel = getString(R.string.overweight);
        } else if (Float.compare(bmi, 30f) > 0  &&  Float.compare(bmi, 35f) <= 0) {
            bmiLabel = getString(R.string.obese_class_i);
        } else if (Float.compare(bmi, 35f) > 0  &&  Float.compare(bmi, 40f) <= 0) {
            bmiLabel = getString(R.string.obese_class_ii);
        } else {
            bmiLabel = getString(R.string.obese_class_iii);
        }

        bmiLabel = bmi + "\n\n" + bmiLabel;
        textView_BMI.setText(bmiLabel);
    }
}
