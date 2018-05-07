package Domain;

import lombok.Getter;
import lombok.Setter;

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
    private List<User> friends;

    public User(String email, String pseudo, String password, String name, String surname) {
        this.mail = email;
        this.pseudo = pseudo;
        this.password = password;
        this.prenom = name;
        this.nom = surname;
    }

    public User() {

    }

    public boolean isFriend(Integer idFriend) {

        if (friends == null)
            return false;

        for (User u : friends) {
            if (u.getId().equals(idFriend)) {
                return true;
            }
        }
        return false;
    }
}
