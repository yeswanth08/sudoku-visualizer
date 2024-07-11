package utils;
import javax.swing.JFrame;

public class Frame extends JFrame{
    
    // frame initialization
    private customfeatures features;

    public Frame(){
        frameInit();
        this.features = new customfeatures();
    }

    @Override
    protected void frameInit() {
        // setTitle(features.Title);
        System.out.println(features.Title);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}