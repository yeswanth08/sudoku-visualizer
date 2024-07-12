import utils.Frame;
import utils.SudokuGrid;
import seeder.Fileloader;
import seeder.Solvesudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuApp {

    public static char[][] board = new char[9][9];
    public static Solvesudoku solver;

    public static void main(String[] args) {

        Frame frame = new Frame();
        SudokuGrid sudokuGrid = new SudokuGrid();
        Fileloader seeder = new Fileloader(sudokuGrid);

        // Upload button
        JButton uploadButton = new JButton("Upload Seeder File") {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension size = getSize();
                g.setColor(new Color(144, 238, 144));
                g.fillRoundRect(0, 0, size.width, size.height, 30, 30);
                super.paintComponent(g);
            }
        };
        
        uploadButton.setOpaque(false);
        uploadButton.setContentAreaFilled(false);
        uploadButton.setBorderPainted(false);
        uploadButton.setFocusPainted(false);
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                    seeder.loadFromFile(filePath);
                    board = seeder.getBoard();
                    solver = new Solvesudoku(sudokuGrid,frame);
                }
            }
        });

        // Visualize and Solve button
        JButton visualizeSolveButton = new JButton("Visualize and Solve") {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension size = getSize();
                g.setColor(new Color(135, 206, 250));
                g.fillRoundRect(0, 0, size.width, size.height, 30, 30);
                super.paintComponent(g);
            }
        };

        visualizeSolveButton.setOpaque(false);
        visualizeSolveButton.setContentAreaFilled(false);
        visualizeSolveButton.setBorderPainted(false);
        visualizeSolveButton.setFocusPainted(false);
        visualizeSolveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solver.solve(board);
            }
        });

        // Layout setup
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        buttonPanel.add(uploadButton);
        buttonPanel.add(visualizeSolveButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(sudokuGrid, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
