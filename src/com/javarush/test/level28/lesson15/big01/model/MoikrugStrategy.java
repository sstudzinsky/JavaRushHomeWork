package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stanislav on 30.08.2016.
 */
public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?page=%d&q=java+%s";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();

        try {
            for (int i = 1; ; i++) {
                Document document = getDocument(searchString, i);
                if (document == null)
                    break;

                Elements elements = document.getElementsByClass("job");
                if (elements.size() == 0 )
                    break;

                for (Element element : elements) {
                    Vacancy vacancy = new Vacancy();

                    vacancy.setUrl("https://moikrug.ru" + element.getElementsByClass("title").first().getElementsByTag("a").first().attr("href"));
                    vacancy.setTitle(element.getElementsByClass("title").first().text());
                    vacancy.setSiteName(document.title());
                    vacancy.setCity(element.getElementsByClass("location").text());
                    vacancy.setCompanyName(element.getElementsByClass("company_name").first().text());

                    Element salaryElement = element.select(".salary .count").first();
                    String salary = (salaryElement != null) ? salaryElement.text() : "";
                    salary = salary.replaceAll("<b>","").replaceAll("</b>","").replaceAll("\n","");

                    vacancy.setSalary(salary);

                    vacancies.add(vacancy);
                }
            }
        } catch (IOException e ) {}

        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        String url = String.format(URL_FORMAT, page, searchString);

        Document document = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
                .referrer("http://google.ru")
                .get();

        return document;
    }
}
