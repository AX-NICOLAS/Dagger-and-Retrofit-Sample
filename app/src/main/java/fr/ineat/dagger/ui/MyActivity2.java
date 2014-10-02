package fr.ineat.dagger.ui;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import fr.ineat.dagger.R;
import fr.ineat.dagger.contrast.IApiRequest;
import fr.ineat.dagger.model.Contributor;


public class MyActivity2 extends Activity {

    @Inject IApiRequest iApiRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity2);

        BaseApplication.from(this).inject(this);

        /*new AsyncTask<Void,Void, List<Contributor>>(){
            @Override
            protected List<Contributor> doInBackground(Void... voids) {
                return iApiRequest.contributors("square","kochiku");
            }

            @Override
            protected void onPostExecute(List<Contributor> contributors) {
                super.onPostExecute(contributors);
                Toast.makeText(MyActivity2.this, contributors.size() + "< --- size contributor kochiku", Toast.LENGTH_SHORT).show();
            }

        }.execute();*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
