package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PracticeMode extends JComponent {
    private BufferedImage startButton = null;
    private BufferedImage backButton = null;

    PracticeMode(){}

    //Подключение изображений
    public void setImages(){
        try
        {
            startButton = ImageIO.read(new File("images/StartButton.png"));
            backButton = ImageIO.read(new File("images/BackButton.png"));
        } catch (IOException e){e.printStackTrace();}
    }

    //Отрисовка изображений
    public void drawImages(Graphics g){
        g.drawImage(startButton,350, 350,500,50,null);
        g.drawImage(backButton,500, 700,200,50,null);
    }

    //Графическая функция
    public void paint(Graphics g){
        setImages();
        drawImages(g);
    }
}
