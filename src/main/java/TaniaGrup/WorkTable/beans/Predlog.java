package TaniaGrup.WorkTable.beans;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity
public class Predlog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String predlog;
    private Integer nomer;
    private String perevod;
}

