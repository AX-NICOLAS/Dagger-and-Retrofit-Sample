package fr.ineat.dagger.rxjava;

import java.util.concurrent.Callable;

import fr.ineat.dagger.AndroidSchedulers;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;

/**
 * Created by nicolasbro on 02/10/2014.
 */
public class RxAsyncFunc {

    public static <T> Observable<T> funcAsync(final Callable<T> callable){
        return funcAsync(callable, AndroidSchedulers.mainThread());
    }

    public static <T> Observable<T> funcAsync(final Callable<T> callable, Scheduler scheduler){
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                try {
                    subscriber.onNext(callable.call());
                } catch (Exception e) {
                    subscriber.onError(e);
                }

                subscriber.onCompleted();
            }
        }).observeOn(scheduler);
    }

}
