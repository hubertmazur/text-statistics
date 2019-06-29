import java.util.*;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toMap;

public class LongesWordsStatistic implements  Statistics{
    @Override
    public List<String> analyse(String text) {
        Map <String, Long > wordsMap = Statistics.getWordsMap(text);
        wordsMap = wordsMap.entrySet().stream().filter(e -> e.getValue()==1)
                .sorted(comparingInt(e -> e.getKey().length()))
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));

     List <String> wordslist = new ArrayList<>(wordsMap.keySet());
     wordslist = wordslist.subList(wordslist.size()-10,wordslist.size());
        return wordslist;
    }

    @Override
    public String analyzeWithFormattedOutput(String text) {
        return String.format("Najdłuższe słowa występujące w tekscie tylko raz: %s", analyse(text));
    }
}