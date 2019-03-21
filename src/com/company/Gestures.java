package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Gestures {
    private BufferedImage backButton = null;
    private Color newColor = new Color(255, 255, 255);
    Font wordFont = new Font("Arial Black", 0, 150);
    Font textFont = new Font("Arial Black", 0, 14);

    private BufferedImage forwardButton = null;
    private BufferedImage backwardButton = null;
    private BufferedImage dactylGestures = null;
    private BufferedImage whiteBackground = null;

    Gestures(){}

    //Подключение изображений
    public void setImages(){
        try
        {
            forwardButton = ImageIO.read(new File("images/forward.png"));
            backwardButton = ImageIO.read(new File("images/backward.png"));
            backButton = ImageIO.read(new File("images/BackButton.png"));
            whiteBackground = ImageIO.read(new File("images/whiteBackground.png"));
        } catch (IOException e){e.printStackTrace();}
    }

    public void drawText(Graphics g){
        g.setFont(wordFont);
        g.setColor(newColor);
        //g.drawString(""+ wordArray[ProgramExplorer.gestureIndex], 550, 200);
        g.setFont(textFont);
    }

    //Подключение изображения жеста
    public void setGesture(){
        try
        {
            dactylGestures= ImageIO.read(new File("images/gestures2/Screenshot_"+ProgramExplorer.gestureIndex +".png"));
        } catch (IOException e){e.printStackTrace();}
    }

    //Отрисовка изображений
    public void drawImages(Graphics g){
        g.drawImage(whiteBackground, 200, 50,800, 400,null);
        g.drawImage(dactylGestures, 450, 75, 300, 350,null);
        g.drawImage(backButton,500, 700,200,50,null);
        g.drawImage(forwardButton,650, 500,100,100,null);
        g.drawImage(backwardButton,450, 500,100,100,null);
    }

    public void paint(Graphics g){
        setImages();
        setGesture();
        drawText(g);
        drawImages(g);
    }
}
