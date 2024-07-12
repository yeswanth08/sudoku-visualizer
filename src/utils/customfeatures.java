package utils;

import java.awt.Color;

public class customfeatures{

    private String Title;
    private Color Background;
    private int width;
    private int height;

    public customfeatures(){
        this.Title = "Sudoku-Visualizer";
        this.Background = Color.gray;
        this.height = 750;
        this.width = 850;
    }

    public String getTitle(){
        return Title;
    }

    public Color getBackground(){
        return Background;
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }
    
}