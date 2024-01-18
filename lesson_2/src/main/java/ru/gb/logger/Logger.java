package ru.gb.logger;

import java.io.FileReader;
import java.io.FileWriter;

public class Logger implements Loggable {
    private static final String LOG_PATH = "./logs.txt";
    
    @Override
    public void write(String message) {
        try (FileWriter writer = new FileWriter(LOG_PATH, true)){
            writer.write(message);
            writer.write("\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String read() {
        StringBuilder messages = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH);){
            int letter;
            while ((letter = reader.read()) != -1){
                messages.append((char) letter);
            }
            messages.delete(messages.length()-1, messages.length());
            return messages.toString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
