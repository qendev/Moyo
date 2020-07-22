package fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moyoapp.EnterBloodPressureReadingsFragment;
import com.example.moyoapp.R;
import com.example.moyoapp.TabAdapter;
import com.example.moyoapp.bpreadindsFragment;
import com.google.android.material.tabs.TabLayout;

public class BpReadingsFragments extends Fragment {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        // Inflate the layout for this fragment
       view= inflater.inflate(R.layout.fragment_bp_readings, container, false);


        viewPager = view.findViewById(R.id.viewPager);

        tabLayout = view.findViewById(R.id.tabLayout);

        adapter = new TabAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new EnterBloodPressureReadingsFragment(), "Bp Readings");
        adapter.addFragment(new bpreadindsFragment(), "Bp Readings");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


        return view;

    }


}