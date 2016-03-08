package iridiumlabs.org.daggerapp.home;

import android.util.Log;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.util.ArrayList;

import javax.inject.Inject;

import iridiumlabs.org.daggerapp.App;
import iridiumlabs.org.daggerapp.NetApi;
import iridiumlabs.org.daggerapp.POJO.Person;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by John on 3/8/16.
 */
public class MainActivityPresenterImpl extends MvpBasePresenter<MainActivityView> implements MainActivityPresenter {

    private final String TAG = getClass().getSimpleName();

    @Inject
    NetApi netApi;

    public MainActivityPresenterImpl(){
        App.getInjector().inject(this);
    }

    @Override
    public void getPeople() {
        Log.e(TAG, "getPeople called");
        netApi.getPeopleCall().enqueue(new Callback<ArrayList<Person>>() {
            @Override
            public void onResponse(Response<ArrayList<Person>> response, Retrofit retrofit) {
                if (response.isSuccess()){

                    if(isViewAttached() && getView() != null){
                        getView().showPeople(response.body());
                    }

                } else {
                    if(isViewAttached() && getView() != null) {
                        getView().showError();
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e(TAG, t.getMessage(), t);
                if(isViewAttached() && getView() != null){
                    getView().showError();
                }
            }
        });
    }

    @Override
    public void getPeopleRx(){
        Log.d(TAG, "getPeopleRx() called with: " + "");
        netApi.getPeopleRx()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ArrayList<Person>>() {
                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "completed getPeople call");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "error occured", e);
                        if(isViewAttached() && getView() != null){
                            getView().showError();
                        }
                    }

                    @Override
                    public void onNext(ArrayList<Person> persons) {
                        if(isViewAttached() && getView() != null){
                            getView().showPeople(persons);
                        }
                    }
                });
    }
}
