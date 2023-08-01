package sg.edu.np.mad.week4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class demoAdapter extends RecyclerView.Adapter<demoViewHolder> {
    ArrayList<String> data;

    public demoAdapter(ArrayList<String> input){
        data = input;
    }

    public demoViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customlayout, parent, false);
        //inflating the data, just like inflating a balloon
        return new demoViewHolder(view);
    }

    public void onBindViewHolder(demoViewHolder holder, int position){
        String s = data.get(position);
        holder.txt.setText(s);
        holder.desc.setText(s);
    }

    public int getItemCount(){
        return data.size();
    }
}
