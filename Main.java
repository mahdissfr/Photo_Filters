package com.aut.hw4;

import com.aut.hw4.question1.SumSquares;
import com.aut.hw4.question2.CharDictionary;
import com.aut.hw4.question3.LCS;
import com.aut.hw4.question4.FilterImage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //runQuestion1();
        runQuestion2();
        runQuestion3();
        runQuestion4();
    }

    private static void runQuestion1() {
        ArrayList<Integer> inputs = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int numbersOfInputs = scanner.nextInt();
        for (int i = 0; i < numbersOfInputs; i++) {
            inputs.add(scanner.nextInt());
        }
        SumSquares sumSquares = new SumSquares();
        sumSquares.setNumbers(inputs);
        sumSquares.writeOutSquare();
    }

    private static void runQuestion2() {
        CharDictionary charDictionary = new CharDictionary();
        charDictionary.CharFrequency("chardir.txt");
        charDictionary.displayFrequency();
        charDictionary.saveFrequency();
    }

    private static void runQuestion3() {
        LCS lcs = new LCS();
        lcs.longestCommonSubsequence("File1.txt", "File2.txt");
    }

    private static void runQuestion4() {
        FilterImage RedImage = new FilterImage("inputimg.jpg", "redoutput.jpg");
        RedImage.filterRedColor();
        FilterImage blueImage = new FilterImage("inputimg.jpg", "blueoutput.jpg");
        blueImage.filterBlueColor();
        FilterImage GreenImage = new FilterImage("inputimg.jpg", "greenoutput.jpg");
        GreenImage.filterGreenColor();
        FilterImage blackAndWhiteImage = new FilterImage("inputimg.jpg", "b&woutput.jpg");
        blackAndWhiteImage.blackWhite();
        FilterImage rndImage = new FilterImage("inputimg.jpg", "randomoutput.jpg");
        rndImage.randomImage();
        FilterImage duplicatedImage = new FilterImage("inputimg.jpg", "duplicatedoutput.jpg");
        duplicatedImage.duplicateImage();
        FilterImage nImage = new FilterImage("inputimg.jpg", "negativeoutput.jpg");
        nImage.negativeImage();
        FilterImage mBImage = new FilterImage("inputimg.jpg", "motionbluroutput.jpg");
        mBImage.motionBlurImage();
    }

}
