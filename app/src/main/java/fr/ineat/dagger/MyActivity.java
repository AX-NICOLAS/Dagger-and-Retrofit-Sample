package fr.ineat.dagger;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import fr.ineat.dagger.contrast.ApiManager;
import fr.ineat.dagger.contrast.IApiRequest;
import fr.ineat.dagger.model.Contributor;


public class MyActivity extends Activity {

    @Inject ApiManager apiManager;

    @Inject IApiRequest iApiRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        BaseApplication.from(this).inject(this);

        Toast.makeText(this, apiManager.getTag(), Toast.LENGTH_SHORT).show();

        new AsyncTask<Void,Void, List<Contributor>>(){
            @Override
            protected List<Contributor> doInBackground(Void... voids) {
                return iApiRequest.contributors("square","retrofit");
            }

            @Override
            protected void onPostExecute(List<Contributor> contributors) {
                super.onPostExecute(contributors);
                Toast.makeText(MyActivity.this,contributors.size() + "< --- size contributor retrofit", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MyActivity.this,MyActivity2.class));
            }

        }.execute();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
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
