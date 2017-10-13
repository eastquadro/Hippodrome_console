package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eastquadro on 03.09.2017.
 */
public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<Horse>());
        game.getHorses().add(new Horse("Gnedaya",3,0));
        game.getHorses().add(new Horse("Rizhay",3,0));
        game.getHorses().add(new Horse("Staraya",3,0));

        game.run();
        game.printWinner();

    }
    public Horse getWinner()
    {
        Horse max = null;
        double distance = 0;
        for (Horse horse : getHorses())
        {
            if(horse.getDistance()>distance)
            {
                max = horse;
                distance = horse.getDistance();
            }
        }
        return max;

    }
    public void printWinner()
    {
        System.out.println("Winner is "+getWinner().getName()+"!");
    }

    public  void run() throws InterruptedException
    {
        for (int i = 1;i<101;i++)
        {
            move();
            print();
            Thread.sleep(200);
        }

    }
    public  void move()
    {
        for(Horse horse : getHorses())
        {
            horse.move();
        }
    }
    public  void print()
    {
        for(Horse horse : getHorses())
        {
            horse.print();
        }
        for (int i = 0;i<10;i++)
        {
            System.out.println();
        }
    }

}
