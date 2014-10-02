package fr.ineat.dagger.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import fr.ineat.dagger.R;
import fr.ineat.dagger.data.bal.GithubBal;
import fr.ineat.dagger.model.Contributor;
import fr.ineat.dagger.rxjava.EndObserver;
import rx.Subscription;


public class MyActivity extends Activity {

    @Inject GithubBal mGithubBal;

    private Subscription mContributorsSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        BaseApplication.from(this).inject(this);

        mContributorsSubscription = mGithubBal.getContributor("square", "retrofit", new EndObserver<List<Contributor>>() {
            @Override
            public void onEnd(List<Contributor> result) {
                Toast.makeText(MyActivity.this, result.size() + "< --- size contributor retrofit", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(MyActivity.this, ""+ e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mContributorsSubscription != null){
            mContributorsSubscription.unsubscribe();
        }
    }
}
