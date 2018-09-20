package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LearnMode extends JComponent {


    private BufferedImage dactylButton = null;
    private BufferedImage jesturesButton = null;
    private BufferedImage backButton = null;

    LearnMode(){}

    //Подключение изображений
    public void setImages(){
        try
        {
            dactylButton = ImageIO.read(new File("images/DactylButton.png"));
            jesturesButton = ImageIO.read(new File("images/JesturesButton.png"));
            backButton = ImageIO.read(new File("images/BackButton.png"));
        } catch (IOException e){e.printStackTrace();}
    }

    //Отрисовка изображений
    public void drawImages(Graphics g){
        g.drawImage(dactylButton,350, 300,500,50,null);
        g.drawImage(jesturesButton,350, 450,500,50,null);
        g.drawImage(backButton,500, 700,200,50,null);
    }

    //Графическая функция
    public void paint(Graphics g){
        setImages();
        drawImages(g);
    }
}
