package ru.gb.client;

import ru.gb.ControllerInterface;
import ru.gb.sender.ReceiverObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ClientView extends JFrame implements ClientObserver, ReceiverObserver, Linkable {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    ClientModelInterface clientModel;
    ControllerInterface controller;

    JTextArea log;
    JTextField tfIPAddress;
    JTextField tfPort;
    JTextField tfLogin;
    JTextField tfMessage;
    JPasswordField password;
    JButton btnLogin;
    JButton btnSend;
    JPanel topPanel;


    private String name;


    public ClientView(ControllerInterface controller, ClientModelInterface model) {
        this.controller = controller;
        this.clientModel = model;
        
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat client");
//        setLocation(server.getX() - 500, server.getY());

        createPanel();

        setVisible(true);
    }

    private void createPanel() {
        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createLog());
        add(createFooter(), BorderLayout.SOUTH);
    }

    private Component createHeaderPanel() {
        topPanel = new JPanel(new GridLayout(2, 3));
        tfIPAddress = new JTextField("127.0.0.1");
        tfPort = new JTextField("8000");
        tfLogin = new JTextField("Sergey Petrov");
        password = new JPasswordField("password");
        btnLogin = new JButton("login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectToServer();
            }
        });

        topPanel.add(tfIPAddress);
        topPanel.add(tfPort);
        topPanel.add(new JPanel(), BorderLayout.EAST);
        topPanel.add(tfLogin);
        topPanel.add(password);
        topPanel.add(btnLogin);

        return topPanel;
    }

    private Component createLog() {
        log = new JTextArea();
        log.setEditable(false);
        return new JScrollPane(log);
    }

    private Component createFooter() {
        JPanel panel = new JPanel(new BorderLayout());
        tfMessage = new JTextField();
        tfMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n' && clientModel.getConnected()) {
                    pushMessage();
                }
            }
        });
        btnSend = new JButton("send");
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pushMessage();
            }
        });
        panel.add(tfMessage);
        panel.add(btnSend, BorderLayout.EAST);
        return panel;
    }

    public void pushMessage() {
        if (clientModel.getConnected()) {
            String text = tfMessage.getText();
            if (!text.equals("")) {
                text = name + ": " + text;
                controller.pushMessage(text);
                tfMessage.setText("");
            }
        } else {
            addLog("Нет подключения к серверу");
        }

    }

    private void addLog(String text) {
        log.append(text + "\n");
    }

    @Override
    public void connectToServer() {
        if (controller.isServerWorking()) {
            addLog("Вы подключились\n");
            topPanel.setVisible(false);
            clientModel.setConnected(true);
            name = tfLogin.getText();
            String log = controller.read();
            if (log != null){
                addLog(log);
            }
        } else {
            addLog("Подключение не успешно");
        }
    }


    @Override
    public void disconnectFromServer() {
        if (!clientModel.getConnected()) {
            topPanel.setVisible(true);
        }
    }

    @Override
    public void updateStatusServer(boolean isServerWorking) {

        clientModel.setServerWorking(isServerWorking);

        if (!controller.isServerWorking() && clientModel.getConnected()) {
            clientModel.setConnected(false);
            disconnectFromServer();
        }
    }

    @Override
    public void updateMessage(String message) {
        if (!clientModel.getConnected()){
            return;
        }
        addLog(message);
    }

}

