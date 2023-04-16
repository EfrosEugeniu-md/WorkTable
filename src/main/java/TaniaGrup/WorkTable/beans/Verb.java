package TaniaGrup.WorkTable.beans;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity
public class Verb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String glagol;
    private String predlog;
    private Integer nomer;
    private String perevod;
    @Column(columnDefinition="TEXT")
    private String primer;
}

