package com.kioskdriver.viewModel;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.gson.Gson;
import com.kioskdriver.ActionListener.ActionListener;
import com.kioskdriver.ActionListener.Result;
import com.kioskdriver.MainActivity;
import com.kioskdriver.R;
import com.kioskdriver.data.APIResponse;
import com.kioskdriver.data.ServiceRepository;
import com.kioskdriver.databinding.ActivityRegistrationBinding;
import com.kioskdriver.model.CarType.CarTypeModel;
import com.kioskdriver.model.RegisterModel;
import com.kioskdriver.model.StateList.StateModel;
import com.kioskdriver.view.Activity.RegistrationActivity;

import java.util.ArrayList;

import Utils.WebServiceString;
import data.Injection;
import retrofit2.Call;
import retrofit2.Response;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by AMD21 on 3/10/17.
 */

public class RegistrationViewModel implements APIResponse<String> {


    ActivityRegistrationBinding mBinding;
    private RegistrationViewModel registrationViewModel;
    static RegistrationActivity mContext;
    ArrayList<String> stateList = new ArrayList<>();
    ArrayList<String> cityList = new ArrayList<>();
    ArrayList<String> carType = new ArrayList<>();
    ArrayList<String> carModel = new ArrayList<>();
    public ArrayAdapter adapter;

    public RegistrationViewModel(final RegistrationActivity mContext, ActivityRegistrationBinding mBinding) {
        this.mContext = mContext;
        this.mBinding = mBinding;


        ServiceRepository mServiceRepository = checkNotNull(Injection.Repository(mContext));

        mServiceRepository.commanService(WebServiceString.carTypeListService,this, 1, mContext,"get");
        mServiceRepository.commanService(WebServiceString.stateListService,this, 2, mContext,"get");


    }


    public void RegistrationClick(View view) {

        if (view.getId() == R.id.btn_submit) {

            RegisterModel model = new RegisterModel();
            model.setFullName(String.valueOf(mBinding.edtFullName.getText()));
            model.setEmail(String.valueOf(mBinding.edtEmail.getText()));
            model.setContactNo(String.valueOf(mBinding.edtContactNo.getText()));
            model.setCarModel(String.valueOf(mBinding.spinnerCarModel.getSelectedItem()));
            model.setCarType(String.valueOf(mBinding.spinnerCarType.getSelectedItem()));
            model.setState(String.valueOf(mBinding.spinnerState.getSelectedItem()));
            model.setCity(String.valueOf(mBinding.spinnerCity.getSelectedItem()));
            model.setCarNumber(String.valueOf(mBinding.edtCarNo.getText()));
            model.setSeatingCapacity(String.valueOf(mBinding.edtSeatingCapacity.getText()));
            model.setCarPurchaseYear(String.valueOf(mBinding.edtCarPurchaseYear.getText()));
            model.setLicenseNo(String.valueOf(mBinding.edtLicenceNo.getText()));
            model.setAadharNo(String.valueOf(mBinding.edtAadharNo.getText()));
            model.setDriverAddress(String.valueOf(mBinding.edtDriverAddress.getText()));
            model.setImeiNo(String.valueOf(mBinding.edtImeiNo.getText()));
            model.setPassword(String.valueOf(mBinding.edtPassword.getText()));
            model.setConfirmPassword(String.valueOf(mBinding.edtConfirmPassword.getText()));


            ActionListener.getInstance(mContext).clickListener(model, new Result() {
                @Override
                public void success() {

                    mContext.launchActivity(MainActivity.class);
                }

                @Override
                public void failed(String msg) {
                    Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
                }
            });




        } else if (view.getId() == R.id.btn_select_photo) {
            new RegistrationActivity().CheckSelfPermission(mContext);
        }
    }


    public static void getImageData(Intent data) {

//        mBinding.imageView2.setImageBitmap((Bitmap) data.getExtras().get("data"));
    }


    @Override
    public void onSuccess(Call<String> call, Response<String> response, int responseCode, Result result) {


    }

    @Override
    public void onSuccess(Call<String> call, Response<String> response, int responseCode) {

        switch (responseCode) {
            case 1:

                String responseStr = response.body();

                final CarTypeModel datum;
                datum = new Gson().fromJson(responseStr, CarTypeModel.class);
                for (int i = 0; i < datum.getData().size(); i++) {
                    carType.add(datum.getData().get(i).getCarType());
                }


                adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, carType);
                mBinding.spinnerCarType.setAdapter(adapter);
                mBinding.spinnerCarType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                        carModel.clear();
                        for (int j = 0; j < datum.getData().get(i).getCarModel().size(); j++) {
                            carModel.add(datum.getData().get(i).getCarModel().get(j).getCarModelName());
                        }
                        adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, carModel);
                        mBinding.spinnerCarModel.setAdapter(adapter);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });


                break;

            case 2:

                final StateModel stateModel = new Gson().fromJson(response.body(), StateModel.class);

                Log.d("StateResponse",stateModel.getMessage());

                for (int i = 0; i < stateModel.getData().get(0).getState().size(); i++) {
                    stateList.add(stateModel.getData().get(0).getState().get(i).getStateName());
                }
                adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, stateList);
                mBinding.spinnerState.setAdapter(adapter);

                mBinding.spinnerState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                        cityList.clear();
                        for (int j = 0; j < stateModel.getData().get(0).getState().get(i).getCity().size(); j++) {
                            cityList.add(stateModel.getData().get(0).getState().get(i).getCity().get(j).getCityName());
                        }
                        adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, cityList);
                        mBinding.spinnerCity.setAdapter(adapter);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });


                break;
        }
    }

    @Override
    public void onFailure(Call<String> call, Throwable t, int responseCode, Result result) {

    }

    @Override
    public void onFailure(Call<String> call, Throwable t, int responseCode) {

    }
}
