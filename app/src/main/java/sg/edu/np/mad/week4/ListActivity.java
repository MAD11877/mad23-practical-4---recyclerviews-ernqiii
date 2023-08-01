package sg.edu.np.mad.week4;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    ArrayList<User> myListObj = new ArrayList<>();
    public String name;
    public String desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 20; i++) {
            User user = new User();
            name = "Name" + String.valueOf(generateName());
            desc = "Description" + String.valueOf(generateName());

            user.setName(name);
            user.setDesc(desc);
            user.setMyImageView(R.drawable.rabbid);
            myListObj.add(user);
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        customAdapter cuAdapter = new customAdapter(myListObj);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(cuAdapter);

        cuAdapter.setOnItemClickListener(new customAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(User user){
                Log.v("hi", user.getName());
                //User user = myListObj.get(i);
                showAlert("Profile", user);
            }
        });
    }

    private int generateName(){
        Random rand = new Random();
        int myNumber = rand.nextInt(2147483647);
        return myNumber;
    }

    public void showAlert(String title, User user) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(user.getName())
                .setPositiveButton("View", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Do something when the "OK" button is clicked
                        Intent intent = new Intent(ListActivity.this, ProfilePage.class);
                        intent.putExtra("Name", user.getName());
                        intent.putExtra("Desc", user.getDesc());
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Do something when the "Cancel" button is clicked
                    }
                })
                .show();
    }

}