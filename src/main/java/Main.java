package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dinahas on 22.09.2018.
 */
public class Main {
    public static void main (String[] args) throws IOException {
        System.out.println("Write '/stop' to stop the program");
        while (true){
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String text = bf.readLine();
            if (text.equals("/stop")) break;
            String translation = Translator.yandexTranslate(text);
            System.out.println(translation);
        }
    }
}
