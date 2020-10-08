package plan9.hamza.instailorapplication.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import plan9.hamza.instailorapplication.Activities.ContactUsActivity;
import plan9.hamza.instailorapplication.R;

public class PrivacyPolicyFragment extends Fragment {
TextView Contact;
    public PrivacyPolicyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_privacy_policy, container, false);
        Contact = view.findViewById(R.id.contact);
        Contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ContactUsActivity.class);
                startActivity(i);
            }
        });



    return  view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
     }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
