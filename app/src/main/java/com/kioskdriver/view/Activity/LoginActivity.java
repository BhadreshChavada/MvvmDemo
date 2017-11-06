package com.kioskdriver.view.Activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.kioskdriver.BaseClass.BaseActivity;
import com.kioskdriver.R;
import com.kioskdriver.databinding.ActivityLoginBinding;
import com.kioskdriver.viewModel.LoginViewModel;

/**
 * Created by AMD21 on 28/9/17.
 */

public class LoginActivity extends BaseActivity {

    private ActivityLoginBinding mBinding;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDataBinding();
    }

    private void initDataBinding() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginViewModel = new LoginViewModel(this,mBinding);
        mBinding.setMainViewModel(loginViewModel);


    }

    public void launchActivity(Class mClass) {
        callIntent(mClass);
    }
}
