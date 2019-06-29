import com.detectlanguage.DetectLanguage;
import com.detectlanguage.Result;
import com.detectlanguage.errors.APIError;

import java.util.List;


public class APILanguageDetector implements LanguageDetector {


    public APILanguageDetector(String apiKey) {
        DetectLanguage.apiKey = apiKey;
    }

    public String detect(String text) {
        List<Result> results = null;
        try {
            results = DetectLanguage.detect(text);
        } catch (APIError apiError) {
            apiError.printStackTrace();
        }

        Result result = results.get(0);

        System.out.println("Language: " + result.language);
        System.out.println("Is reliable: " + result.isReliable);
        System.out.println("Confidence: " + result.confidence);


        return result.language;
    }


}
