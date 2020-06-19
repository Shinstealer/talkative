package com.shinstealler.talkative.etc;

public class Test1 {

    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();
        StringBuilder builder = new StringBuilder();

        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                buffer.append(i);
                builder.append(i);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                buffer.append(i);
                builder.append(i);
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(5000);

                System.out.println("buffer length" + buffer.length());
                System.out.println("builder length" + builder.length());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

    }

}