package ru.gb.server;

public interface ServerModelInterface {
    void initialize();
    void run();
    void stop();
    
    boolean isServerWorking();
    
}


