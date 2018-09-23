package main.java;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

/**
 * Created by dinahas on 22.09.2018.
 * This class is used to get translation from Yandex.Translator
 */
public class Translator {

    private static final String HTTP = "https://translate.yandex.net/api/v1.5/tr.json/translate?";
    private static final String KEY = "key=trnsl.1.1.20180922T151114Z.cc661491881f36e0.04e23a46d24baee1927deaeb079648d26ce54b3f";
    private static final String LANG = "&lang=en-ru";

    public static String yandexTranslate(String text) throws IOException{
        String address =  HTTP +
                KEY +
                "&text=" + URLEncoder.encode(text, "UTF-8") +
                LANG;

        //connectin to Yandex.Translator
        URL url = new URL(address);
        HttpURLConnection connection = ((HttpURLConnection) url.openConnection());
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.connect();

        //getting json string from yandex
        InputStream input = connection.getInputStream();
        String json = new Scanner(input).nextLine();
        int start = json.indexOf("[");
        int end = json.indexOf("]");
        //getting translation
        String translated = json.substring(start + 2, end - 1);

        return translated;
    }
}

