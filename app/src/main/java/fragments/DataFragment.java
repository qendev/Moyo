package fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

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

import adapters.Bp_ReadingsAdapter;
import adapters.DataAdapter;


public class DataFragment extends Fragment {

    private DataAdapter dataAdapter;
    private TabLayout datatabLayout;
    private ViewPager dataviewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_data, container, false);

        datatabLayout = view.findViewById(R.id.tabLayout_data);

        dataviewPager = view.findViewById(R.id.viewPager_data);

        dataAdapter = new DataAdapter(getActivity().getSupportFragmentManager());
        dataAdapter.addFragment(new PatientDataFragment(), "Patient Data");
        dataAdapter.addFragment(new UpdatePatientDataFragment(), "Update Data");
        dataAdapter.addFragment(new PatientMedicationFragment(), "Patient Medication");
        dataAdapter.addFragment(new SummaryFragment(), "Summary");



        dataviewPager.setAdapter(dataAdapter);
        datatabLayout.setupWithViewPager(dataviewPager);


        return view;

    }


}