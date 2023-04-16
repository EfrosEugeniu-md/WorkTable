package TaniaGrup.WorkTable.beans;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity
public class VerbParticleVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String verb;
    private String particle;
    private Integer version;
    private String significance;
    @Column(columnDefinition="TEXT")
    private String examples;
}

