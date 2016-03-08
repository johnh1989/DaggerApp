package iridiumlabs.org.daggerapp.home;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;

/**
 * Created by John on 3/8/16.
 */
public interface MainActivityPresenter extends MvpPresenter<MainActivityView> {

    void getPeople();
}
