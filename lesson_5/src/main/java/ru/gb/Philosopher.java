package ru.gb;

import java.util.Random;

public class Philosopher extends Thread {
    private final int NUMBER_OF_MEALS = 3;
    private String name;
    private int leftFork;
    private int rightFork;
    private int countEat = 0;
    private final Random random;
    private final Table table;

    public Philosopher(String name, Table table, int leftFork, int rightFork) {
        this.table = table;
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        random = new Random();
    }


    private void eating() throws InterruptedException {
        if (table.raiseTheForks(leftFork, rightFork)) {
            System.out.println(name + " кушает левой: " + (leftFork + 1) + " и правой: " + (rightFork + 1) + " вилкой");
            sleep(random.nextLong(3000, 6000));
            
            table.putTheForks(leftFork, rightFork);
            System.out.println(name + " вкусил: " + ++countEat + " прием пищи");
        }

    }

    private void thinking() throws InterruptedException {
        sleep(random.nextInt(100, 2000));
    }
    
    @Override
    public void run() {
        while (countEat < NUMBER_OF_MEALS) {
            try {
                thinking();
                eating();
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }
        }

        System.out.println(name + " наелся до отвала");
    }
}