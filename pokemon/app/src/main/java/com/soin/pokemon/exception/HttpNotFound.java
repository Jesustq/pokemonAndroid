package com.soin.pokemon.exception;

import retrofit2.adapter.rxjava.HttpException;

/**
 * Created by Chus on 19/12/2016.
 */

public class HttpNotFound {

    public final static String SERVER_INTERNET_ERROR =
            "Unable to resolve host: No address associated with hostname";

    private HttpNotFound() {}

    public static boolean isHttp404(Throwable error) {
        return error instanceof HttpException && ((HttpException) error).code() == 404;
    }
}
