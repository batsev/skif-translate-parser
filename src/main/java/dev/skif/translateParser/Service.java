package dev.skif.translateParser;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@org.springframework.stereotype.Service
public class Service
{
    final private static Pattern LANG_PATTERN = Pattern.compile("skif_auth.*?user.*?lang.*?key\":.*?\"(.+?)\",", Pattern.DOTALL);

    final private static Pattern TRANSLATE_PATTERN = Pattern.compile("(?<=\")translate\\.(.+?)(?=\")");

    private static Properties RU_PROPS;

    private static Properties EN_PROPS;

    private static Properties KZ_PROPS;

    @PostConstruct
    public void init() throws IOException {
        List<String> arr = Arrays.asList("en", "ru", "kz");
        for(String translateItem:arr){
            Properties properties = new Properties();
            InputStream inputStream  = getClass().getClassLoader().getResourceAsStream(translateItem + ".properties");
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("property file ru.properties not found in the classpath");
            }
            switch (translateItem) {
                case ("ru"):
                    RU_PROPS = properties;
                    break;
                case ("kz"):
                    KZ_PROPS = properties;
                    break;
                default:
                    EN_PROPS = properties;
                    break;
            }
        }
    }

    public ResponseEntity<Object> translateMessage(String requestBody) {
        String lang = getLang(requestBody);
        if (lang == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        String response =  getTranslatedText(requestBody, lang);
        return ResponseEntity.ok(response);
    }

    private String getTranslatedText(String textToTranslate, String lang) {
        Properties properties;
        switch (lang) {
            case ("ru"):
                properties = RU_PROPS;
                break;
            case ("kz"):
                properties = KZ_PROPS;
                break;
            default:
                properties = EN_PROPS;
                break;
        }
        Matcher translateMatcher = TRANSLATE_PATTERN.matcher(textToTranslate);
        StringBuilder resultString = new StringBuilder();

        while(translateMatcher.find()){
            String translateKey = translateMatcher.group(1);
            translateMatcher.appendReplacement(resultString, properties.getProperty(translateKey));
        }

        translateMatcher.appendTail(resultString);

        return resultString.toString();
    }

    private String getLang(String requestBody) {
        Matcher langMatcher = LANG_PATTERN.matcher(requestBody);
        if(langMatcher.find()){
            return langMatcher.group(1);
        }
        return null;
    }
}
