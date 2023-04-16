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
public class Verb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String verb;

    @OneToMany(mappedBy = "verb", fetch = FetchType.LAZY)
    private List<VerbParticleVersion> verbParticleVersions = new ArrayList<>();
}

