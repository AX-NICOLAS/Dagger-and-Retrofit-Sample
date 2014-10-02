package fr.ineat.dagger.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import fr.ineat.dagger.contrast.Constant;
import fr.ineat.dagger.data.SqliteHelper;
import fr.ineat.dagger.data.bal.GithubBal;
import fr.ineat.dagger.data.dal.GithubDal;
import fr.ineat.dagger.data.sal.GithubSal;
import fr.ineat.dagger.ui.MyActivity;
import fr.ineat.dagger.ui.MyActivity2;
import fr.ineat.dagger.contrast.IApiRequest;
import retrofit.RestAdapter;
import static fr.ineat.dagger.contrast.Constant.API_URL_BASE;

/**
 * Created by nicolasbro on 30/09/2014.
 */

@Module(
        injects = {
                MyActivity.class,
                MyActivity2.class
        },
        includes = {
                DbModule.class
        }
)

public class RetrofitModule {


    @Provides IApiRequest provideIApiRequest(){
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL_BASE)
                .build();
        IApiRequest iApiRequest = restAdapter.create(IApiRequest.class);
        return iApiRequest;
    }

    @Provides GithubDal provideGithubDal(SqliteHelper helper){
        return new GithubDal(helper);
    }

    @Provides GithubSal provideGithubSal(IApiRequest request){
        return new GithubSal(request);
    }

    @Provides @Singleton
    GithubBal provideGithubBal(GithubSal githubSal, GithubDal githubDal){
        return new GithubBal(githubSal, githubDal);
    }

}
