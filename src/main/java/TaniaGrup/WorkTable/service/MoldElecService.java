package TaniaGrup.WorkTable.service;

import TaniaGrup.WorkTable.beans.Particle;
import TaniaGrup.WorkTable.repository.ParticleRepository;
import TaniaGrup.WorkTable.repository.ParticleVersionRepository;
import lombok.AllArgsConstructor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static TaniaGrup.WorkTable.service.Utils.getIntValue;
import static TaniaGrup.WorkTable.service.Utils.getStringValue;

@Service
@AllArgsConstructor
public class MoldElecService {
    private FileReadService fileReadService;

    private ParticleRepository particleRepository;
    private ParticleVersionRepository particleVersionRepository;

    public void init() throws IOException, InvalidFormatException {


        Map<Integer, Map<Integer, List<String>>> mapMap = fileReadService.init("C:\\demo\\График ремонта и технического обслуживания ЦФ на 2023г.xls");
        Map<Integer, List<String>> integerListMap = mapMap.get(2);

        for (Integer i : integerListMap.keySet()) {
            extracted(integerListMap, i);
        }
    }

    private void extracted(Map<Integer, List<String>> integerListMap, Integer i) {
        List<String> strings = integerListMap.get(i);

//        Particle particle = particleRepository.findFirstByParticle(getStringValue(strings, 0))
//                .orElse(null);
//
//        extracted(strings, getIntValue(strings.get(1)), particle);
    }

    private void extracted(List<String> strings, int intValue, Particle firstByParticle) {
        particleVersionRepository.findFirstByParticleAndVersion(firstByParticle, intValue)
                .map(v -> {
                    v.setDefinition(getStringValue(strings, 3));
                    particleVersionRepository.save(v);
                    return true;
                })
                .orElseGet(() -> {
                    firstByParticle.setType(getStringValue(strings, 2));
                    firstByParticle.setDefinition(getStringValue(strings, 3));
                    particleRepository.save(firstByParticle);
                    return false;
                });
    }
}
