package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Result extends JComponent {
    private BufferedImage startButton = null;
    private BufferedImage backButton = null;

    private Color newColor = new Color(255, 255, 255);

    Font letterFont = new Font("Arial Black", 0, 75);
    Font letterFont2 = new Font("Arial Black", 0, 150);
    Result(){}

    //Подключение изображений
    public void setImages(){
        try
        {
            //startButton = ImageIO.read(new File("images/StartButton.png"));
            backButton = ImageIO.read(new File("images/BackButton.png"));
        } catch (IOException e){e.printStackTrace();}
    }

    //Отрисовка изображений
    public void drawImages(Graphics g){
        g.drawImage(startButton,350, 350,500,50,null);
        g.drawImage(backButton,500, 700,200,50,null);
    }

    public void drawText(Graphics g) {
        g.setFont(letterFont);
        g.setColor(newColor);
        g.drawString("Ваш результат", 275, 250);
        g.setFont(letterFont2);
        g.drawString("" + ProgramExplorer.correctCounter + " из 20", 275, 450);
    }

    //Графическая функция
    public void paint(Graphics g){
        setImages();
        drawImages(g);
        drawText(g);
    }
}
