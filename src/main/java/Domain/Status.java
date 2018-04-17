package Domain;


import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.Date;

@Getter
@Setter
public class Status {

    private Integer id;
    private String title;
    private String text;
    private File image;
    private Date date;
    private User owner;

    public Status(String text, User owner) {
        this.text = text;
        this.owner = owner;
    }
}
