package TaniaGrup.WorkTable.service;

import TaniaGrup.WorkTable.beans.Particle;
import TaniaGrup.WorkTable.beans.ParticleVersion;
import TaniaGrup.WorkTable.beans.Verb;
import TaniaGrup.WorkTable.beans.VerbParticleVersion;
import TaniaGrup.WorkTable.repository.ParticleRepository;
import TaniaGrup.WorkTable.repository.ParticleVersionRepository;
import TaniaGrup.WorkTable.repository.VerbParticleVersionRepository;
import TaniaGrup.WorkTable.repository.VerbRepository;
import lombok.AllArgsConstructor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static TaniaGrup.WorkTable.service.Utils.getIntValue;
import static TaniaGrup.WorkTable.service.Utils.getStringValue;

@Service
@AllArgsConstructor
public class VerbParticleVersionRepositoryInitService {
    private FileReadService fileReadService;
    private VerbParticleVersionRepository verbParticleVersionRepository;
    private VerbRepository verbRepository;
    private ParticleRepository particleRepository;
    private ParticleVersionRepository particleVersionRepository;


    public void init() throws IOException, InvalidFormatException {
        Map<Integer, Map<Integer, List<String>>> mapMap = fileReadService.init("C:\\demo\\student.xls.xlsx");
        Map<Integer, List<String>> integerListMap = mapMap.get(0);

        for (Integer i : integerListMap.keySet()) {
            extracted(integerListMap, i);
        }
    }

    private void extracted(Map<Integer, List<String>> integerListMap, Integer i) {
        List<String> strings = integerListMap.get(i);

        verbParticleVersionRepository.save(getVerbParticleVersion(strings));
    }

    private VerbParticleVersion getVerbParticleVersion(List<String> strings) {
        Verb verb = getVerb(strings);

        Particle particle = getParticle(strings);

        ParticleVersion particleVersion = getParticleVersion(strings, particle);

        VerbParticleVersion verbParticleVersion = getVerbParticleVersion(strings, verb, particleVersion);

        particle.getParticleVersions().add(particleVersion);

        verb.getVerbParticleVersions().add(verbParticleVersion);
        particleVersion.getVerbParticleVersions().add(verbParticleVersion);

        return verbParticleVersion;
    }

    private ParticleVersion getParticleVersion(List<String> strings, Particle particle) {
        ParticleVersion particleVersion = new ParticleVersion();
        particleVersion.setParticle(particle);
        particleVersion.setVersion(getIntValue(strings.get(3)));

        ParticleVersion finalParticleVersion = particleVersion;
        particleVersion = particleVersionRepository
                .findFirstByParticleAndVersion(particleVersion.getParticle(), particleVersion.getVersion())
                .orElseGet(() -> particleVersionRepository.save(finalParticleVersion));

        return particleVersion;
    }

    private VerbParticleVersion getVerbParticleVersion(List<String> strings, Verb verb, ParticleVersion particleVersion) {
        VerbParticleVersion verbParticleVersion = new VerbParticleVersion();
        verbParticleVersion.setVerb(verb);
        verbParticleVersion.setParticleVersion(particleVersion);
        verbParticleVersion.setAdditionalParticle(strings.get(2));
        verbParticleVersion.setSignificance(getStringValue(strings, 4));
        verbParticleVersion.setExamples(getStringValue(strings, 5));
        return verbParticleVersion;
    }

    private Particle getParticle(List<String> strings) {
        Particle particle = new Particle();
        particle.setParticle(getStringValue(strings, 1));
        Particle finalParticle = particle;
        particle = particleRepository.findFirstByParticle(particle.getParticle())
                .orElseGet(() -> particleRepository.save(finalParticle));
        return particle;
    }

    private Verb getVerb(List<String> strings) {
        Verb verb = new Verb();
        verb.setVerb(getStringValue(strings, 0));
        Verb finalVerb = verb;
        verb = verbRepository.findFirstByVerb(verb.getVerb())
                .orElseGet(() -> verbRepository.save(finalVerb));
        return verb;
    }
}
