package com.java.flow.api;


import java.util.concurrent.Flow;

public class MySubscriber<T> implements Flow.Subscriber<T> {

    private Flow.Subscription subscription;
    private int count = 1;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        System.out.println(item);
        subscription.request(count++);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("DONE");
    }
}
