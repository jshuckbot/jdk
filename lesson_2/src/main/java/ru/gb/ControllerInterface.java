package ru.gb;

import ru.gb.client.ClientObserver;
import ru.gb.sender.ReceiverObserver;

public interface ControllerInterface {
    void startServer();
    void stopServer();
    void pushMessage(String message);
    boolean isServerWorking();
    void write(String message);
    String read();
    void registerClientOnServer(ClientObserver observer);
    void registerSendingMessages(ReceiverObserver observer);
}

