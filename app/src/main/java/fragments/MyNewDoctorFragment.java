package fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.moyoapp.R;


public class MyNewDoctorFragment extends Fragment {

    private ImageView img_call_mydoctor,img_message_mydoctor;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        // Inflate the layout for this fragment
      view= inflater.inflate(R.layout.fragment_my_new_doctor, container, false);

        img_call_mydoctor =view.findViewById(R.id.img_call_mydoctor);
        img_message_mydoctor = view.findViewById(R.id.img_message_mydoctor);


        //launch sms application with an intent
        img_message_mydoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("sms:"));
                startActivity(sendIntent);
            }
        });

        //launch dialer with an intent
        img_call_mydoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.DIAL");
                startActivity(intent);
            }
        });
        return view;
    }
}