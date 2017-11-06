package data;


import android.content.Context;
import android.support.annotation.NonNull;

import com.kioskdriver.data.ServiceRepository;
import com.kioskdriver.data.local.LocalDataSource;
import com.kioskdriver.data.remote.RemoteDataSource;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

public class Injection {

    public static ServiceRepository Repository(@NonNull Context context) {
        checkNotNull(context);
        return ServiceRepository.getInstance(RemoteDataSource.getInstance(context),
                LocalDataSource.getInstance(context));
    }


}