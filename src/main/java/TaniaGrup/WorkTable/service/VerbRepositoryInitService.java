package TaniaGrup.WorkTable.service;

import TaniaGrup.WorkTable.beans.Verb;
import TaniaGrup.WorkTable.repository.VerbRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VerbRepositoryInitService {
    private FileReadService fileReadService;
    private VerbRepository verbRepository;

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
            Verb verb = getVerb(strings);
            verbRepository.save(verb);
        } catch (Exception e) {
           strings.stream().forEach(System.out::println);
        }
    }

    private Verb getVerb(List<String> strings) {
        Verb verb = new Verb();
        verb.setGlagol(getStringValue(strings,0));
        verb.setPredlog(getStringValue(strings,1));
        verb.setNomer(getIntValue(strings.get(2)));
        verb.setPerevod(getStringValue(strings,3));
        verb.setPrimer(getStringValue(strings,4));
        return verb;
    }

    private String getStringValue(List<String> strings,int i) {
        return Optional.ofNullable(strings.get(i)).orElse("");
    }

    private int getIntValue(String strings) {
        try {
            int i = (Double.valueOf(strings)).intValue();
            return i;
        } catch (NumberFormatException e) {
            return 999;
        }
    }
}
