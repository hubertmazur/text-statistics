import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MyLanguageDetector implements  LanguageDetector {


    @Override
    public String detect(String text) {
      LettersFrequencyStatistic lettersFrequencyStatistic = new LettersFrequencyStatistic();
        Map <Character, Double> mapLetters = lettersFrequencyStatistic.analyse(text);
        Map < String, Double > languageMap =  new HashMap<>();


       languageMap.put("PL", getVariation(mapLetters, LanguagesData.polishMap));
     languageMap.put("EN", getVariation(mapLetters, LanguagesData.englishMap));
       languageMap.put("DE", getVariation(mapLetters, LanguagesData.germanMap));
       languageMap.put("FR", getVariation(mapLetters, LanguagesData.frenchhMap));
       languageMap.put("ES", getVariation(mapLetters, LanguagesData.spanishMap));




        languageMap =  languageMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return languageMap.keySet().stream().findFirst().get();
    }

    private  double getVariation (Map <Character, Double> mapLetters, Map <Character, LetterStat> lenguageMap) {

        int n = mapLetters.size();
        double variation = 0;

        for (Character c : mapLetters.keySet()) {

            if (lenguageMap.containsKey(c)) {
                variation += Math.pow((mapLetters.get(c) - lenguageMap.get(c).getPercent()),2);
            }
            else  {
                variation += Math.pow(mapLetters.get(c), 2) ;

            }
            variation = variation/ n;

        }

        return variation;


    }
}
