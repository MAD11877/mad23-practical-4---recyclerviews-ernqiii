package sg.edu.np.mad.week4;

import java.io.Serializable;

public class User implements Serializable {
    private int myImageView;
    private String name;
    private String desc;
    private int id;
    private boolean followed;
    public User(){}

    public User(String name, String desc) {
        this.myImageView = myImageView;
        this.name = name;
        this.desc = desc;
    }

    public int getMyImageView() {
        return myImageView;
    }

    public void setMyImageView(int myImageView) {
        this.myImageView = myImageView;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }
}

