package Domain;


import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.Date;


public class Status {

    private Integer id;
    private String title;
    private String text;
    private File image;
    private Date date;
    private User owner;

    public Status(String statusString, String titreString, User u) {
        this.text = statusString;
        this.title = titreString;
        this.owner = u;
        this.date = new Date();
    }

    public Status() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
