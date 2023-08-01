package sg.edu.np.mad.week4;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class customViewHolder extends RecyclerView.ViewHolder {
    TextView txt;
    TextView desc;
    ImageView image;
    ImageView bigProfileImage;
    public customViewHolder(View itemView) {
        super(itemView);
        txt = itemView.findViewById(R.id.textView2);
        desc = itemView.findViewById(R.id.textView3);
        image = itemView.findViewById(R.id.imageView2);
        bigProfileImage = itemView.findViewById(R.id.imageView5);
    }
}
