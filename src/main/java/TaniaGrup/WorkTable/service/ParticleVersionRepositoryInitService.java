package TaniaGrup.WorkTable.service;

import TaniaGrup.WorkTable.beans.ParticleVersion;
import TaniaGrup.WorkTable.repository.ParticleVersionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static TaniaGrup.WorkTable.service.Utils.getIntValue;
import static TaniaGrup.WorkTable.service.Utils.getStringValue;

@Service
@AllArgsConstructor
public class ParticleVersionRepositoryInitService {
    private FileReadService fileReadService;
    private ParticleVersionRepository predlogRepository;

    public void init() throws IOException {
        Map<Integer, Map<Integer, List<String>>> mapMap = fileReadService.init("C:\\demo\\student.xls.xlsx");
        Map<Integer, List<String>> integerListMap = mapMap.get(2);

        for (Integer i : integerListMap.keySet()) {
            extracted(integerListMap, i);
        }
    }

    private void extracted(Map<Integer, List<String>> integerListMap, Integer i) {
        List<String> strings = integerListMap.get(i);
        try {
            predlogRepository.save(getVerb(strings));
        } catch (Exception e) {
           strings.stream().forEach(System.out::println);
        }
    }

    private ParticleVersion getVerb(List<String> strings) {
        ParticleVersion particleVersion = new ParticleVersion();

       // particleVersion.setParticle(getStringValue(strings,0));
        particleVersion.setVersion(getIntValue(strings.get(1)));
        particleVersion.setSignificance(getStringValue(strings,2));
        particleVersion.setDefinition(getStringValue(strings,3));
        return particleVersion;
    }


}
