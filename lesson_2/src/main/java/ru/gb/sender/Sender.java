package ru.gb.sender;

import java.util.ArrayList;
import java.util.List;

public class Sender implements SenderObservable {
    private final List<ReceiverObserver> receiverObservers;
    private String message;

    public Sender() {
        receiverObservers = new ArrayList<>();
    }

    @Override
    public void registerObserver(ReceiverObserver observer) {
        receiverObservers.add(observer);
    }

    @Override
    public void notifyReceiverMessageObservers() {
        for (ReceiverObserver receiverObserver : receiverObservers) {
            ReceiverObserver observer = (ReceiverObserver) receiverObserver;
            observer.updateMessage(message);
        }
    }

    @Override
    public void pushMessage(String message) {
        this.message = message;
        notifyReceiverMessageObservers();
    }
}
