package com.aut.hw4.question4;

import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class FilterImage {
    private String inputFile;
    private String outputFile;

    public FilterImage(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public void filterRedColor() {
        try {
            File image = new File(inputFile);
            BufferedImage inputImage = ImageIO.read(image);
            int width = inputImage.getWidth();
            int heigth = inputImage.getHeight();
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < heigth; j++) {
                    int pxl = inputImage.getRGB(i, j);
                    int a = (pxl >> 24) & 0xff;
                    int r = 0;
                    int g = (pxl >> 8) & 0xff;
                    int b = pxl & 0xff;
                    pxl = (a << 24) | (r << 16) | (g << 8) | b;
                    inputImage.setRGB(i, j, pxl);
                }
            }
            File outputImage = new File(outputFile);
            ImageIO.write(inputImage, "jpg", outputImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void filterBlueColor() {
        try {
            File image = new File(inputFile);
            BufferedImage inputImage = ImageIO.read(image);
            int width = inputImage.getWidth();
            int heigth = inputImage.getHeight();
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < heigth; j++) {
                    int pxl = inputImage.getRGB(i, j);
                    int a = (pxl >> 24) & 0xff;
                    int r = (pxl >> 16) & 0xff;
                    int g = (pxl >> 8) & 0xff;
                    int b = 0;
                    pxl = (a << 24) | (r << 16) | (g << 8) | b;
                    inputImage.setRGB(i, j, pxl);
                }
            }
            File outputImage = new File(outputFile);
            ImageIO.write(inputImage, "jpg", outputImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void filterGreenColor() {

        try {
            File image = new File(inputFile);
            BufferedImage inputImage = ImageIO.read(image);
            int width = inputImage.getWidth();
            int heigth = inputImage.getHeight();
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < heigth; j++) {
                    int pxl = inputImage.getRGB(i, j);
                    int a = (pxl >> 24) & 0xff;
                    int r = (pxl >> 16) & 0xff;
                    int g = 0;
                    int b = pxl & 0xff;
                    pxl = (a << 24) | (r << 16) | (g << 8) | b;
                    inputImage.setRGB(i, j, pxl);
                }
            }
            ImageIO.write(inputImage, "jpg", new File(outputFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void blackWhite() {
        try {
            File image = new File(inputFile);
            BufferedImage img = ImageIO.read(image);
            int width = img.getWidth();
            int heigth = img.getHeight();
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < heigth; j++) {
                    int pxl = img.getRGB(i, j);
                    int a = (pxl >> 24) & 0xff;
                    int r = (pxl >> 16) & 0xff;
                    int g = (pxl >> 8) & 0xff;
                    int b = pxl & 0xff;
                    r = (r + g + b) / 3;
                    g = r;
                    b = r;
                    pxl = (a << 24) | (r << 16) | (g << 8) | b;
                    img.setRGB(i, j, pxl);
                }
            }
            ImageIO.write(img, "jpg", new File(outputFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void randomImage() {
        try {
            Random random = new Random();
            BufferedImage img = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
            for (int i = 0; i < 200; i++) {
                for (int j = 0; j < 200; j++) {
                    int a = random.nextInt(256);
                    int r = random.nextInt(256);
                    int g = random.nextInt(256);
                    int b = random.nextInt(256);
                    int pxl = (a << 24) | (r << 16) | (g << 8) | b;
                    img.setRGB(i, j, pxl);
                }
            }
            ImageIO.write(img, "jpg", new File(outputFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void duplicateImage() {
        try {
            File image = new File(inputFile);
            BufferedImage img = ImageIO.read(image);
            int width = img.getWidth();
            int heigth = img.getHeight();
            BufferedImage img1 = new BufferedImage(width, 2 * heigth, BufferedImage.TYPE_INT_ARGB);
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < heigth; j++) {
                    int pxl = img.getRGB(i, j);
                    img1.setRGB(i, j, pxl);
                }
            }
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < heigth; j++) {
                    int pxl = img.getRGB(i, j);
                    img1.setRGB(i, j + heigth, pxl);
                }
            }
            ImageIO.write(img1, "jpg", new File(outputFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void negativeImage() {/*
        double[][] mask = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mask[i][j] = 0.25;
            }
        }
        try {
            File output = new File("inputimg.jpg");
            BufferedImage img = ImageIO.read(output);
            int[][] pixels = new int[img.getWidth()][img.getHeight()];
            int[][] secondPixels = new int[img.getWidth()][img.getHeight()];
            for (int i = 0; i < img.getWidth(); i++) {
                for (int j = 0; j < img.getHeight(); j++) {
                    pixels[i][j] = img.getRGB(i, j);
                }
            }
            int pxl = (int)(img.getRGB(0, 0)*0.25 + img.getRGB(1, 0)*0.25 + img.getRGB(0, 1)*0.25 + img.getRGB(1, 1)*0.25)/9;
            img.setRGB(0, 0, pxl);
            pxl = (int)(img.getRGB(img.getWidth() - 2, 0)*0.25 + img.getRGB(img.getWidth() - 1, 0)*0.25 + img.getRGB(img.getWidth() - 2, 1)*0.25 + img.getRGB(img.getWidth() - 1, 1)*0.25)/9;
            img.setRGB(img.getWidth() - 1, 0, pxl);
            pxl = (int)(img.getRGB(0, img.getHeight() - 2)*0.25 + img.getRGB(0, img.getHeight() - 1)*0.25 + img.getRGB(1, img.getHeight() - 2)*0.25 + img.getRGB(1, img.getHeight() - 1)*0.25)/9;
            img.setRGB(0, img.getHeight() - 1, pxl);
            pxl = (int)(img.getRGB(img.getWidth() - 2, img.getHeight() - 2)*0.25 + img.getRGB(img.getWidth() - 1, img.getHeight() - 2)*0.25 + img.getRGB(img.getWidth() - 2, img.getHeight() - 1)*0.25 + img.getRGB(img.getWidth() - 1, img.getHeight() - 1)*0.25)/9;
            img.setRGB(img.getWidth() - 1, img.getHeight() - 1, pxl);
            for (int k=1; k< img.getHeight()-1;k++) {
                secondPixels[0][k] = (int) (pixels[0][k - 1] * 0.25 + pixels[0][k + 1] * 0.25 + pixels[1][k] * 0.25 + pixels[1][k + 1] * 0.25 + pixels[0][k] * 0.25 + 0 + pixels[1][k - 1] * 0.25) / 9;
                int firstColumn = secondPixels[0][k];
                img.setRGB(0, k, firstColumn);
                secondPixels[img.getWidth()-1][k] = (int) (pixels[img.getWidth() - 2][k] * 0.25 + pixels[img.getHeight()-2][k - 1] * 0.25 + pixels[img.getHeight()-1][k - 1] * 0.25 + pixels[img.getHeight()-1][k + 1] * 0.25 + pixels[img.getHeight()-1][k] * 0.25 + pixels[img.getHeight()-2][k + 1] * 0.25) / 9;
                int lastColumn = secondPixels[img.getHeight()-1][k];
                img.setRGB(img.getHeight(), k, lastColumn);
            }
            for (int l=1; l< img.getWidth()-1;l++) {
                secondPixels[l][0] = (int) (pixels[l - 1][0] * 0.25 + pixels[l][1] * 0.25 + pixels[l + 1][0] * 0.25 + pixels[l + 1][1] * 0.25 + pixels[l][0] * 0.25 + pixels[l - 1][1] * 0.25 + 0) / 9;
                int firstRow = secondPixels[0][l];
                img.setRGB(l, 0, firstRow);
                secondPixels[l][img.getWidth()-1] = (int) (pixels[l - 1][img.getWidth()-1] * 0.25 + pixels[l - 1][img.getWidth()-2] * 0.25 + pixels[l][img.getWidth()-2] * 0.25 + 0 + pixels[l + 1][img.getWidth()-1] * 0.25 + pixels[l][img.getWidth()-1] * 0.25 + 0 + pixels[l + 1][img.getWidth()-2] * 0.25) / 9;
                int lastRow = secondPixels[img.getHeight()-1][l];
                img.setRGB(l, img.getWidth(), lastRow);
            }
            for (int i = 1; i < img.getWidth() - 1; i++) {
                for (int j = 1; j < img.getHeight() - 1; j++) {
                        secondPixels[i][j] = (int) (pixels[i - 1][j] * 0.25 + pixels[i - 1][j - 1] * 0.25 + pixels[i][j - 1] * 0.25 + pixels[i][j + 1] * 0.25 + pixels[i + 1][j] * 0.25 + pixels[i + 1][j + 1] * 0.25 + pixels[i][j] * 0.25 + pixels[i - 1][j + 1] * 0.25 + pixels[i + 1][j - 1] * 0.25) / 9;
                        int result = secondPixels[i][j];
                        img.setRGB(i, j, result);
                }
            }
            File outputImage = new File("negativeimage.jpg");
            ImageIO.write(img, "jpg", outputImage);
        }
        catch (IOException ioe){
            System.out.println("IOException ioe : "+ ioe);
        }*/
        double[][] mask = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mask[i][j] = 0.25;
            }
        }
        try {
            BufferedImage img = ImageIO.read(new File(inputFile));
            int width = img.getWidth();
            int heigth = img.getHeight();
            int pxl = (img.getRGB(0, 0) + img.getRGB(1, 0) + img.getRGB(0, 1) + img.getRGB(1, 1)) / 36;
            img.setRGB(0, 0, pxl);
            pxl = (img.getRGB(width - 2, 0) + img.getRGB(width - 1, 0) + img.getRGB(width - 2, 1) + img.getRGB(width - 1, 1)) / 36;
            img.setRGB(width - 1, 0, pxl);
            pxl = (img.getRGB(0, heigth - 2) + img.getRGB(0, heigth - 1) + img.getRGB(1, heigth - 2) + img.getRGB(1, heigth - 1)) / 36;
            img.setRGB(0, heigth - 1, pxl);
            pxl = (img.getRGB(width - 2, heigth - 2) + img.getRGB(width - 1, heigth - 2) + img.getRGB(width - 2, heigth - 1) + img.getRGB(width - 1, heigth - 1)) / 36;
            img.setRGB(width - 1, heigth - 1, pxl);
            for (int i = 1; i < width - 2; i++) {
                pxl = (img.getRGB(i - 1, 0) + img.getRGB(i, 0) + img.getRGB(i + 1, 0) + img.getRGB(i - 1, 1) + img.getRGB(i, 1) + img.getRGB(i + 1, 1)) / 36;
                img.setRGB(i, 0, pxl);
            }
            for (int i = 1; i < width - 2; i++) {
                pxl = (img.getRGB(i - 1, heigth - 1) + img.getRGB(i, heigth - 1) + img.getRGB(i + 1, heigth - 1) + img.getRGB(i - 1, heigth - 2) + img.getRGB(i, heigth - 2) + img.getRGB(i + 1, heigth - 2)) / 36;
                img.setRGB(i, heigth - 1, pxl);
            }
            for (int i = 1; i < heigth - 1; i++) {
                pxl = (img.getRGB(0, i - 1) + img.getRGB(0, i) + img.getRGB(0, i + 1) + img.getRGB(1, i - 1) + img.getRGB(1, i) + img.getRGB(1, i + 1)) / 36;
                img.setRGB(0, i, pxl);
            }
            for (int i = 1; i < heigth - 1; i++) {
                pxl = (img.getRGB(width - 2, i - 1) + img.getRGB(width - 2, i) + img.getRGB(width - 2, i + 1) + img.getRGB(width - 1, i - 1) + img.getRGB(width - 1, i) + img.getRGB(width - 1, i + 1)) / 36;
                img.setRGB(width - 1, i, pxl);
            }
            for (int i = 1; i < width - 1; i++) {
                for (int j = 1; j < heigth - 1; j++) {
                    pxl = (img.getRGB(i - 1, j - 1) + img.getRGB(i, j - 1) + img.getRGB(i + 1, j - 1) +
                            img.getRGB(i - 1, j) + img.getRGB(i, j) + img.getRGB(i + 1, j) + img.getRGB(i - 1, j + 1) +
                            img.getRGB(i, j + 1) + img.getRGB(i + 1, j + 1)) / 36;
                    img.setRGB(i, j, pxl);
                }
            }

            ImageIO.write(img, "png", new File(outputFile));
        } catch (IOException ioe) {
            System.out.println("IOException : " + ioe);
        }
    }

    public void motionBlurImage() {
        try {
            BufferedImage img = ImageIO.read(new File(inputFile));
            int width = img.getWidth();
            int heigth = img.getHeight();
            BufferedImage image = new BufferedImage(width + 4, heigth + 4, BufferedImage.TYPE_INT_ARGB);
            for (int i = 0; i < width + 4; i++) {
                for (int j = 0; j < heigth + 4; j++) {
                    if ((i < 4) || (i >= width) || (j < 4) || (j >= heigth))
                        image.setRGB(i, j, 0);
                    else image.setRGB(i + 2, j + 2, img.getRGB(i, j));
                }
            }
            for (int i = 2; i < width + 2; i++) {
                for (int j = 2; j < heigth + 2; j++) {

                    int pxl1 = image.getRGB(i - 2, j - 2);
                    int a1 = (pxl1 >> 24) & 0xff;
                    int r1 = (pxl1 >> 16) & 0xff;
                    int g1 = (pxl1 >> 8) & 0xff;
                    int b1 = pxl1 & 0xff;
                    int pxl2 = image.getRGB(i - 1, j - 1);
                    int a2 = (pxl2 >> 24) & 0xff;
                    int r2 = (pxl2 >> 16) & 0xff;
                    int g2 = (pxl2 >> 8) & 0xff;
                    int b2 = pxl2 & 0xff;
                    int pxl3 = image.getRGB(i, j);
                    int a3 = (pxl3 >> 24) & 0xff;
                    int r3 = (pxl3 >> 16) & 0xff;
                    int b3 = pxl3 & 0xff;
                    int g3 = (pxl3 >> 8) & 0xff;
                    int pxl4 = image.getRGB(i + 1, j + 1);
                    int a4 = (pxl4 >> 24) & 0xff;
                    int r4 = (pxl4 >> 16) & 0xff;
                    int b4 = pxl4 & 0xff;
                    int g4 = (pxl4 >> 8) & 0xff;
                    int pxl5 = image.getRGB(i + 2, j + 2);
                    int a5 = (pxl5 >> 24) & 0xff;
                    int r5 = (pxl5 >> 16) & 0xff;
                    int g5 = (pxl5 >> 8) & 0xff;
                    int b5 = pxl5 & 0xff;
                    int finalA = (a1 + a2 + a3 + a4 + a5) / 5;
                    int finalR = (r1 + r2 + r3 + r4 + r5) / 5;
                    int finalG = (g1 + g2 + g3 + g4 + g5) / 5;
                    int finalB = (b1 + b2 + b3 + b4 + b5) / 5;
                    int finalPxl = (finalA << 24) | (finalR << 16) | (finalG << 8) | finalB;
                    image.setRGB(i - 2, j - 2, finalPxl);
                }
            }
            ImageIO.write(image, "jpg", new File(outputFile));
        } catch (IOException ioe) {
            System.out.println("IOExceotion : " + ioe);
        }
    }
}
