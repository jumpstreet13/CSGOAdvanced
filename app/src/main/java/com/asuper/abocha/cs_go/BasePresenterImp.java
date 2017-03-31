package com.asuper.abocha.cs_go;

import android.support.annotation.NonNull;

/**
 * Created by abakarmagomedov on 31.03.17.
 */

public abstract class BasePresenterImp<V extends BaseView, I extends BaseInteractor> implements BasePresenter<V, I>  {

    private V view;
    private final I interactor;

    public BasePresenterImp(@NonNull I interactor) {
        this.interactor = interactor;
    }

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public V getView() {
        return view;
    }

    @Override
    public I getInteractor() {
        return this.interactor;
    }

}
