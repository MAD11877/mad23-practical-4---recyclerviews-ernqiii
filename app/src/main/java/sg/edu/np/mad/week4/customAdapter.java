package sg.edu.np.mad.week4;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class customAdapter extends RecyclerView.Adapter<customViewHolder> {
    private ArrayList<User> list_object;
    //set global variables
    private OnItemClickListener itemClickListener;
    public interface OnItemClickListener {
        void onItemClick (User user);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        itemClickListener = listener;
    }

    public customAdapter(ArrayList<User> input){
        list_object = input;
    }

    @NonNull
    @Override
    public customViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        if (viewType == 0) {
            View view = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.customlayout, parent, false);
            customViewHolder holder = new customViewHolder(view);
            return holder;
        }
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.customlayout, parent, false);
        customViewHolder holder = new customViewHolder(view);
        return holder;

    }

    public void onBindViewHolder(customViewHolder holder, int position) {
        User obj = list_object.get(position);
        holder.txt.setText(obj.getName());
        holder.desc.setText(obj.getDesc());
        holder.image.setImageResource(obj.getMyImageView());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Call the onItemClick method of the listener when the card is clicked
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(obj);
                    Log.v("Hi","Hi");
                }
            }
        });
        if (obj.getName().endsWith("7")) {
            holder.bigProfileImage.setVisibility(View.VISIBLE);
        } else {
            holder.bigProfileImage.setVisibility(View.GONE);
        }
    }
//get item count
    public int getItemCount(){
        return list_object.size();
    }

}
