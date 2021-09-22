package com.example.consumoapiproduto;

import android.os.AsyncTask;

import java.util.function.Consumer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Observable<T> extends AsyncTask<Object, Void, Void> {
    private Runnable action;
    private Consumer<T> callback;
    private Consumer<Throwable> errorCallback;

    public static <T> Observable<T>of(Call<T> call){
        return  new Observable<>(call);
    }

    Observable(Call<T> call) {
        this.action = () -> call.enqueue(new Callback<T>() {
           // @Override
            public void onResponse(Call<T> call, Response<T> response) {
                resolve(response.body());
            }

           // @Override
            public void onFailure(Call<T> call, Throwable t) {
                error(t);
            }
        });
    }

    private void resolve(T result) {
        callback.accept(result);
    }

    private void error(Throwable t) {
        if (errorCallback != null) {
            errorCallback.accept(t);
        } else {
            throw new RuntimeException(t);
        }
    }

    public void subscribe(Consumer<T> callback) {
        this.callback = callback;
        execute();
    }

    public void subscribe(Consumer<T> callback, Consumer<Throwable> errorCallback) {
        this.errorCallback = errorCallback;
        subscribe(callback);
    }

    @Override
    protected Void doInBackground(Object... voids) {
        try {
            this.action.run();
        } catch (Exception e) {
            if (errorCallback != null) {
                errorCallback.accept(e);
            } else {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

}
