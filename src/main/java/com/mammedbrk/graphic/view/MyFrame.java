package com.mammedbrk.graphic.view;

import com.mammedbrk.config.Config;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        int screenWidth, screenHeight, windowWidth, windowHeight;
        screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        windowWidth = Integer.parseInt(Config.getInstance().getProperty("windowWidth"));
        windowHeight = Integer.parseInt(Config.getInstance().getProperty("windowHeight"));
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(windowWidth, windowHeight));
        this.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);
//        this.setVisible(true);
    }
}
