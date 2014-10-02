package fr.ineat.dagger.data.sal;

import java.util.List;

import fr.ineat.dagger.contrast.IApiRequest;
import fr.ineat.dagger.model.Contributor;
import rx.Observable;

/**
 * Created by nicolasbro on 01/10/2014.
 */
public class GithubSal {

    private IApiRequest mIApiRequest;

    public GithubSal(IApiRequest IApiRequest) {
        mIApiRequest = IApiRequest;
    }

    public Observable<List<Contributor>> getContributor(String owner, String repo){
        return mIApiRequest.contributors(owner, repo);
    }
}
