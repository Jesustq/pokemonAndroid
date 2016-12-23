package com.soin.pokemon.presenters;

/**
 * Created by Jesus Torres on 21/12/2016.
 */

public interface Presenter <V> {

    void setView(V view);

    void detachView();
}
