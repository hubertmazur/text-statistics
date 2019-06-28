import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCountStatistic implements Statistics <Long>  {

    @Override
    public Long analyse(String text) {
        return Statistics.getWordsMap(text)
                .values()
                .stream()
                .reduce(Long::sum)
                .orElseThrow(IllegalArgumentException::new);
    }


    @Override
    public String analyzeWithFormattedOutput(String text) {
        return String.format("Tekst zawiera %d słów", analyse(text));
    }



    public  Long analyse2 (String text) {
        Map<String,Long> wordsmap = Statistics.getWordsMap(text) ;
        long sumWords = 0;
        for (Long values : wordsmap.values()) {
            sumWords+= values ;
        }
        return sumWords;
    }
}
