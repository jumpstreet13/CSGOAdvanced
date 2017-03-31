package com.asuper.abocha.cs_go;

/**
 * Created by abakarmagomedov on 31.03.17.
 */

public interface BasePresenter<V extends BaseView, I extends BaseInteractor> {
    void attachView(V v);
    void detachView();
    V getView();
    I getInteractor();
}
