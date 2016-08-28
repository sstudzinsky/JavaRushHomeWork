package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Stanislav on 28.08.2016.
 */
public class Controller {
    private Provider[] providers;

    public Controller(Provider... providers) {
        this.providers = providers;

        if (providers.length == 0){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    public void scan() {
        List<Vacancy> vacancies = new ArrayList<>();
        try {
            for (Provider provider : providers) {
                List<Vacancy> providers = provider.getJavaVacancies(" ");
                for (Vacancy vacancy : providers) {
                    vacancies.add(vacancy);
                }
            }
        }
        catch (NullPointerException e){}

        System.out.println(vacancies.size());
    }
}
