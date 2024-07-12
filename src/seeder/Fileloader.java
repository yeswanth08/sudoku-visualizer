package seeder;

import utils.SudokuGrid;
import javax.swing.JTextField;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Fileloader {
    private int GRID_SIZE = 9;
    private SudokuGrid sudoku;
    private char[][] board = new char[9][9];

    public Fileloader(SudokuGrid sudoku) {
        this.sudoku = sudoku;
    }

    public Fileloader() {
        System.out.println("File loader called 🚀");
    }

    public void loadFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            JTextField[][] cells = sudoku.getCells();
            String line;
            int row = 0;
            while ((line = br.readLine()) != null && row < GRID_SIZE) {
                String[] values = line.split(" ");
                for (int col = 0; col < values.length && col < GRID_SIZE; col++) {
                    String value = values[col];
                    cells[row][col].setText(values[col].equals(".") ? "" : values[col]);
                    board[row][col] = value.equals(".") ? '0' : value.charAt(0);
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public char[][] getBoard() {
        return board;
    }
}
