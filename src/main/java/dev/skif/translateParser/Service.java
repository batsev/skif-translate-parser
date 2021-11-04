package dev.skif.translateParser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@org.springframework.stereotype.Service
public class Service
{
    final private static Pattern LANG_PATTERN = Pattern.compile("skif_auth.*?user.*?lang.*?key\":.*?\"(.+?)\",", Pattern.DOTALL);

    final private static Pattern TRANSLATE_PATTERN = Pattern.compile("(?<=\")translate\\.(.+?)(?=\")");

    private static String PROP_FILE_NAME;

    public String translateMessage(String requestBody) throws IOException {
        String lang = getLang(requestBody);

        Properties properties = new Properties();
        PROP_FILE_NAME = lang + ".properties";
        InputStream inputStream  = getClass().getClassLoader().getResourceAsStream(PROP_FILE_NAME);

        if (inputStream != null) {
            properties.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + PROP_FILE_NAME + "' not found in the classpath");
        }

        String translatedText = getTranslatedText(requestBody, properties);

        return translatedText;
    }

    private String getTranslatedText(String textToTranslate, Properties properties) {
        Matcher translateMatcher = TRANSLATE_PATTERN.matcher(textToTranslate);
        StringBuffer resultString = new StringBuffer();

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
