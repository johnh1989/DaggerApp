package iridiumlabs.org.daggerapp.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.ButterKnife;
import iridiumlabs.org.daggerapp.POJO.Person;
import iridiumlabs.org.daggerapp.R;

/**
 * Created by John on 3/8/16.
 */
public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.PersonViewHolder> {

    private ArrayList<Person> personsList = new ArrayList<>();
    Context context;

    public MainRecyclerAdapter(Context context, ArrayList<Person> personsList){
        this.personsList.clear();
        this.personsList.addAll(personsList);
        this.context = context;
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder{
        public PersonViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public int getItemCount() {
        return personsList.size();
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PersonViewHolder(LayoutInflater.from(context).inflate(R.layout.row_person, parent, false));
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {

    }


}
