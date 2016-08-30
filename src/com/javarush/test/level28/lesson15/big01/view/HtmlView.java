package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class HtmlView implements View {
    private Controller controller;
    private final String filePath = "./src/" + this.getClass().getPackage().getName().replaceAll("\\.", "/") + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies) {
        String updateInfo = getUpdatedFileContent(vacancies);
        updateFile(updateInfo);
    }

    private String getUpdatedFileContent(List<Vacancy> list){
        try{
            Document doc = getDocument();
            doc.select("tr[class=vacancy]").remove();

            Element templateOriginal = doc.getElementsByClass("template").first();
            Element copy = templateOriginal.clone();
            copy.removeAttr("style");
            copy.removeClass("template");

            for (int i = 0; i < list.size(); i++) {
                Vacancy vacancy = list.get(i);
                Element element = copy.clone();

                Element city = element.getElementsByClass("city").first();
                Element companyName = element.getElementsByClass("companyName").first();
                Element salary = element.getElementsByClass("salary").first();
                Element aTitle = element.getElementsByTag("a").first();

                city.text(vacancy.getCity());
                companyName.text(vacancy.getCompanyName());
                salary.text(vacancy.getSalary());
                aTitle.attr("href", vacancy.getUrl());
                aTitle.text(vacancy.getTitle());

                templateOriginal.before(element.outerHtml());
            }

            return doc.html();

        } catch (IOException e){
            e.printStackTrace();
            return "Some exception occurred";
        }
    }

    private void updateFile(String s){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(s.toCharArray());
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected Document getDocument() throws IOException{
        return Jsoup.parse(new File(filePath), "UTF-8");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Odessa");
    }
}
