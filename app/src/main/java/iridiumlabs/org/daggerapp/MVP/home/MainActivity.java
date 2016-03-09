package iridiumlabs.org.daggerapp.MVP.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;
import iridiumlabs.org.daggerapp.BaseMvpActivity;
import iridiumlabs.org.daggerapp.POJO.Person;
import iridiumlabs.org.daggerapp.R;

public class MainActivity extends BaseMvpActivity<MainActivityView, MainActivityPresenter> implements MainActivityView {

    private final String TAG = getClass().getSimpleName();

    @Bind(R.id.fab)
    FloatingActionButton fab;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.rv_mainRecyclerView)
    RecyclerView recyclerViewPersons;

    MainRecyclerAdapter adapter;

    @NonNull
    @Override
    public MainActivityPresenter createPresenter() {
        return new MainActivityPresenterImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);
        adapter = new MainRecyclerAdapter();
        recyclerViewPersons.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewPersons.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getPeople();
    }

    @Override
    public void showError() {
        Toast.makeText(MainActivity.this, "An Error occurred :(", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPeople(ArrayList<Person> people) {
        Log.i(TAG, "showPeople called");
        for (Person p : people){
            Log.i(TAG, p.toString());
        }
        adapter.setPersonList(people);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab)
    void onFabClick(){
        presenter.getPeopleRx();
    }
}
