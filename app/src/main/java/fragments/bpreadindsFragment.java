package fragments;

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

import com.example.moyoapp.R;

import java.util.ArrayList;

import adapters.Adapter_Bp_Readings;
import models.response.BpReadings;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.MoyoService;
import services.MyConfig;
import services.RetrofitRequest;


public class bpreadindsFragment extends Fragment {

    RecyclerView recyclerView_bpreadings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_bpreadinds, container, false);

        recyclerView_bpreadings=view.findViewById(R.id.recyclerView_bpreadings);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView_bpreadings.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView_bpreadings.setLayoutManager(layoutManager);



        SharedPreferences sharedPref = getContext().getSharedPreferences(MyConfig.SHARED_PREF_USER, Context.MODE_PRIVATE);
        String token = sharedPref.getString("token", "");

        String patient_id= sharedPref.getString("id", "");

        // specify an adapter (see also next example)


        getBpReadings(token, patient_id);
        return view;

    }

    private void getBpReadings(String token,String id) {
        MoyoService moyoService = RetrofitRequest.getRetrofitInstance().create(MoyoService.class);
        Call<ArrayList<BpReadings> > arrayListCall=moyoService.getReadings("Baerer "+token,id);
        arrayListCall.enqueue(new Callback<ArrayList<BpReadings>>() {
            @Override
            public void onResponse(Call<ArrayList<BpReadings>> call, Response<ArrayList<BpReadings>> response) {

                Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                        ArrayList<BpReadings> bpReadingsArrayList=response.body();
        Adapter_Bp_Readings adapter_bp_readings = new Adapter_Bp_Readings(bpReadingsArrayList);
        recyclerView_bpreadings.setAdapter(adapter_bp_readings);
//                recyclerview

            }

            @Override
            public void onFailure(Call<ArrayList<BpReadings>> call, Throwable t) {
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}