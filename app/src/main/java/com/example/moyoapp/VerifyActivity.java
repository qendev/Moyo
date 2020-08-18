package com.example.moyoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.chaos.view.PinView;

import models.Post.PostOtp;
import models.Post.PostRequestOtp;
import models.response.ResponseLogin;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.MoyoService;
import services.MyConfig;
import services.RetrofitRequest;

public class VerifyActivity extends AppCompatActivity {
    private Button buttonLogin;
    private PinView pinViewProfileChange;
    private ProgressBar progressBarlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        initializeViews();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBarlogin.setVisibility(View.VISIBLE);



                SharedPreferences sharedPref = getSharedPreferences(MyConfig.SHARED_PREF_USER, Context.MODE_PRIVATE);
                String phone = sharedPref.getString("phone", "");
                String pin=pinViewProfileChange.getText().toString();

                MoyoService moyoService = RetrofitRequest.getRetrofitInstance().create(MoyoService.class);
                Call<ResponseLogin> responseLoginCall = moyoService.postOtp(new PostOtp(phone,pin));
                responseLoginCall.enqueue(new Callback<ResponseLogin>() {
                    @Override
                    public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                        Log.e("phoneNambaTest",String.valueOf(response.body()));

                        if (response.isSuccessful()){


//                            get token and id from reponse
                    String token = response.body().getToken();
                    String userId = response.body().getUser().getId();

                    //save to shareprefference
                    saveToSharedprefference(token, userId);
                            progressBarlogin.setVisibility(View.GONE);
                            Intent intent = new Intent(VerifyActivity.this,MainActivity.class);
                            startActivity(intent);
                            Toast.makeText(VerifyActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseLogin> call, Throwable t) {
                        Toast.makeText(VerifyActivity.this, "Login Failed!Check your Internet Connection!", Toast.LENGTH_SHORT).show();

                    }
                });



            }
        });
    }

    private void initializeViews()
    {
        buttonLogin = findViewById(R.id.buttonLogin);
        pinViewProfileChange = findViewById(R.id.pinViewProfileChange);
        progressBarlogin = findViewById(R.id.progressBarlogin);
    }

    public void saveToSharedprefference(String token, String id) {
        SharedPreferences sharedPref = getSharedPreferences(MyConfig.SHARED_PREF_USER, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("token", token);
        editor.putString("id", id);
        editor.apply();
    }
}