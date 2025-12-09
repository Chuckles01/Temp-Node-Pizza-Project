package org.example;

public class Main {

    private static WindowManager frame;

    public static void main(String[] args) {
        try {
            frame = new WindowManager();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}