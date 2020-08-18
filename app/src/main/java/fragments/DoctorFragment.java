//package fragments;
//
//import android.os.Bundle;
//
//import androidx.fragment.app.Fragment;
//import androidx.viewpager.widget.ViewPager;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import fragments.MyDoctorFragment;
//import fragments.PatientDataFragment;
//import com.example.moyoapp.R;
////import com.example.moyoapp.SendRequestFragment;
//import com.google.android.material.tabs.TabLayout;
//
////import adapters.DataAdapter;
////import adapters.DoctorAdapter;
//
//
//public class DoctorFragment extends Fragment {
//    private DoctorAdapter doctorAdapter;
//    private TabLayout doctortabLayout;
//    private ViewPager doctorviewPager;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view;
//        // Inflate the layout for this fragment
//        view = inflater.inflate(R.layout.fragment_doctor, container, false);
//
//
////        doctortabLayout = view.findViewById(R.id.tabLayout_doctor);
////        doctorviewPager = view.findViewById(R.id.viewPager_doctor);
//
//        doctorAdapter = new DoctorAdapter(getActivity().getSupportFragmentManager());
//        doctorAdapter.addFragment(new MyDoctorFragment(), "My Doctor");
////        doctorAdapter.addFragment(new SendRequestFragment(), "Send Request");
//
//
//       doctorviewPager.setAdapter(doctorAdapter);
//       doctortabLayout.setupWithViewPager(doctorviewPager);
//
//
//        return view;
//
//
//    }
//}