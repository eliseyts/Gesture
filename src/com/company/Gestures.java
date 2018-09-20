package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Gestures {
    private BufferedImage backButton = null;

    Gestures(){}

    //Подключение изображений
    public void setImages(){
        try
        {
            backButton = ImageIO.read(new File("images/BackButton.png"));
        } catch (IOException e){e.printStackTrace();}
    }

    
    //Отрисовка изображений
    public void drawImages(Graphics g){
        g.drawImage(backButton,500, 700,200,50,null);
    }

    public void paint(Graphics g){
        setImages();
        drawImages(g);
    }
}
