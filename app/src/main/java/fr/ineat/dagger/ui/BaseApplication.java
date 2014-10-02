package fr.ineat.dagger.ui;

import android.app.Application;
import android.content.Context;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;
import fr.ineat.dagger.module.DbModule;
import fr.ineat.dagger.module.RetrofitModule;

/**
 * Created by nicolasbro on 30/09/2014.
 */
public class BaseApplication extends Application {

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        objectGraph = ObjectGraph.create(getModules().toArray());
    }

    /**
     * A list of modules to use for the application graph. Subclasses can override this method to
     * provide additional modules provided they call {@code super.getModules()}.
     */
    protected List<Object> getModules() {
        return Arrays.asList(new DbModule(this), new RetrofitModule());
    }

    public void inject(Object o) {
        objectGraph.inject(o);
    }

    public static BaseApplication from (Context context){
        return (BaseApplication) context.getApplicationContext();
    }
}
