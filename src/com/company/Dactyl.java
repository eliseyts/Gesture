package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

    public class Dactyl extends JComponent {
        private BufferedImage forwardButton = null;
        private BufferedImage backwardButton = null;
        private BufferedImage backButton = null;
        private BufferedImage alphabetButton = null;
        private BufferedImage alphabet = null;
        private BufferedImage dactylGestures = null;
        private char[] lettersArray = {'А','Б','В','Г','Д','Е','Ж','З','И','Й','К','Л','М','Н','О','П','Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ъ','Ы','Ь','Э','Ю','Я'};
        private Color newColor = new Color(255, 255, 255);
        private String[] descriptionOfGestures = {
                "Пальцы руки согнуты, большой палец прижат к верхней части кисти",
                "Кисть руки поднята, указательный палец также поднят,",
                "Кисть руки поднята, пальцы рук постепенно раскрываются",
                "Кисть руки опущена, указательный и большой палец выпрямлены,",
                "Кисть руки поднята, указательный и средний пальцы подняты и соприкасаются,",
                "Пальцы собраны вместе",
                "Кисть руки поднята, пальцы выпрямляются кончиками от себя",
                "Кисть руки поднята, указательный палец выпрямлен",
                "Кисть руки поднята, безымянный палец и мизинец выпрямлены",
                "Кисть руки поднята, безымянный палец и мизинец выпрямлены,",
                "Кисть руки поднята, прямые пальцы раскрыты",
                "Кисть руки опущена, пальцы прямые",
                "Кисть руки опущена, пальцы прямые",
                "Кисть руки поднята, безымянный и большой пальцы соединяются,",
                "Кисть руки поднята, указательный и большой пальцы соединяются,",
                "Кисть руки опущена, пальцы прямые",
                "Кисть руки поднята, средний и большой пальцы соединяются,",
                "Кисть руки поднята, пальцы согнуты и образуют букву 'С'",
                "Кисть руки опущена, пальцы прямые",
                "Кисть руки поднята, большой палец и мизинец выпрямлены,",
                "Кисть руки поднята, пальцы выпрямляются кончиками от себя",
                "Кисть руки поднята, указательный палец наполовину согнут,",
                "Кисть руки поднята, указательный и средний пальцы выпрямляются,",
                "Кисть руки поднята, пальцы выпрямляются кончиками от себя",
                "Кисть руки поднята, мизинец и большой пальцы соединяются,",
                "Кисть руки поднята, мизинец и большой пальцы соединяются,",
                "Кисть руки поднята, большой и указательный пальцы выпрямляются",
                "Кисть руки поднята, указательный палец и мизинец выпрямляются",
                "Кисть руки поднята, большой и указательный пальцы выпрямляются",
                "Кисть руки поднята, большой и указательный пальцы согнуты",
                "Кисть руки поднята, пальцы выпрямляются кончиками от себя, мизинец поднят",
                "Кисть руки поднята, прямые пальцы соприкасаются"



        };
        private String[] descriptionOfGestures2 = {
                " ",
                "остальные пальцы  сгибаются и соприкасаются",
                " ",
                "остальные пальцы прижимаются к ладони",
                "рукой описываются круговые движения в воздухе",
                " ",
                " ",
                "рукой в воздухе описывается форма буквы 'З'",
                " ",
                "движения руки производятся от себя",
                " ",
                " ",
                " ",
                "остальные выпрямлены",
                "остальные выпрямлены",
                " ",
                "остальные выпрямлены",
                " ",
                " ",
                "остальные согнуты",
                " ",
                "остальные прижимаются к ладони",
                "рука опускается вниз",
                " ",
                "остальные выпрямлены",
                "остальные выпрямлены, рука опускается вниз",
                " ",
                " ",
                " ",
                " ",
                " ",
                " "
        };
        Font letterFont = new Font("Arial Black", 0, 150);
        Font textFont = new Font("Arial Black", 0, 14);


    Dactyl(){

    }

    //Подключение изображений
    public void setImages(){
        try
        {
            forwardButton = ImageIO.read(new File("images/forward.png"));
            backwardButton = ImageIO.read(new File("images/backward.png"));
            backButton = ImageIO.read(new File("images/BackButton.png"));
            alphabetButton = ImageIO.read(new File("images/aya.png"));
            alphabet = ImageIO.read(new File("images/alphabet.png"));
        } catch (IOException e){e.printStackTrace();}
    }

    public void drawText(Graphics g){
        g.setFont(letterFont);
        g.setColor(newColor);
        g.drawString(""+lettersArray[ProgramExplorer.dactGestureIndex], 550, 200);
        g.setFont(textFont);

        g.drawString(""+descriptionOfGestures[ProgramExplorer.dactGestureIndex], 435, 275);
        g.drawString(""+descriptionOfGestures2[ProgramExplorer.dactGestureIndex], 435, 300);
        g.drawString("Большинство букв изображаются только конфигурацией пальцев (без движения руки):", 435, 350);
        g.drawString("А, Б, В, Г, Е, Ж, И, К, Л, М, Н, О, П, Р, С, Т, У, Ф, X, Ч, Ш, Ы, Э, Ю, Я.", 435, 375);
        g.drawString("Другие буквы — сочетанием конфигурации и движением руки: Д, Е, 3, Й, Ц, Щ, Ъ, Б.", 435, 400);
    }

    //Подключение изображения жеста
    public void setDactyl(){
        try
        {
            dactylGestures= ImageIO.read(new File("images/gestures/"+ProgramExplorer.dactGestureIndex+".png"));
        } catch (IOException e){e.printStackTrace();}
    }

    //Отрисовка изображений
    public void drawImages(Graphics g){
        g.drawImage(dactylGestures, 125, 115,300,400,null);
        g.drawImage(alphabetButton,1000, 100,100,100,null);
        g.drawImage(backButton,500, 700,200,50,null);
        g.drawImage(forwardButton,650, 500,100,100,null);
        g.drawImage(backwardButton,450, 500,100,100,null);
    }

    //Отрисовка алфавита
    public void drawAlphabet(Graphics g){
        g.drawImage(alphabet,10, 10,1200,640,null);
        g.drawImage(backButton,500, 700,200,50,null);
    }

    public void paint(Graphics g){
        setImages();
        setDactyl();
        drawText(g);
        drawImages(g);
    }
}
