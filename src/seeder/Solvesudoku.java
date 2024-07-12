package seeder;

import utils.SudokuGrid;
import utils.Frame;

import javax.swing.*;
import java.awt.*;

public class Solvesudoku {

    private char[][] board;
    private SudokuGrid sudokuGrid;
    private Frame frame;

    public Solvesudoku(SudokuGrid sudokuGrid, Frame frame) {
        this.sudokuGrid = sudokuGrid;
        this.frame = frame;
    }

    public void solve(char[][] board) {
        this.board = board;

        SwingWorker<Boolean, Void> worker = new SwingWorker<>() {
            @Override
            protected Boolean doInBackground() {
                return solveHelper(board, 0, 0);
            }

            @Override
            protected void done() {
                try {
                    boolean result = get();
                    System.out.println("Solve completed. Result: " + result);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        worker.execute();
    }

    private boolean solveHelper(char[][] board, int row, int col) {
        if (row == 9) {
            return true;
        }

        if (col == 9) {
            return solveHelper(board, row + 1, 0);
        }

        if (board[row][col] != '0') {
            return solveHelper(board, row, col + 1);
        }

        for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, row, col, c)) {
                board[row][col] = c;

                updateUI(row, col, c, Color.GREEN);
                delay(1);

                if (solveHelper(board, row, col + 1)) {
                    return true;
                }

                board[row][col] = '0';

                updateUI(row, col, '0', Color.RED);
                delay(1);
            }
        }

        return false;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c || board[i][col] == c ||
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }

    private void updateUI(int row, int col, char value, Color color) {
        SwingUtilities.invokeLater(() -> {
            JTextField cell = sudokuGrid.getCells()[row][col];
            cell.setText(value == '0' ? "" : String.valueOf(value));
            cell.setBackground(color);

            // Update progress bar
            int progress = (row * 9 + col) * 100 / 81;
            frame.SetProgress(progress);
        });
    }

    private void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
