package Domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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
