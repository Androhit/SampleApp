package com.rjp.elearner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.rjp.elearner.fragments.LoginFragment;

public class LoginActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment loginFragment = fragmentManager.findFragmentById(R.id.login_container);

        if(loginFragment == null) {
            loginFragment = new LoginFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.login_container, loginFragment)
                    .commit();
        }
    }
}
