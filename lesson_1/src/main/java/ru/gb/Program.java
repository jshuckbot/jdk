package ru.gb;

/**
 * lesson 1
 *
 */
public class Program 
{
    public static void main( String[] args )
    {
        ServerWindow serverWindow = new ServerWindow();
        new ClientWindow(serverWindow);
        new ClientWindow(serverWindow);
    }
}


