package fr.niji.tben_guiza.intproject;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import fr.niji.tben_guiza.intproject.model.User;
import fr.niji.tben_guiza.intproject.network.response.Repo;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolder> {

    private List<User> users;
    private Context context;
    private Picasso picasso;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView mTextView;

        ViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.textView);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterList(Context context, Picasso picasso) {
        this.context = context;
        this.picasso = picasso;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AdapterList.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new ViewHolder(v);
    }
    public void swapData(List<User> body) {
        users=body;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        User user = users.get(position);
        holder.mTextView.setText(user.getPrenom());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        if (users != null)
            return users.size();
        else return 0;
    }
}
