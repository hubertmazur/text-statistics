import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.stream.Collectors;


public interface Statistics<T> {

    T analyse(String text);

    String analyzeWithFormattedOutput(String text);

    static Map<String,Long> getWordsMap(String text) {
        return Arrays.stream(text
                .toLowerCase()
                .split("[/. -]|\\r?\\n"))
                .map(x->x.replaceAll("[^\\p{LD}\\s]",""))
                .filter(x->!x.matches(""))
                .collect(Collectors.groupingBy(x->x, Collectors.counting()));
    }


}
