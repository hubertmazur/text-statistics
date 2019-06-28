import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MostPopularWordsStatistic implements  Statistics{
    @Override
    public List<String> analyse(String text) {
        Map<String,Long> wordsmap = Statistics.getWordsMap(text) ;

        wordsmap =  wordsmap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return wordsmap.keySet().stream().limit(10).collect(Collectors.toList());
    }

    @Override
    public String analyzeWithFormattedOutput(String text) {
        return String.format("10 najpoplarniejszych słów: %s ", analyse(text));
    }
}
