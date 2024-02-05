package ru.gb;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MontyHallParadox {
    private final static int DOORS = 3;
    private static Random random;
    private final Map<Integer, Boolean> statistics;
    private int wins;

    public MontyHallParadox() {
        random = new Random();
        statistics = new HashMap<>();
        
        run();
        calcWins();
        
    }
    
    private void run() {
        for (int i = 0; i < 1000; i++) {
            nextAttempt(i);
        }
    }
    
    private void calcWins() {
        for (Map.Entry<Integer, Boolean> entry: statistics.entrySet()){
            if (entry.getValue()){
                wins++;
            }
        }
    }
    
    public void viewWins() {
        System.out.println("Игроку удалось выиграть " + wins + " раз");
    }

    private void nextAttempt(int attempt) {
        int luckyDoor = random.nextInt(DOORS);
        int firstChoice = random.nextInt(DOORS);
        int freeOpenDoor = changeChoice(luckyDoor, firstChoice);
        int secondChoice = changeChoice(freeOpenDoor, firstChoice);

        statistics.put(attempt, luckyDoor == secondChoice);
    }
    
    private int changeChoice(int door, int numberChoice) {
        int choice = 0;
        for (int i = 0; i < DOORS; i++) {
            if (i != door && i != numberChoice){
                choice = i;
            }
        }
        return choice;
    }
}
