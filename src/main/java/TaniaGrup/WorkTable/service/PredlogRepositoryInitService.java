package TaniaGrup.WorkTable.service;

import TaniaGrup.WorkTable.beans.Predlog;
import TaniaGrup.WorkTable.beans.Verb;
import TaniaGrup.WorkTable.repository.PredlogRepository;
import TaniaGrup.WorkTable.repository.VerbRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static TaniaGrup.WorkTable.service.Utils.getIntValue;
import static TaniaGrup.WorkTable.service.Utils.getStringValue;

@Service
@AllArgsConstructor
public class PredlogRepositoryInitService {
    private FileReadService fileReadService;
    private PredlogRepository predlogRepository;

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

    private Predlog getVerb(List<String> strings) {
        Predlog verb = new Predlog();

        verb.setPredlog(getStringValue(strings,0));
        verb.setNomer(getIntValue(strings.get(1)));
        verb.setPerevod(getStringValue(strings,2));
       // verb.setPrimer(getStringValue(strings,4));
        return verb;
    }


}
