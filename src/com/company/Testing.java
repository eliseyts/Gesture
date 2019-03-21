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

    int testGesture1 = 0 + (int) (Math.random() * 25);
    Testing(){};
    //Подключение изображений
    public void setImages(){
        try
        {
            dactylGestures = ImageIO.read(new File("images/gestures/"+ProgramExplorer.testIndex+".png"));
            backButton = ImageIO.read(new File("images/BackButton.png"));
        } catch (IOException e){e.printStackTrace();}
    }

    public void drawText(Graphics g){
        g.setFont(letterFont);
        g.setColor(newColor);
        System.out.println(testGesture1);
        g.drawString(""+lettersArray[ProgramExplorer.testIndex], 300, 200);
        g.drawString(""+lettersArray[ProgramExplorer.testIndex+1], 500, 200);
        g.drawString(""+lettersArray[ProgramExplorer.testIndex+3], 700, 200);
        g.drawString(""+lettersArray[ProgramExplorer.testIndex+6], 900, 200);
        g.setFont(counterFont);
        g.drawString(""+ProgramExplorer.testIndex + "/32", 1000, 600);
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
