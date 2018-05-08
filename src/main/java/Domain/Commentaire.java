package Domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


public class Commentaire {

    private Integer id;
    private Integer idStatus;
    private Date date;
    private User owner;
    private String text;

    public Commentaire(String co, User u, Integer idst) {
        this.idStatus = idst;
        this.text = co;
        this.owner = u;
        this.date = new Date();
    }

    public Commentaire() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
