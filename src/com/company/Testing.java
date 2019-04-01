package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Testing extends JComponent {

    private BufferedImage dactylGestures = null;
    private BufferedImage backButton = null;
    private char[] lettersArray = {'А','Б','В','Г','Д','Е','Ж','З','И','Й','К','Л','М','Н','О','П','Р','С','Т','У',
            'Ф','Х','Ц','Ч','Ш','Щ','Ъ','Ы','Ь','Э','Ю','Я'};
    private Color newColor = new Color(255, 255, 255);
    Font letterFont = new Font("Arial Black", 0, 100);
    Font counterFont = new Font("Arial Black", 0, 50);

   // int testGesture1 = 0 + (int) (Math.random() * 25);
    int testGesture1 = 0;
    int testGesture2 = 1;
    int testGesture3 = 2;
    int testGesture4 = 3;

    //Массив с правильными вариантами ответов. Первый элемент 0 не используется
   static int[] correctAnswerArray = {
            0,
            0 + (int) (Math.random() * 25),
            0 + (int) (Math.random() * 25),
            0 + (int) (Math.random() * 25),
            0 + (int) (Math.random() * 25),
            0 + (int) (Math.random() * 25),
            0 + (int) (Math.random() * 25),
            0 + (int) (Math.random() * 25),
            0 + (int) (Math.random() * 25),
            0 + (int) (Math.random() * 25),
            0 + (int) (Math.random() * 25),
            0 + (int) (Math.random() * 25),
            0 + (int) (Math.random() * 25),
            0 + (int) (Math.random() * 25),
            0 + (int) (Math.random() * 25),
            0 + (int) (Math.random() * 25),
            0 + (int) (Math.random() * 25),
            0 + (int) (Math.random() * 25),
            0 + (int) (Math.random() * 25),
            0 + (int) (Math.random() * 25),
            0 + (int) (Math.random() * 25)
    };

    //Массив с правильными вариантами ответов
    static int[] correctIndexArray = {
            0,
            1 + (int) (Math.random() * 4),
            1 + (int) (Math.random() * 4),
            1 + (int) (Math.random() * 4),
            1 + (int) (Math.random() * 4),
            1 + (int) (Math.random() * 4),
            1 + (int) (Math.random() * 4),
            1 + (int) (Math.random() * 4),
            1 + (int) (Math.random() * 4),
            1 + (int) (Math.random() * 4),
            1 + (int) (Math.random() * 4),
            1 + (int) (Math.random() * 4),
            1 + (int) (Math.random() * 4),
            1 + (int) (Math.random() * 4),
            1 + (int) (Math.random() * 4),
            1 + (int) (Math.random() * 4),
            1 + (int) (Math.random() * 4),
            1 + (int) (Math.random() * 4),
            1 + (int) (Math.random() * 4),
            1 + (int) (Math.random() * 4),
            1 + (int) (Math.random() * 4)
    };

    private int randFunction(int var){
        var = 0 + (int) (Math.random() * 25);
        return var;
    }

    Testing(){

    };

    //Функция позволяет избежать выход за пределы 25
    public int translateFunction(int a){
        if (a>15) {
            a = a - (0 + (int) (Math.random() * 10));
        } else {
            a = a + (0 + (int) (Math.random() * 10));
        }
        return a;
    }

    //Подключение изображений
    public void setImages(){
        try
        {
            dactylGestures = ImageIO.read(new File("images/gestures/"+correctAnswerArray[ProgramExplorer.testIndex]+".png"));
            backButton = ImageIO.read(new File("images/BackButton.png"));
        } catch (IOException e){e.printStackTrace();}
    }

    public void drawText(Graphics g){
        g.setFont(letterFont);
        g.setColor(newColor);

        // Вывод массива правильных вариантов ответа
        for (int i = 1; i < 20; i++) {
            System.out.print("|" + correctIndexArray[i] + "|");
        }


        switch (correctIndexArray[ProgramExplorer.testIndex]){
            case 1:
                testGesture1 = correctAnswerArray[ProgramExplorer.testIndex];
                testGesture2 = translateFunction(testGesture1+1);
                testGesture3 = translateFunction(testGesture1+3);
                testGesture4 = translateFunction(testGesture1+4);
                break;
            case 2:
                testGesture2 = correctAnswerArray[ProgramExplorer.testIndex];
                testGesture1 = translateFunction(testGesture2+1);
                testGesture3 = translateFunction(testGesture2+4);
                testGesture4 = translateFunction(testGesture2+6);
                break;
            case 3:
                testGesture3 = correctAnswerArray[ProgramExplorer.testIndex];
                testGesture1 = translateFunction(testGesture3+2);
                testGesture2 = translateFunction(testGesture3+4);
                testGesture4 = translateFunction(testGesture3+6);
                break;
            case 4:
                testGesture4 = correctAnswerArray[ProgramExplorer.testIndex];
                testGesture1 = translateFunction(testGesture2+2);
                testGesture2 = translateFunction(testGesture3+4);
                testGesture3 = translateFunction(testGesture4+6);
                break;

        }
        System.out.println("");

        g.drawString(""+lettersArray[testGesture1], 300, 200);
        g.drawString(""+lettersArray[testGesture2], 500, 200);
        g.drawString(""+lettersArray[testGesture3], 700, 200);
        g.drawString(""+lettersArray[testGesture4], 900, 200);

        g.setFont(counterFont);
        g.drawString(""+ProgramExplorer.testIndex + "/20", 1000, 600);

        System.out.println("choise = " + ProgramExplorer.choiseIndex);
        System.out.println("test = " + ProgramExplorer.testIndex);
        System.out.println("CORR = " + correctIndexArray[ProgramExplorer.testIndex]);

//        if(ProgramExplorer.choiseIndex==correctIndexArray[ProgramExplorer.testIndex]){
//            System.out.println("!");
//            ProgramExplorer.correctCounter++;
//        }

        if(ProgramExplorer.testIndex>19){
            ProgramExplorer.modeIndex = 210;
            System.out.println("correct !" + ProgramExplorer.correctCounter);
        }

        System.out.println("correct " + (ProgramExplorer.correctCounter));
        }

    //Отрисовка изображений
    public void drawImages(Graphics g){
        g.drawImage(dactylGestures, 450, 250,300,400,null);
        g.drawImage(backButton,500, 700,200,50,null);
    }

    //Графическая функция
    public void paint(Graphics g){
        setImages();
        drawText(g);
        drawImages(g);
    }
}
