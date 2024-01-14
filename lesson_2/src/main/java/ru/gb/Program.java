package ru.gb;

import ru.gb.client.*;
import ru.gb.sender.*;
import ru.gb.server.*;

/**
 * lesson 2
 *
 */
public class Program 
{
    public static void main( String[] args )
    {
        ServerModelInterface serverModel = new ServerModel();
        SenderObservable senderModel = new Sender();
        
        ControllerInterface controller = new Controller(serverModel, senderModel);
        
        ServerView server = new ServerView(controller, serverModel);
        ClientView client1 = new ClientView(controller, new ClientModel());
        ClientView client2 = new ClientView(controller, new ClientModel());
        
        controller.registerClientOnServer(client1);
        controller.registerClientOnServer(client2);
        controller.registerSendingMessages(server);
        controller.registerSendingMessages(client1);
        controller.registerSendingMessages(client2);

    }
}




