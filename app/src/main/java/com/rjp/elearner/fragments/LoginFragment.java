package com.rjp.elearner.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rjp.elearner.R;
import com.rjp.elearner.activities.HomeActivity;
import com.rjp.elearner.base.BaseFragment;

public class LoginFragment extends BaseFragment {

    private Button btLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        btLogin = (Button) view.findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), HomeActivity.class));
            }
        });

        return view;
    }

    public static String getFragmentTag() {
        return LoginFragment.class.getSimpleName();
    }

    public static BaseFragment newInstance() {
        return new LoginFragment();
    }
}
