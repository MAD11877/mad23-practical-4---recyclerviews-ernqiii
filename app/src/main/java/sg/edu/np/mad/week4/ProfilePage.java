package sg.edu.np.mad.week4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfilePage extends AppCompatActivity {
    final String TITLE = "List Activity";
    User user;
    Button followButton;
    Button messageButton;
    TextView name;
    TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        followButton = findViewById(R.id.btn1);
        messageButton = findViewById(R.id.btn2);
        name = findViewById(R.id.textView);
        desc = findViewById(R.id.textView5);

        Intent receiving = getIntent();
        if (receiving.hasExtra("Name") && receiving.hasExtra("Desc")) {
            String n = receiving.getStringExtra("Name");
            String d = receiving.getStringExtra("Desc");
            name.setText(n);
            desc.setText(d);
            user = new User(n,d);
        }

        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setFollowed(!user.isFollowed());

                Log.v(TITLE, String.valueOf(user.isFollowed()));
                if (user.isFollowed()) {
                    followButton.setText("Unfollow");
                } else {
                    followButton.setText("Follow");
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TITLE, "On Start!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Remove the duplicate view assignments from here
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TITLE, "On Stop!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TITLE, "On Pause!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TITLE, "On Destroy");
    }
}
