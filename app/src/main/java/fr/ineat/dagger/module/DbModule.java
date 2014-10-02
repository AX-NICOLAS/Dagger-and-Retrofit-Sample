package fr.ineat.dagger.module;

import android.app.Application;

import dagger.Module;
import dagger.Provides;
import fr.ineat.dagger.data.SqliteHelper;

/**
 * Created by nicolasbro on 02/10/2014.
 */
@Module(library = true)
public class DbModule {

    private Application mApplication;

    public DbModule(Application application){
        mApplication = application;
    }

    @Provides
    SqliteHelper provideDatabase(){
        // créer ta propre classe
        return new SqliteHelper(mApplication);
    }

}
