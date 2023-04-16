package TaniaGrup.WorkTable.service;

import java.util.List;
import java.util.Optional;

public class Utils {
    static String getStringValue(List<String> strings, int i) {
        return Optional.ofNullable(strings.get(i)).orElse("");
    }

    static int getIntValue(String strings) {
        try {
            int i = (Double.valueOf(strings)).intValue();
            return i;
        } catch (NumberFormatException e) {
            return 999;
        }
    }
}
