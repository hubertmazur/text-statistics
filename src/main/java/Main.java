
public class Main {

    public static void main(String[] args) {
        //Statistics wcs = new LongesWordsStatistic();
       // System.out.println(wcs.analyzeWithFormattedOutput("Śród takich pól przed laty, nad brzegiem ruczaju,\n" + "Na pagórku niewielkim, we brzozowym gaju,\n" + "Stał dwór szlachecki, z drzewa, lecz podmurowany;\n" + "Świeciły się z daleka pobielane ściany,\n" + "Tym bielsze, że odbite od ciemnej zieleni\n" + "Topoli, co go bronią od wiatrów jesieni.\n" + "Dom mieszkalny niewielki, l"));

        APILanguageDetector api = new APILanguageDetector("f6ea54fbb725dedc4b2235914d10440a");

    System.out.println(api.detect("Litwo! Ojczyzno moja! ty jesteś jak zdrowie:\n"
            + "Ile cię trzeba cenić, ten tylko się dowie,\n" + "Kto cię stracił. Dziś piękność twą w całej ozdobie\n"
            + "Widzę i opisuję, bo tęsknię po tobie."));


    }
}
