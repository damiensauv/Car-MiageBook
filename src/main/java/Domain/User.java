package Domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


public class User {

    private Integer id;
    private String pseudo;
    private String mail;
    private String nom;
    private String prenom;
    private String password;
    private List<Integer> friends;

    public User(String email, String pseudo, String password, String name, String surname) {
        this.mail = email;
        this.pseudo = pseudo;
        this.password = password;
        this.prenom = name;
        this.nom = surname;
        this.friends = new ArrayList<>();
    }

    public User() {
        this.friends = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Integer> getFriends() {
        return friends;
    }

    public void setFriends(List<Integer> friends) {
        this.friends = friends;
    }

    public boolean isFriend(Integer idFriend) {

        if (friends == null)
            return false;

        for (Integer u : friends) {

            System.out.println("Friends : " + u);

            if (u.equals(idFriend)) {

                return true;
            }
        }
        return false;
    }
}
