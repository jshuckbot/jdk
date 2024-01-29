package ru.gb;

public class Table extends Thread {
    private final int PHILOSOPHER_COUNT = 5;
    private final Fork[] forks;
    private final Philosopher[] philosophers;

    public Table() {
        forks = new Fork[PHILOSOPHER_COUNT];
        philosophers = new Philosopher[PHILOSOPHER_COUNT];

        init();
    }

    private void init() {
        for (int i = 0; i < PHILOSOPHER_COUNT; i++) {
            forks[i] = new Fork();
            philosophers[i] = new Philosopher("Филосов №" + (i + 1), this,
                                              i, (i + 1) % PHILOSOPHER_COUNT);
        }
    }

    public synchronized boolean raiseTheForks(int leftFork, int rightFork) {
        if (forks[leftFork].isUse() && forks[rightFork].isUse()) {
            forks[leftFork].setUse(true);
            forks[rightFork].setUse(true);
            return true;
        }
        return false;
    }

    public void putTheForks(int leftFork, int rightFork) {
        forks[leftFork].setUse(false);
        forks[rightFork].setUse(false);
    }

    private void thinking() {
        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }
    }
    
    @Override
    public void run() {
        System.out.println("Программа запущена");
        try {
            thinking();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
