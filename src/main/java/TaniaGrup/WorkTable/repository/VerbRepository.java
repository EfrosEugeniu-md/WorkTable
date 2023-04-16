package TaniaGrup.WorkTable.repository;

import TaniaGrup.WorkTable.beans.Particle;
import TaniaGrup.WorkTable.beans.Verb;
import TaniaGrup.WorkTable.beans.VerbParticleVersion;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VerbRepository extends CrudRepository<Verb, Long> {
    Optional<Verb> findFirstByVerb(String particle);
}
