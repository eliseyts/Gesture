package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuMode extends JComponent {

    public LearnMode learnMode = new LearnMode();
    public PracticeMode practiceMode = new PracticeMode();
    public Testing testing = new Testing();
    public Dactyl dactyl = new Dactyl();
    public Gestures gestures = new Gestures();
    public Description description = new Description();

    private BufferedImage learningButton = null;
    private BufferedImage practiceButton = null;
    private BufferedImage translateButton = null;
    private BufferedImage logo= null;
    private BufferedImage info= null;

    private Color newColor = new Color(255, 255, 255);
    private Font font = new Font("Arial Black", 0, 35);

    MenuMode(){}

    //Подключение изображений
    public void setImages(){
        try
        {
            practiceButton = ImageIO.read(new File("images/PracticeButton.png"));
            learningButton = ImageIO.read(new File("images/LearningButton.png"));
            translateButton = ImageIO.read(new File("images/TranslateButton.png"));
            logo = ImageIO.read(new File("images/Logo.png"));
            info = ImageIO.read(new File("images/info.png"));
        } catch (IOException e){e.printStackTrace();}
    }

    //Отрисовка изображений
    public void drawIcons(Graphics g){
        g.drawImage(learningButton,150, 300,250,250,null);
        g.drawImage(practiceButton,475, 300,250,250,null);
        g.drawImage(translateButton,800, 300,250,250,null);
        g.drawImage(logo,400, 50,400,150,null);
        g.drawImage(info,1100, 675,75,75,null);
    }

    //Отрисовка текста
    public void drawText(Graphics g){
        g.setFont(font);
        g.setColor(newColor);
        g.drawString("ОБУЧЕНИЕ", 170, 580);
        g.drawString("ПРАКТИКА", 505, 580);
        g.drawString("ОСНОВЫ", 855, 580);
    }

    //Графическая функция
    public void paint(Graphics g){

        /* Отрисовка режима в соответствии с флагом modeIndex
        0 - меню
        1 - обучение
        11 - дактильная азбука
        111 - алфавит
        12 - жесты
        2 - практика
        3 - основы
         */

        if (ProgramExplorer.modeIndex==0) {
            setImages();
            drawIcons(g);
            drawText(g);
        }

        if (ProgramExplorer.modeIndex==1) {
            learnMode.paint(g);
        }

        if (ProgramExplorer.modeIndex==11) {
            dactyl.paint(g);
        }

        if (ProgramExplorer.modeIndex==111) {
            dactyl.drawAlphabet(g);
        }

        if (ProgramExplorer.modeIndex==12) {
            gestures.paint(g);
        }

        if (ProgramExplorer.modeIndex==2) {
            practiceMode.paint(g);
        }

        if (ProgramExplorer.modeIndex==21) {
            testing.paint(g);
        }

        if (ProgramExplorer.modeIndex==3) {
            description.paint(g);
        }
    }

}
