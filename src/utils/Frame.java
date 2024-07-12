package utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Frame extends JFrame {

    private customfeatures features;
    private JProgressBar progressBar = new JProgressBar(0,100);
    private JLabel progressLabel =  new JLabel("Percentage of Completion : ");

    public Frame() {
        this.features = new customfeatures();
        Init(); // to avoid the pit fall
    }

    private void Init() {
        setTitle(features.getTitle());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(features.getWidth(), features.getHeight());

        progressBar.setStringPainted(true);
        progressBar.setValue(0);
        progressBar.setBorder(new EmptyBorder(60,0,0,80));

        JPanel progressPanel = new JPanel(new FlowLayout());
        progressPanel.add(progressLabel);
        progressPanel.add(progressBar);

        add(progressPanel, BorderLayout.NORTH);
        
        setVisible(true); 
    }

    public void SetProgress(int value) {
        if (value>94) value = 100;
        progressBar.setValue(value);
        updateProgressBarColor(value);
    }

    private void updateProgressBarColor(int value) {
        if (value <= 50) {
            progressBar.setForeground(Color.YELLOW);
        } else if (value <= 80) {
            progressBar.setForeground(Color.ORANGE);
        } else {
            progressBar.setForeground(Color.GREEN);
        }
    }
}
