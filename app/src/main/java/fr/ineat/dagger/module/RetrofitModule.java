package fr.ineat.dagger.module;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import fr.ineat.dagger.MyActivity;
import fr.ineat.dagger.MyActivity2;
import fr.ineat.dagger.contrast.ApiManager;
import fr.ineat.dagger.contrast.IApiRequest;
import fr.ineat.dagger.model.Contributor;
import retrofit.RestAdapter;
import retrofit.http.Path;

/**
 * Created by nicolasbro on 30/09/2014.
 */

@Module(
        injects = {
                MyActivity.class,
                MyActivity2.class
        },
        complete = false,
        library = true
)

public class RetrofitModule {

    @Provides ApiManager provideApiManager() {
        return new ApiManager();
    }

    @Provides IApiRequest provideIApiRequest(){
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(IApiRequest.API_URL_BASE).build();
        return restAdapter.create(IApiRequest.class);
    }

}
