package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numb1 = Integer.parseInt(br.readLine());
        int numb2 = Integer.parseInt(br.readLine());

        ArrayList<Integer> numb1List = new ArrayList<>();
        ArrayList<Integer> numb2List = new ArrayList<>();

        ArrayList<Integer> numbAll = new ArrayList<>();

        for (int i = 1; i <= numb1; i++){
            if (numb1 % i == 0) numb1List.add(i);
        }
        for (int i = 1; i <= numb2; i++){
            if (numb2 % i == 0) numb2List.add(i);
        }

        for (int i = 0; i < numb1List.size(); i++ ){
            for (int k = 0; k < numb2List.size(); k++){
                if (numb1List.get(i) == numb2List.get(k))numbAll.add(numb1List.get(i));
            }
        }

        int min = numbAll.get(0);

        for (int i = 0; i < numbAll.size(); i++){
            if (numbAll.get(i) > min) min = numbAll.get(i);
        }

        System.out.println(min);
    }
}
