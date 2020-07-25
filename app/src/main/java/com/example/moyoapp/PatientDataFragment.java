package com.example.moyoapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import adapters.Adapter_Bp_Readings;
import adapters.Adapter_Patient_Data;
import models.response.BpReadings;
import models.response.PatientData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.MoyoService;
import services.MyConfig;
import services.RetrofitRequest;


public class PatientDataFragment extends Fragment {
    RecyclerView recyclerview_patientdata;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        // Inflate the layout for this fragment
      view= inflater.inflate(R.layout.fragment_patient_data, container, false);
      
      recyclerview_patientdata = view.findViewById(R.id.recyclerview_patientdata);

        recyclerview_patientdata.setHasFixedSize(true);


        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerview_patientdata.setLayoutManager(layoutManager);

        SharedPreferences sharedPref = getContext().getSharedPreferences(MyConfig.SHARED_PREF_USER, Context.MODE_PRIVATE);
        String token = sharedPref.getString("token", "");

        String patient_id= sharedPref.getString("id", "");

        getPatientData(token,patient_id);
        return view;




    }

    private void getPatientData(String token, String patient_id) {
        MoyoService moyoService = RetrofitRequest.getRetrofitInstance().create(MoyoService.class);
        Call<ArrayList<PatientData>> arrayListCall=moyoService.getPatientData("Baerer "+token,patient_id);
        arrayListCall.enqueue(new Callback<ArrayList<PatientData>>() {
            @Override
            public void onResponse(Call<ArrayList<PatientData>> call, Response<ArrayList<PatientData>> response) {
                Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                ArrayList<PatientData>patientDataArrayList=response.body();
                Adapter_Patient_Data adapter_patient_data  = new Adapter_Patient_Data(patientDataArrayList);
                recyclerview_patientdata.setAdapter(adapter_patient_data);

            }

            @Override
            public void onFailure(Call<ArrayList<PatientData>> call, Throwable t) {
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });



    }
}