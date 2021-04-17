package com.redbird.lesson12;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PreDestroy;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

@SpringBootApplication
public class Lesson12Application implements CommandLineRunner {

    String source = null;
    String target = null;

    // Checksum app
    public static void main(String[] args) {
        SpringApplication.run(Lesson12Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length != 2)
        {
            System.out.println("Expected 2 args!");
            return;
        }
        source = args[0];
        target = args[1];
        String data = readFile(source);
        String hash = hash(data);
        if (hash == null) {
            return;
        }
        writeFile(target, hash);
        System.out.println("There is your checksum:");
        System.out.println(hash);
    }

    public String readFile(String source) {
        if (source == null) {
            return null;
        }
        File file = new File(source);
        StringBuilder data = new StringBuilder();

        Scanner sc = null;
        try {
             sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (sc == null) {
            return null;
        }

        while (sc.hasNextLine()) {
            data.append(sc.nextLine()).append('\n');
        }
        sc.close();
        return data.toString();
    }

    public String hash(String data) {
        if (data == null) {
            return null;
        }

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (md == null) {
            return null;
        }

        byte[] bytes = md.digest(data.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++)
        {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

    public void writeFile(String target, String hash) {
        if (hash == null) {
            return;
        }
        try {
            File file = new File(target);
            file.createNewFile();
            Writer wr = new FileWriter(file);
            wr.write(hash);
            wr.flush();
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @PreDestroy
    private void destroy() throws IOException {
        if (source != null)
        {
            File file = new File(source);
            Files.deleteIfExists(file.toPath());
        }
    }

}
