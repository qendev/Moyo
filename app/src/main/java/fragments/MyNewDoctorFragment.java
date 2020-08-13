package fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moyoapp.R;

import models.response.ResponseMyDoctor;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.MoyoService;
import services.MyConfig;
import services.RetrofitRequest;


public class MyNewDoctorFragment extends Fragment {

    private ImageView img_call_mydoctor, img_message_mydoctor;
    private TextView textViewname, textViewlocation, textViewphone, textViewemail, textViewhospital;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_my_new_doctor, container, false);

        initializeView(view);


        SharedPreferences sharedPref = getContext().getSharedPreferences(MyConfig.SHARED_PREF_USER, Context.MODE_PRIVATE);
        String token = sharedPref.getString("token", "");
        String id = sharedPref.getString("id", "");
        String doctor_id=sharedPref.getString("doctor_id","");

        getMyDoctor(token, doctor_id);





        String testid = "5f0af6ad3b700e08d8fc91d3";
        getMyDoctor(token, testid);

        return view;


    }

    private void initializeView(View view) {
        img_call_mydoctor = view.findViewById(R.id.img_call_mydoctor);
        img_message_mydoctor = view.findViewById(R.id.img_message_mydoctor);
        textViewname = view.findViewById(R.id.textViewname);
        textViewlocation = view.findViewById(R.id.textViewlocation);
        textViewphone = view.findViewById(R.id.textViewphone);
        textViewemail = view.findViewById(R.id.textViewemail);
        textViewhospital = view.findViewById(R.id.textViewhospital);


    }

    private void getMyDoctor(String token, String doctor_id) {
        MoyoService moyoService = RetrofitRequest.getRetrofitInstance().create(MoyoService.class);
        Call<ResponseMyDoctor> responseMyDoctorCall = moyoService.getMyDoctor("Baerer " + token, doctor_id);
        responseMyDoctorCall.enqueue(new Callback<ResponseMyDoctor>() {
            @Override
            public void onResponse(Call<ResponseMyDoctor> call, Response<ResponseMyDoctor> response) {
                Log.e("daktari", String.valueOf(response.body()));
                if (response.isSuccessful()) {

                    if (response.body()==null) Toast.makeText(getContext(), "Details not availbale", Toast.LENGTH_SHORT).show();
                    else {
                        textViewname.setText(response.body().getName());
                        //launch dialer with an intent
                        img_call_mydoctor.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent makeCallintent = new Intent("android.intent.action.DIAL");
                                makeCallintent.setData(Uri.parse("tel:" + response.body().getPhone()));
                                startActivity(makeCallintent);
                            }
                        });
                        //launch sms application with an intent
                        img_message_mydoctor.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent sendSmsIntent = new Intent(Intent.ACTION_VIEW);
                                sendSmsIntent.setData(Uri.parse("sms:" + response.body().getPhone()));
                                startActivity(sendSmsIntent);
                            }
                        });
                        textViewlocation.setText(response.body().getLocation());
                        textViewphone.setText(response.body().getPhone());
                        textViewemail.setText(response.body().getEmail());
                        textViewhospital.setText(response.body().getHospital());
                    }


                }



            }

            @Override
            public void onFailure(Call<ResponseMyDoctor> call, Throwable t) {
                Log.e("daktarifailed", t.toString());
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();



            }
        });


    }
}