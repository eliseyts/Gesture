package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Description extends JComponent {


    private BufferedImage information = null;
    private BufferedImage backButton = null;

    Description(){}

    //Подключение изображений
    public void setImages(){
        try
        {
            information = ImageIO.read(new File("images/information2.png"));
            backButton = ImageIO.read(new File("images/BackButton.png"));
        } catch (IOException e){e.printStackTrace();}
    }

    //Отрисовка изображений
    public void drawImages(Graphics g){
        g.drawImage(information,10, 10,1200,640,null);
        g.drawImage(backButton,500, 700,200,50,null);
    }

    //Графическая функция
    public void paint(Graphics g){
        setImages();
        drawImages(g);
    }
}

