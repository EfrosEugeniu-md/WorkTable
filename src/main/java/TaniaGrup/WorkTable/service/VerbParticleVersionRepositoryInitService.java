package TaniaGrup.WorkTable.service;

import TaniaGrup.WorkTable.beans.VerbParticleVersion;
import TaniaGrup.WorkTable.repository.VerbParticleVersionRepository;
import lombok.AllArgsConstructor;
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
    private VerbParticleVersionRepository verbRepository;

    public void init() throws IOException {
        Map<Integer, Map<Integer, List<String>>> mapMap = fileReadService.init("C:\\demo\\student.xls.xlsx");
        Map<Integer, List<String>> integerListMap = mapMap.get(0);

        for (Integer i : integerListMap.keySet()) {
            extracted(integerListMap, i);
        }
    }

    private void extracted(Map<Integer, List<String>> integerListMap, Integer i) {
        List<String> strings = integerListMap.get(i);
        try {
            verbRepository.save(getVerb(strings));
        } catch (Exception e) {
           strings.stream().forEach(System.out::println);
        }
    }

    private VerbParticleVersion getVerb(List<String> strings) {
        VerbParticleVersion verbParticleVersion = new VerbParticleVersion();
        verbParticleVersion.setVerb(getStringValue(strings,0));
        verbParticleVersion.setParticle(getStringValue(strings,1));
        verbParticleVersion.setVersion(getIntValue(strings.get(2)));
        verbParticleVersion.setSignificance(getStringValue(strings,3));
        verbParticleVersion.setExamples(getStringValue(strings,4));
        return verbParticleVersion;
    }


}
