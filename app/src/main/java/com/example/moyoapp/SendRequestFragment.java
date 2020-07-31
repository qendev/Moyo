package com.example.moyoapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import models.Post.PostRequestDoctor;
import models.response.ResponseRequestDoctor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.MoyoService;
import services.MyConfig;
import services.RetrofitRequest;


public class SendRequestFragment extends Fragment {

    Button button_request_doctor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_send_request, container, false);

        button_request_doctor=view.findViewById(R.id.button_request_doctor);
        button_request_doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getContext().getSharedPreferences(MyConfig.SHARED_PREF_USER, Context.MODE_PRIVATE);
                String token = sharedPref.getString("token", "");
                String patient_id = sharedPref.getString("id", "");
                String name = sharedPref.getString("name", "");
                String email = sharedPref.getString("email", "");

                //create Object
                PostRequestDoctor postRequestDoctor=new PostRequestDoctor(patient_id,name,email,false);

                postRequestDoctor(token,postRequestDoctor);
            }
        });
        return view;
    }


    private void postRequestDoctor(String token, PostRequestDoctor postRequestDoctor) {
        MoyoService moyoService = RetrofitRequest.getRetrofitInstance().create(MoyoService.class);
        Call<ResponseRequestDoctor>  responseRequestDoctorCall = moyoService.postRequestDoctor("Baerer " + token, postRequestDoctor);
        responseRequestDoctorCall.enqueue(new Callback<ResponseRequestDoctor>() {
            @Override
            public void onResponse(Call<ResponseRequestDoctor> call, Response<ResponseRequestDoctor> response) {
                Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseRequestDoctor> call, Throwable t) {
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}