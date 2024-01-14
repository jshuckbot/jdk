package ru.gb.server;

import ru.gb.client.ClientObserver;

public interface ServerObservable {
    void registerObserver(ClientObserver observer);
    void removeObserver(ClientObserver observer);
    void notifyClientStatusObservers();

}


