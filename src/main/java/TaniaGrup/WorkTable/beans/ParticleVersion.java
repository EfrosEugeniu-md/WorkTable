package TaniaGrup.WorkTable.beans;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity
public class ParticleVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "particle_id")
    private Particle particle;

    private Integer version;
    private String significance;
    @Column(columnDefinition="TEXT")
    private String definition;

    @OneToMany(mappedBy = "particleVersion", fetch = FetchType.LAZY)
    private List<VerbParticleVersion> verbParticleVersions = new ArrayList<>();
}

