package com.aut.hw4.question2;

import java.io.*;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

/**
 * CharDictionary
 * it counts the number of each character in the input file , print and save them in another file
 * Created by mahdis safari on 15/03/2017.
 */
public class CharDictionary {
    /**
     * hashmap charCounter keeps characters and numbres of them
     */
    private HashMap<Character, Integer> charCounter;

    /**
     * CharDictionary
     * it creats and initializes the HashMap by 0
     */
    public CharDictionary() {
        charCounter = new HashMap<>();
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'g', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '.', ',', ';'};
        for (int i = 0; i < 29; i++) {
            charCounter.put(alphabet[i], 0);
        }
    }

    /**
     * CharFrequency
     *
     * @param nameOfFile name of file which we must read from and count its chars
     *                   it count each character's number and save them in HashMap
     */
    public void CharFrequency(String nameOfFile) {
        try {
            FileReader fileReader = new FileReader(nameOfFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            line = bufferedReader.readLine().toLowerCase();
            for (int i = 0; i < line.length(); i++) {
                char eachChar = line.charAt(i);
                if (eachChar != ' ')
                    charCounter.put(eachChar, charCounter.get(eachChar) + 1);
            }
        } catch (IOException ioe) {
            System.out.println("IOException : " + ioe);
        } catch (NullPointerException npe) {
            System.out.println("NullPointerException : " + npe);
        }
    }

    /**
     * saveFrequency
     * it saves data in HashMap in a new file
     */
    public void saveFrequency() {

        try {
            Formatter formatter = new Formatter("frequency.txt");
            Set<Character> sortedKeys = new TreeSet<>();
            sortedKeys.addAll(charCounter.keySet());
            for (char key : sortedKeys) {
                formatter.format("%s = %s%n", key, charCounter.get(key) + "");
            }
            formatter.close();
        } catch (IOException ioe) {
            System.out.println("IOException : " + ioe);
        }
    }

    /**
     * displayFrequency
     * it prints number of each character except ones which their number is 0
     */
    public void displayFrequency() {
        Set<Character> sortedKeys = new TreeSet<>();
        sortedKeys.addAll(charCounter.keySet());
        for (char key : sortedKeys) {
            if (charCounter.get(key) != 0)
                System.out.println(key + " = " + charCounter.get(key));
        }
    }
}
