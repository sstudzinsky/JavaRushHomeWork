package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

/**
 * Created by Stanislav on 28.08.2016.
 */
public class HHStrategy implements Strategy {
    String urlAddress = "http://javarush.ru/testdata/big28data.html";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        try {
            Document document = Jsoup.connect(urlAddress).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36").referrer("http://google.ru").get();

            document.html();
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected Document getDocument(String searchString, int page) throws IOException{

    }

    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
}
