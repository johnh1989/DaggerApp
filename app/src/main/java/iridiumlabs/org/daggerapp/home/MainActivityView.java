package iridiumlabs.org.daggerapp.home;

import com.hannesdorfmann.mosby.mvp.MvpView;

import java.util.ArrayList;

import iridiumlabs.org.daggerapp.POJO.Person;

/**
 * Created by John on 3/8/16.
 */
public interface MainActivityView extends MvpView {

    void showPeople(ArrayList<Person> people);

    void showError();
}
