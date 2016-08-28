package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Shiva on 19.06.2016.
 */
public class Hippodrome
{
    private ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses(){
        return horses;
    }

    public void run() throws InterruptedException{
        for (int i = 1; i < 101; i++) {
            this.move();
            this.print();
            Thread.sleep(200);
        }
    }
    public void move(){
        for (int i = 0; i < this.getHorses().size(); i++) {
            this.getHorses().get(i).move();
        }
    }
    public void print(){
        for (int i = 0; i < this.getHorses().size(); i++) {
            this.getHorses().get(i).print();
        }
        System.out.println();
    }

    public Horse getWinner(){
        double maxDistance = horses.get(0).getDistance();
        Horse winner = null;
        for (Horse horse : horses){
            if (horse.getDistance() > maxDistance) {
                maxDistance = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException {
         game = new Hippodrome();

        Horse stas = new Horse("Stas", 3, 0);
        Horse dima = new Horse("Dima", 3, 0);
        Horse toxa = new Horse("Toxa", 3, 0);

        game.getHorses().add(stas);
        game.getHorses().add(dima);
        game.getHorses().add(toxa);

        game.run();
        game.printWinner();
    }
}
