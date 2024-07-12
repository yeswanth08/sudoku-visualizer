package utils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SudokuGrid extends JPanel {

    private static final int GRID_SIZE = 9;
    private static final int GRID_DIMENSION = 60;
    private JTextField[][] cells = new JTextField[GRID_SIZE][GRID_SIZE];

    public SudokuGrid() {

        setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
        setPreferredSize(new Dimension(GRID_DIMENSION * GRID_SIZE, GRID_DIMENSION * GRID_SIZE));
        setBorder(new EmptyBorder(80, 20, 20, 20));

        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                JTextField textField = new JTextField();
                textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                
                if (row % 3 == 0 && col % 3 == 0) {
                    textField.setBorder(BorderFactory.createMatteBorder(2, 2, 1, 1, Color.BLACK)); 
                } else if (row % 3 == 0 && col % 3 == 2) {
                    textField.setBorder(BorderFactory.createMatteBorder(2, 1, 1, 2, Color.BLACK)); 
                } else if (row % 3 == 2 && col % 3 == 0) {
                    textField.setBorder(BorderFactory.createMatteBorder(1, 2, 2, 1, Color.BLACK)); 
                } else if (row % 3 == 2 && col % 3 == 2) {
                    textField.setBorder(BorderFactory.createMatteBorder(1, 1, 2, 2, Color.BLACK)); 
                } else if (row % 3 == 0) {
                    textField.setBorder(BorderFactory.createMatteBorder(2, 1, 1, 1, Color.BLACK)); 
                } else if (row % 3 == 2) {
                    textField.setBorder(BorderFactory.createMatteBorder(1, 1, 2, 1, Color.BLACK)); 
                } else if (col % 3 == 0) {
                    textField.setBorder(BorderFactory.createMatteBorder(1, 2, 1, 1, Color.BLACK)); 
                } else if (col % 3 == 2) {
                    textField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 2, Color.BLACK)); 
                } else {
                    textField.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
                }

                textField.setHorizontalAlignment(SwingConstants.CENTER);
                textField.setFont(new Font("Arial", Font.BOLD, 20));
                cells[row][col] = textField;
                add(textField);
            }
        }
        
    }

    public JTextField[][] getCells() {
        return cells;
    }
    
}
