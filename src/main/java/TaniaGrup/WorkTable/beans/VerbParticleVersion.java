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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "verb_id")
    private Verb verb;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "particleVersion_id")
    private ParticleVersion particleVersion;

    private String additionalParticle;


    private String significance;
    @Column(columnDefinition="TEXT")
    private String examples;
}

