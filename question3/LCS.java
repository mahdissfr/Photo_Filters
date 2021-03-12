package com.aut.hw4.question3;

import java.io.*;
import java.util.ArrayList;

/**
 * LCS
 * it finds the longest common string between to txt file and write it in a new one
 * Created by mahdis safari on 17/03/2017.
 */
public class LCS {
    /**
     * longestCommonSubsequence
     *
     * @param nameOfFile1 address of file1
     * @param nameOFFile2 address of file2
     *                    it finds longest Common String between File1 and File2
     */
    public void longestCommonSubsequence(String nameOfFile1, String nameOFFile2) {
        ArrayList<String> commonStrings = new ArrayList<>();
        String firstFilesLines, secondFilesLines, eachCommonString = "";

        try {
            FileReader firstFileReader = new FileReader(nameOfFile1);
            FileReader secondFileReader = new FileReader(nameOFFile2);
            BufferedReader firstBufferReader = new BufferedReader(firstFileReader);
            BufferedReader secondBufferReader = new BufferedReader(secondFileReader);
            String AllLinesOfFirstOne = "", AllLinesOfSecondOne = "";
            while ((firstFilesLines = firstBufferReader.readLine()) != null) {
                AllLinesOfFirstOne = AllLinesOfFirstOne + firstFilesLines + " ";
            }
            String[] charsOfFirstFile = AllLinesOfFirstOne.split("");
            while ((secondFilesLines = secondBufferReader.readLine()) != null) {
                AllLinesOfSecondOne = AllLinesOfSecondOne + secondFilesLines + " ";
            }
            String[] charsOfSecondFile = AllLinesOfSecondOne.split("");
            firstFileReader.close();
            secondFileReader.close();
            for (int i = 0; i < charsOfFirstFile.length; i++) {
                for (int j = 0; j < charsOfSecondFile.length; j++) {

                    if (charsOfFirstFile[i].equals(charsOfSecondFile[j])) {
                        eachCommonString = charsOfFirstFile[i];
                        if ((j + 1 < charsOfFirstFile.length) && (i + 1 < charsOfFirstFile.length) && charsOfFirstFile[i + 1].equals(charsOfSecondFile[j + 1])) {
                            eachCommonString = eachCommonString + charsOfFirstFile[i + 1];
                            int k = i + 2, m = j + 2;
                            while ((k < charsOfFirstFile.length) && (m < charsOfSecondFile.length)) {
                                if (charsOfFirstFile[k].equals(charsOfSecondFile[m])) {
                                    eachCommonString = eachCommonString + charsOfFirstFile[k];
                                    k++;
                                    m++;
                                } else break;
                            }
                            commonStrings.add(eachCommonString);
                        }
                    }
                }
            }
            String longest = commonStrings.get(0);
            for (int i = 0; i < commonStrings.size(); i++) {
                if (commonStrings.get(i).length() > longest.length())
                    longest = commonStrings.get(i);
            }

            FileWriter fileWriter = new FileWriter("longest.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(longest);

            bufferedWriter.close();
            fileWriter.close();

        } catch (FileNotFoundException fnfe) {
            System.out.println("FileNotFoundException : " + fnfe);
        } catch (IOException ioe) {
            System.out.println("IOException : " + ioe);
        } catch (NullPointerException npe) {
            System.out.println("NullPointerException : " + npe);
        }
    }
}