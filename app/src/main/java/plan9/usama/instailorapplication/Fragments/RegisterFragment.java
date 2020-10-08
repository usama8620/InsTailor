package plan9.usama.instailorapplication.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import plan9.usama.instailorapplication.Activities.MainActivity;
import plan9.usama.instailorapplication.R;

import static plan9.usama.instailorapplication.Activities.LoginRegistrationActivity.GLOBAL;

public class RegisterFragment extends Fragment implements View.OnClickListener {
    Button RegistrationButton,LoginButton;
    EditText passwordRegistration, emailRegistration, mobileNumberRegistration, confirmPasswordRegistration;
    TextView termsConditions;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, container, false);
        viewPager = (ViewPager) getActivity().findViewById(R.id.login_registration_view_pager);
        passwordRegistration = (EditText) view.findViewById(R.id.register_fragment_password);
        emailRegistration = (EditText) view.findViewById(R.id.register_fragment_email);
        mobileNumberRegistration = (EditText) view.findViewById(R.id.register_fragment_number);
        confirmPasswordRegistration = (EditText) view.findViewById(R.id.register_fragment_confirm_password);
        termsConditions = (TextView) view.findViewById(R.id.register_fragment_termsandcondition);
        RegistrationButton = (Button) view.findViewById(R.id.register_fragment_registeration_button);
        LoginButton = (Button) view.findViewById(R.id.register_fragment_login_button);
        RegistrationButton.setOnClickListener( this);
        LoginButton.setOnClickListener(this);
        termsConditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowPopup(view);
            }
        });

        return view;
    }

    public void ShowPopup(View v) {
//        TextView txtclose;
//        myDialog.setContentView(R.layout.terms_conditions_popup);
//        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
//        txtclose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myDialog.dismiss();
//            }
//        });
//        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        myDialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_fragment_registeration_button:
                Intent intent = new Intent(getActivity(), MainActivity.class);
                GLOBAL.finish();
                startActivity(intent);
                break;
            case R.id.register_fragment_login_button:
                
           break;

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            getActivity().finish();
        return super.onOptionsItemSelected(item);
    }

}



