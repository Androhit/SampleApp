package com.rjp.elearner.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.rjp.elearner.base.BaseActivity;
import com.rjp.elearner.base.BaseFragment;
import com.rjp.elearner.fragments.LoginFragment;

public class LoginActivity extends BaseActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportFragmentManager().findFragmentByTag(LoginFragment.getFragmentTag()) == null) {
            addFragment();
        }
    }

    @Override
    protected BaseFragment getFragment() {
        return LoginFragment.newInstance();
    }
}
