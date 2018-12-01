package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProgramExplorer extends JFrame {

    static int modeIndex = 0;
    static int dactIndex = 0;
    static int gestureIndex = 1;
    public MenuMode menuMode = new MenuMode();
    public LearnMode learnMode = new LearnMode();
    public PracticeMode practiceMode = new PracticeMode();
    public JPanel mainPanel;
    private static Color backgroundColor = new Color(72, 89, 186);

    public ProgramExplorer() {
        super("Gesture");
        setBounds(200, 50, 1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        BorderLayout layout=new BorderLayout();
        mainPanel = new JPanel();
        mainPanel.setLayout(layout);
        mainPanel.setBackground(backgroundColor);
        mainPanel.add(menuMode, BorderLayout.CENTER);

        this.addMouseListener(new MouseHandler());

        setContentPane(mainPanel);
        setVisible(true);
    }


    public class MouseHandler implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            //Коррекция координат
            int X = e.getX() - 3;
            int Y = e.getY() - 30;

            //Обработка нажатий мыши по кнопкам в меню
            if ((modeIndex==0)&&((X>150&&Y>300)&&(X<400&&Y<550))){
                modeIndex=1;
                System.out.println("click "+modeIndex);
            }

            //Обработка нажатий мыши по кнопкам в меню
            if ((modeIndex==0)&&((X>475&&Y>300)&&(X<725&&Y<550))){
                modeIndex=2;
                System.out.println("click "+modeIndex);
            }

            //Обработка нажатий мыши по кнопкам в меню
            if ((modeIndex==0)&&((X>800&&Y>300)&&(X<1100&&Y<550))){
                modeIndex=3;
                System.out.println("click "+modeIndex);
            }



            //Обработка нажатий мыши по кнопке НАЗАД
            if ((modeIndex!=0)&&((X>500&&Y>700)&&(X<700&&Y<750))){
                if((modeIndex==1)||(modeIndex==2)||(modeIndex==3)) modeIndex=0;
                if((modeIndex==11)||(modeIndex==12)) modeIndex=1;
                if(modeIndex==111) modeIndex=11;
                System.out.println("click "+modeIndex);
            }

            //Обработка нажатий мыши по кнопкам в меню обучения
            if ((modeIndex==1)&&((X>350&&Y>300)&&(X<850&&Y<350))){
                modeIndex=11;
                System.out.println("click "+modeIndex);
            }

            //Обработка нажатий мыши по кнопкам в меню обучения
            if ((modeIndex==11)&&((X>1000&&Y>100)&&(X<1100&&Y<200))){
                modeIndex=111;
                System.out.println("click "+modeIndex);
            }

            //Обработка нажатий мыши по кнопкам вперед/назад в меню обучения Дактилю
            if (modeIndex==11){
                if((X>650&Y>500)&&(X<750&&Y<600)) {
                    if (dactIndex <31) {
                        dactIndex++;
                    } else dactIndex =0;
                    System.out.println("click " + dactIndex);
                }
                if((X>450&Y>500)&&(X<550&&Y<600)) {
                    if (dactIndex >0) {
                        dactIndex--;
                    } else dactIndex =31;
                    System.out.println("click " + dactIndex);
                }


            }

            //Обработка нажатий мыши по кнопкам в меню обучения
            if ((modeIndex==1)&&((X>350&&Y>450)&&(X<850&&Y<500))){
                modeIndex=12;
                System.out.println("click "+modeIndex);
            }

            //Обработка нажатий мыши по кнопкам вперед/назад в меню обучения Жестам
            if (modeIndex==12){
                System.out.println("1click " + gestureIndex);
                if((X>650&Y>500)&&(X<750&&Y<600)) {
                    if (gestureIndex <208) {
                        gestureIndex++;
                    } else gestureIndex =1;
                    System.out.println("click " + gestureIndex);
                }
                if((X>450&Y>500)&&(X<550&&Y<600)) {
                    if (gestureIndex >1) {
                        gestureIndex--;
                    } else gestureIndex =208;
                    System.out.println("click " + gestureIndex);
                }


            }

            repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}
