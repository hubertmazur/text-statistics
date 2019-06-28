import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LettersFrequencyStatistic implements  Statistics {
    @Override
    public Map<Character,Long> analyse(String text) {
        Map<String, Long> wordsMap = Statistics.getWordsMap(text);
       List<String>  words = wordsMap.keySet().stream().collect(Collectors.toList());
       List <Character > letters = new ArrayList<>();
       words.forEach(w -> {
           for (int i = 0; i < w.length(); i++) {
               letters.add(w.charAt(i));
           }
       });
        Map <Character,Long> letersMap = letters.stream().collect(Collectors.groupingBy(x->x, Collectors.counting()));

        return letersMap;
    }

    @Override
    public String analyzeWithFormattedOutput(String text) {
        return String.format("Częstotliwość wystapienia liter: %s" , analyse(text));
    }


}
