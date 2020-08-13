package fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moyoapp.EnterBloodPressureReadingsFragment;
import com.example.moyoapp.PatientDataFragment;
import com.example.moyoapp.PatientMedicationFragment;
import com.example.moyoapp.R;
import com.example.moyoapp.SummaryFragment;
import com.example.moyoapp.UpdatePatientDataFragment;
import com.example.moyoapp.bpreadindsFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import adapters.AdapterNewPatientData;
import adapters.Bp_ReadingsAdapter;
import adapters.DataAdapter;
import models.response.PatientData;
import models.response.ResponseNewPatientData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.MoyoService;
import services.MyConfig;
import services.RetrofitRequest;


public class DataFragment extends Fragment {

//    private DataAdapter dataAdapter;
//    private TabLayout datatabLayout;
//    private ViewPager dataviewPager;

    RecyclerView recyclerview_patientdata;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_data, container, false);

        initializeView(view);


        SharedPreferences sharedPref = getContext().getSharedPreferences(MyConfig.SHARED_PREF_USER, Context.MODE_PRIVATE);
        String token = sharedPref.getString("token", "");

        String patient_id= sharedPref.getString("id", "");
        getNewPatientData(token,patient_id);

//        datatabLayout = view.findViewById(R.id.tabLayout_data);

//        dataviewPager = view.findViewById(R.id.viewPager_data);

//        dataAdapter = new DataAdapter(getActivity().getSupportFragmentManager());
//        dataAdapter.addFragment(new PatientDataFragment(), "Patient Data");
//        dataAdapter.addFragment(new UpdatePatientDataFragment(), "Update Data");
//        dataAdapter.addFragment(new PatientMedicationFragment(), "Patient Medication");
//        dataAdapter.addFragment(new SummaryFragment(), "Summary");



//        dataviewPager.setAdapter(dataAdapter);
//        datatabLayout.setupWithViewPager(dataviewPager);

        String testid="132456789090";
        getNewPatientData(token,testid);


        return view;

    }

    private void initializeView(View view) {
        recyclerview_patientdata=view.findViewById(R.id.recyclerview_patientdata);
        recyclerview_patientdata.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerview_patientdata.setLayoutManager(layoutManager);
    }

    private void getNewPatientData(String token, String patient_id){
        MoyoService moyoService = RetrofitRequest.getRetrofitInstance().create(MoyoService.class);
        Call<ArrayList<ResponseNewPatientData>> arrayListCall=moyoService.getNewPatientData("Baerer "+token,patient_id);
        arrayListCall.enqueue(new Callback<ArrayList<ResponseNewPatientData>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseNewPatientData>> call, Response<ArrayList<ResponseNewPatientData>> response) {
                Log.e("ken",response.body().toString());
                recyclerview_patientdata.setAdapter(new AdapterNewPatientData(response.body()));

            }

            @Override
            public void onFailure(Call<ArrayList<ResponseNewPatientData>> call, Throwable t) {

                Log.e("ken",t.toString());

            }
        });

    }


}