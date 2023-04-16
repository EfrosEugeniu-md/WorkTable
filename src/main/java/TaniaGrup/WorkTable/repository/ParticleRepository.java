package TaniaGrup.WorkTable.repository;

import TaniaGrup.WorkTable.beans.Particle;
import TaniaGrup.WorkTable.beans.VerbParticleVersion;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ParticleRepository extends CrudRepository<Particle, Long> {
    Optional<Particle> findFirstByParticle(String particle);
}
