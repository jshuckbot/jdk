package ru.gb.server;

import ru.gb.client.ClientObserver;

import java.util.ArrayList;
import java.util.List;

public class ServerModel implements ServerModelInterface, ServerObservable {
    private List<ClientObserver> clientObservers;
    
    private boolean isServerWorking;
    
    
    @Override
    public void initialize() {
        clientObservers = new ArrayList<>();
        isServerWorking = false;
    }

    @Override
    public void run() {
        isServerWorking = true;
        notifyClientStatusObservers();
    }

    @Override
    public void stop() {
        isServerWorking = false;
        notifyClientStatusObservers();
        
    }

    @Override
    public void registerObserver(ClientObserver observer) {
        clientObservers.add(observer);
    }

    @Override
    public void removeObserver(ClientObserver observer) {
        clientObservers.remove(observer);
    }

    @Override
    public void notifyClientStatusObservers() {
        for (ClientObserver clientObserver : clientObservers) {
            ClientObserver observer = (ClientObserver) clientObserver;
            observer.updateStatusServer(isServerWorking);
        }
    }

    public boolean isServerWorking() {
        return isServerWorking;
    }

}
