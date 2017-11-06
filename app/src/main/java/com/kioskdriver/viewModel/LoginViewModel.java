package com.kioskdriver.viewModel;

import android.view.View;
import android.widget.Toast;

import com.kioskdriver.ActionListener.ActionListener;
import com.kioskdriver.ActionListener.Result;
import com.kioskdriver.R;
import com.kioskdriver.databinding.ActivityLoginBinding;
import com.kioskdriver.model.LoginModel;
import com.kioskdriver.view.Activity.LoginActivity;
import com.kioskdriver.view.Activity.RegistrationActivity;


/**
 * Created by AMD21 on 28/9/17.
 */

public class LoginViewModel {

    LoginActivity mContext;
    ActivityLoginBinding mBinding;
    LoginModel model;

    public LoginViewModel(final LoginActivity mContext, ActivityLoginBinding mBinding) {
        this.mContext = mContext;
        this.mBinding = mBinding;

    }

    public void loginClick(View view) {

        switch (view.getId()) {

            case R.id.btn_login:
                model = new LoginModel();
                model.setMobileNo(String.valueOf(mBinding.edtMobileNo.getText()));
                model.setPassword(String.valueOf(mBinding.edtPassword.getText()));

                ActionListener.getInstance(mContext).clickListener(model, new Result() {
                    @Override
                    public void success() {

                        mContext.launchActivity(RegistrationActivity.class);
                    }

                    @Override
                    public void failed(String msg) {
                        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
                    }
                });
                break;


        }

    }


}
