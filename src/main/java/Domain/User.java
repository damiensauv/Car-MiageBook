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

}
