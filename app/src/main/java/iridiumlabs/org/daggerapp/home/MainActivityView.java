package iridiumlabs.org.daggerapp.home;

import com.hannesdorfmann.mosby.mvp.MvpView;

import java.util.ArrayList;

import iridiumlabs.org.daggerapp.POJO.Person;

/**
 * Created by John on 3/8/16.
 */
public interface MainActivityView extends MvpView {

    /**
     * Display list of people to the user
     * @param people
     */
    void showPeople(ArrayList<Person> people);

    /**
     * Display an error message
     */
    void showError();
}
