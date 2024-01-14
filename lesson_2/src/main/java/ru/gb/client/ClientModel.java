package ru.gb.client;

public class ClientModel implements ClientModelInterface {
    private boolean isConnected = false;
    private boolean isServerWorking = false;

    @Override
    public void setConnected(boolean isWork) {
        isConnected = isWork;
    }

    @Override
    public boolean getConnected() {
        return isConnected;
    }

    public void setServerWorking(boolean serverWorking) {
        isServerWorking = serverWorking;
    }
}
