package ru.gb.server;

import ru.gb.ControllerInterface;
import ru.gb.sender.ReceiverObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ServerView extends JFrame implements ReceiverObserver {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private static final int POS_X = 500;
    private static final int POS_Y = 500;

    ServerModelInterface serverModel;
    ControllerInterface controller;

    private JButton btnStart;
    private JButton btnStop;
    private JTextArea log;


    public ServerView(ControllerInterface controller, ServerModelInterface model) {
        this.controller = controller;
        this.serverModel = model;
        createPanel();


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setAlwaysOnTop(true);
        setVisible(true);
    }

    private void createPanel() {
        add(createLog());
        add(createButtons(), BorderLayout.SOUTH);
    }
    
    private Component createLog() {
        log = new JTextArea();
        log.setEditable(false);
        return new JScrollPane(log);
    }

    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (serverModel.isServerWorking()) {
                    addLog("Сервер работает");
                } else {
                    controller.startServer();
                    addLog("Сервер запущен");
                    addLog(controller.read());
                }
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!serverModel.isServerWorking()) {
                    addLog("Сервер отключен");
                } else {
                    controller.pushMessage("Сервер остановлен");
                    controller.stopServer();
                }
            }
        });

        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }

    private void addLog(String text) {
        log.append(text + "\n");
    }

    @Override
    public void updateMessage(String message) {
        if (!serverModel.isServerWorking()) {
            return;
        }
        addLog(message);
        controller.write(message);
    }
}
