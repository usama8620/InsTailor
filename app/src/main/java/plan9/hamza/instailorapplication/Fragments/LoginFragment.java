package plan9.hamza.instailorapplication.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import plan9.hamza.instailorapplication.Activities.MainActivity;
import plan9.hamza.instailorapplication.R;

import static plan9.hamza.instailorapplication.Activities.LoginRegistrationActivity.GLOBAL;

public class LoginFragment extends Fragment implements View.OnClickListener {
    public static final String PREFERENCE = "preference";
    public static final String PREF_USERNAME = "username";
    public static final String PREF_PASSWORD = "username";
    public static final String PREF_TOKEN = "token";
    public static final String PREF_SKIP_LOGIN = "skip_login";

    public SharedPreferences mSharedPreferences;
    android.widget.Button loginButton, RegistrationButton;
    EditText useremailLogin, passwordLogin;
    TextView forgetPassword;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        //edittext declaration
        useremailLogin = (EditText) view.findViewById(R.id.login_fragment_email);
        passwordLogin = (EditText) view.findViewById(R.id.login_fragment_password);
        //viewpager declaration
        viewPager = (ViewPager) getActivity().findViewById(R.id.login_registration_view_pager);
        forgetPassword = (TextView) view.findViewById(R.id.login_fragment_forget_password);
        //button declaration
        loginButton = (Button) view.findViewById(R.id.login_fragment_login_button);
        RegistrationButton = (Button) view.findViewById(R.id.login_fragment_registraton_button);

        mSharedPreferences = getActivity().getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);

        if (mSharedPreferences.contains(PREF_SKIP_LOGIN)) {
            startActivity(new Intent(getContext(), MainActivity.class));
            GLOBAL.finish();
        } else {
            loginButton.setOnClickListener(this);
            RegistrationButton.setOnClickListener(this);

        }
        return view;
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_fragment_login_button:
                Intent i = new Intent(getActivity(), MainActivity.class);
                SharedPreferences.Editor mEditor = mSharedPreferences.edit();
                mEditor.putString(PREF_SKIP_LOGIN, "skip");
                mEditor.apply();
                startActivity(i);
                GLOBAL.finish();
                break;
            case R.id.login_fragment_registraton_button:
                viewPager.setCurrentItem(1);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            getActivity().finish();
        }
        return super.onOptionsItemSelected(item);
    }


}
