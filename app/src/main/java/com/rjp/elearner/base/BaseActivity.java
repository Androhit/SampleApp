package com.rjp.elearner.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.rjp.elearner.R;

/**
 * Created by SAT on 8/19/2017.
 */

public class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
    }

    protected int getLayout() {
        return R.layout.activity_base_layout;
    }

    protected void addFragment() {
        BaseFragment fragment = getFragment();
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }

    protected BaseFragment getFragment() {
        return null;
    }
}
