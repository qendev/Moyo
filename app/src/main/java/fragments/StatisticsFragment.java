package fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.moyoapp.R;

import java.util.ArrayList;

import models.response.PatientData;
import models.response.ResponseBpReadings;
import models.response.ResponsePatientDataNew;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.MoyoService;
import services.MyConfig;
import services.RetrofitRequest;


public class StatisticsFragment extends Fragment {

    private Button buttonPatientData;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view;
        view = inflater.inflate(R.layout.fragment_statistics, container, false);

        buttonPatientData=view.findViewById(R.id.buttonPatientData);







        buttonPatientData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPref = getContext().getSharedPreferences(MyConfig.SHARED_PREF_USER, Context.MODE_PRIVATE);
                String token = sharedPref.getString("token", "");
                String patient_id= sharedPref.getString("id", "");



                MoyoService moyoService = RetrofitRequest.getRetrofitInstance().create(MoyoService.class);
                Call<ArrayList<ResponseBpReadings>> arrayListCall=moyoService.getBpReadings("Baerer "+token,patient_id);
                arrayListCall.enqueue(new Callback<ArrayList<ResponseBpReadings>>() {
                    @Override
                    public void onResponse(Call<ArrayList<ResponseBpReadings>> call, Response<ArrayList<ResponseBpReadings>> response) {
                        Log.e("GraphTest!",String.valueOf(response.body()));

                    }

                    @Override
                    public void onFailure(Call<ArrayList<ResponseBpReadings>> call, Throwable t) {

                    }
                });










            }
        });



        return view;


    }
}