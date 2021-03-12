package com.aut.hw4.question1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;

/**
 * SumSquares
 * it makes a file which contains square of anoter file's numbers and their sum
 * Created by mahdis safari on 15/03/2017.
 */
public class SumSquares {
    /**
     * numbers is an ArrayList which keeps integers
     */
    private ArrayList<Integer> numbers;

    /**
     * SumSquares
     * it biulds an Arraylist
     */
    public SumSquares() {
        numbers = new ArrayList<>();
    }

    public void setNumbers(ArrayList<Integer> inputArrayList) {
        numbers = inputArrayList;
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    /**
     * writeOutSquare
     * this method saves square integers and their sum existing in arraylist in input file
     */
    public void writeOutSquare() {
        try {
            Formatter formatter = new Formatter("SumSquares.txt");
            int sum = 0;
            for (int eachNumber : numbers) {
                formatter.format("%s ", eachNumber * eachNumber + "");
                sum += eachNumber * eachNumber;
            }
            formatter.format("%n%s", sum + "");
            formatter.close();
        } catch (IOException ioe) {
            System.out.printf("IOException : " + ioe);
        }
    }
}
