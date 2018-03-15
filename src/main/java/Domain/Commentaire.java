package Domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Commentaire {

    private Integer id;
    private Integer idStatus;
    private Date date;
    private User owner;
    private String text;

}
