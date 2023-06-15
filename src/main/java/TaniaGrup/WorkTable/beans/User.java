package TaniaGrup.WorkTable.beans;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {
    private String name;
    private String email;
    private String password;
    private String gender;
    private String note;
    private boolean married;
    private String birthday;
    private String profession;

}
