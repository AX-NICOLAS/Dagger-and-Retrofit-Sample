package fr.ineat.dagger.data.bal;

import java.util.List;
import java.util.concurrent.Callable;
import fr.ineat.dagger.data.dal.GithubDal;
import fr.ineat.dagger.data.sal.GithubSal;
import fr.ineat.dagger.model.Contributor;
import fr.ineat.dagger.rxjava.EndObserver;
import rx.Observer;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

import static fr.ineat.dagger.rxjava.RxAsyncFunc.funcAsync;

/**
 * Created by nicolasbro on 01/10/2014.
 */
public class GithubBal {

    private GithubSal mGithubSal;
    private GithubDal mGithubDal;

    public GithubBal(GithubSal githubSal, GithubDal githubDal) {
        mGithubSal = githubSal;
        mGithubDal = githubDal;
    }

    public Subscription getContributor(String owner, String repo, Observer<List<Contributor>> observer){
        final PublishSubject publishSubject = PublishSubject.create();
        Subscription subscription = publishSubject.subscribe(observer);

        EndObserver<List<Contributor>> saveObserver = new EndObserver<List<Contributor>>() {
            @Override
            public void onEnd(final List<Contributor> result) {

                funcAsync(new Callable<List<Contributor>>() {
                    @Override
                    public List<Contributor> call() throws Exception {
                        mGithubDal.insertContributor();
                        return result;
                    }
                }).subscribe(publishSubject);

                // sinon voir exemple en bas
            }
        };

        mGithubSal.getContributor(owner, repo)
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe(saveObserver);

        return subscription;
    }

    /*Observable.create(new Observable.OnSubscribe<List<Contributor>>() {
                            @Override
                            public void call(Subscriber<? super List<Contributor>> subscriber) {
                                try {
                                    mGithubDal.insertContributor();
                                    subscriber.onNext(result);
                                } catch (Exception e) {
                                    subscriber.onError(e);
                                }

                                subscriber.onCompleted();
                            }
    }).observeOn(AndroidSchedulers.mainThread()).subscribe(publishSubject);*/


}
