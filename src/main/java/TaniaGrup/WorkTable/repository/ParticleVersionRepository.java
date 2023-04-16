package TaniaGrup.WorkTable.repository;

import TaniaGrup.WorkTable.beans.Particle;
import TaniaGrup.WorkTable.beans.ParticleVersion;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ParticleVersionRepository extends CrudRepository<ParticleVersion, Long> {
    Optional<ParticleVersion> findFirstByParticleAndVersion(Particle particle, int version);
}
