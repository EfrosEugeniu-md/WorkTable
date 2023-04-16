package TaniaGrup.WorkTable.beans;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity
public class Particle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String particle;
    @Column(columnDefinition="TEXT")
    private String definition;

    @OneToMany(mappedBy = "particle", fetch = FetchType.LAZY)
    private Set<ParticleVersion> particleVersions = new HashSet<>();
}

