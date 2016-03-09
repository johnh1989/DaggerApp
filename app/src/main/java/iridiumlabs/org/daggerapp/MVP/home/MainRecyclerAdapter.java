package iridiumlabs.org.daggerapp.MVP.home;

import android.app.Application;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import iridiumlabs.org.daggerapp.App;
import iridiumlabs.org.daggerapp.POJO.Person;
import iridiumlabs.org.daggerapp.R;

/**
 * Created by John on 3/8/16.
 */
public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.PersonViewHolder> {

    @Inject
    Picasso picasso;

    @Inject
    Application application;

    private ArrayList<Person> personsList = new ArrayList<>();

    public MainRecyclerAdapter(ArrayList<Person> personsList){
        this.personsList.clear();
        this.personsList.addAll(personsList);
        App.getInjector().inject(this);
    }

    public MainRecyclerAdapter(){
        this.personsList.clear();
        this.personsList.addAll(personsList);
        App.getInjector().inject(this);
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.tv_firstName)
        TextView firtName;

        @Bind(R.id.tv_lastName)
        TextView lastName;

        @Bind(R.id.iv_personPhoto)
        ImageView photo;

        @Bind(R.id.tvQuote)
        TextView quote;

        @Bind(R.id.tv_occupation)
        TextView occupation;

        public PersonViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setClickable(true);
        }
    }

    public void setPersonList(ArrayList<Person> personList){
        this.personsList.clear();
        this.personsList.addAll(personList);
        this.notifyDataSetChanged();
    }

    public void add(Person person){
        this.personsList.add(person);
        this.notifyItemInserted(personsList.size() + 1);
    }

    @Override
    public int getItemCount() {
        return personsList.size();
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PersonViewHolder(LayoutInflater.from(application).inflate(R.layout.row_person, parent, false));
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        Person person = personsList.get(0);
        holder.firtName.setText(person.getFirstName());
        holder.lastName.setText(person.getLastName());
        holder.occupation.setText(person.getOccupation());
        holder.quote.setText(person.getQuote());
        picasso.load(person.getPhoto()).into(holder.photo);
    }


}
