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
}
