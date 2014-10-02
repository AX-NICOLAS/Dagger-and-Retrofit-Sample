package fr.ineat.dagger.data.dal;

import android.util.Log;

import fr.ineat.dagger.data.SqliteHelper;

/**
 * Created by nicolasbro on 01/10/2014.
 */
public class GithubDal {

    private SqliteHelper mSqliteHelper;

    public GithubDal(SqliteHelper sqliteHelper){
        mSqliteHelper = sqliteHelper;
    }


    public void insertContributor() throws Exception{

        Log.d(GithubDal.class.getSimpleName(), "start process insertContributor");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int i = 1 / 0;

        Log.d(GithubDal.class.getSimpleName(), "end process insertContributor");
    }
}
