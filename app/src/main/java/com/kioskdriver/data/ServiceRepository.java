package com.kioskdriver.data;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.kioskdriver.ActionListener.Result;
import com.kioskdriver.BuildConfig;
import com.kioskdriver.data.local.LocalDataSource;

import java.util.HashMap;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;


/**
 * Created by AMD21 on 27/9/17.
 */

public class ServiceRepository implements DataSource {

    private static ServiceRepository INSTANCE = null;

    private final DataSource mRemoteDataSource;

    private final LocalDataSource mLocalDataSource;

    /**
     * Marks the cache as invalid, to force an update the next time data is requested. This variable
     * has package local visibility so it can be accessed from tests.
     */
    boolean mCacheIsDirty = false;

    // Prevent direct instantiation.
    private ServiceRepository(@NonNull DataSource deRemoteDataSource,
                              @NonNull LocalDataSource deLocalDataSource) {
        mRemoteDataSource = checkNotNull(deRemoteDataSource);
        mLocalDataSource = checkNotNull(deLocalDataSource);
    }

    /**
     * Returns the single instance of this class, creating it if necessary.
     *
     * @param deRemoteDataSource the backend data source
     * @param deLocalDataSource  the device storage data source
     * @return the {@link ServiceRepository} instance
     */
    public static ServiceRepository getInstance(DataSource deRemoteDataSource,
                                                LocalDataSource deLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new ServiceRepository(deRemoteDataSource, deLocalDataSource);
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }




    @Override
    public void commanService(HashMap<String, String> map, String subURL, APIResponse apiResponse, int requestCode, Activity context,Result mResult,String method) {
        if (BuildConfig.IS_PROD)
            mRemoteDataSource.commanService(map, subURL, apiResponse, requestCode, context,mResult,method);
        else
            mLocalDataSource.commanService(map, subURL, apiResponse, requestCode, context,mResult,method);
    }

    @Override
    public void commanService(HashMap<String, String> map, String subURL, APIResponse apiResponse, int requestCode, Activity context,String method) {
        if (BuildConfig.IS_PROD)
            mRemoteDataSource.commanService(map, subURL, apiResponse, requestCode, context,method);
        else
            mLocalDataSource.commanService(map, subURL, apiResponse, requestCode, context,method);
    }

    @Override
    public void commanService(String subURL, APIResponse apiResponse, int requestCode, Activity context, Result mResult,String method) {
        if (BuildConfig.IS_PROD)
            mRemoteDataSource.commanService( subURL, apiResponse, requestCode, context,mResult,method);
        else
            mLocalDataSource.commanService( subURL, apiResponse, requestCode, context,mResult,method);
    }

    @Override
    public void commanService(String subURL, APIResponse apiResponse, int requestCode, Activity context,String method) {
        if (BuildConfig.IS_PROD)
            mRemoteDataSource.commanService( subURL, apiResponse, requestCode, context,method);
        else
            mLocalDataSource.commanService( subURL, apiResponse, requestCode, context,method);
    }
}
