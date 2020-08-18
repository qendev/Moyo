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
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.moyoapp.R;

import models.Post.PostBpReading;
import models.response.ResponseLogin;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.MoyoService;
import services.MyConfig;
import services.RetrofitRequest;

public class EnterBloodPressureReadingsFragment extends Fragment {


    MoyoService moyoService;
    EditText editText_heartrate,editText_systolic_diastolic;
    Button button_updaterecords;
    SharedPreferences sharedPref;
    ProgressBar progressBar_enterbloodpressurereadings;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view =inflater.inflate(R.layout.fragment_enter_blood_pressure_readings, container, false);
        setViews(view);
        return view;
    }

    private void setViews(View view) {

        editText_heartrate=view.findViewById(R.id.editText_heartrate);
        editText_systolic_diastolic=view.findViewById(R.id.editText_systolic_diastolic);
        button_updaterecords=view.findViewById(R.id.button_updaterecords);
        progressBar_enterbloodpressurereadings =view.findViewById(R.id.progressBar_enterbloodpressurereadings);

        button_updaterecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar_enterbloodpressurereadings.setVisibility(View.VISIBLE);
                sharedPref = getContext().getSharedPreferences(MyConfig.SHARED_PREF_USER, Context.MODE_PRIVATE);
                String token = sharedPref.getString("token", "");

                String patient_id= sharedPref.getString("id", "");

                String sytolic_diastolic=editText_systolic_diastolic.getText().toString();
                String heart_rate=editText_heartrate.getText().toString();


                PostBpReading postBpReading=new PostBpReading(patient_id,sytolic_diastolic,heart_rate);
                //post bp readings
                postBpReadingToServer(token,postBpReading);
            }
        });

    }

    private void postBpReadingToServer(String token, PostBpReading postBpReading) {
        moyoService = RetrofitRequest.getRetrofitInstance().create(MoyoService.class);
        Call<ResponseBody> responseSubmitBpReadings=moyoService.postBpReading("Baerer "+token,postBpReading);
        responseSubmitBpReadings.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                progressBar_enterbloodpressurereadings.setVisibility(View.GONE);
                Toast.makeText(getActivity(),"Records Updated Succesfully!",Toast.LENGTH_LONG).show();



//                Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}