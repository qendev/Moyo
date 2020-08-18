package fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moyoapp.R;
import adapters.Bp_ReadingsAdapter;

import com.google.android.material.tabs.TabLayout;

public class BpReadingsFragments extends Fragment {

    private Bp_ReadingsAdapter bpadapter;
    private TabLayout bptabLayout;
    private ViewPager bpviewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        // Inflate the layout for this fragment
       view= inflater.inflate(R.layout.fragment_bp_readings, container, false);


        bpviewPager = view.findViewById(R.id.viewPager);

        bptabLayout = view.findViewById(R.id.tabLayout);

        bpadapter = new Bp_ReadingsAdapter(getActivity().getSupportFragmentManager());
        bpadapter.addFragment(new EnterBloodPressureReadingsFragment(), "Enter Blood Pressure");
        bpadapter.addFragment(new bpreadindsFragment(), "Blood Pressure Readings");
        bpadapter.addFragment(new StatisticsFragment(), "Statistics");


        bpviewPager.setAdapter(bpadapter);
        bptabLayout.setupWithViewPager(bpviewPager);


        return view;

    }


}