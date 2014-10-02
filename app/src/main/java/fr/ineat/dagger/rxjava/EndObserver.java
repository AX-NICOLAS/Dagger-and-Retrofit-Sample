package fr.ineat.dagger.rxjava;

import rx.Observer;

public  abstract class EndObserver<T> implements Observer<T> {

        public abstract void onEnd(T result);

        @Override
        public void onCompleted() {
            // nothing
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(T t) {
            onEnd(t);
        }
}