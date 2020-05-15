package com.example.demo;

import java.util.ArrayList;

public class PrintBoard {

    public void createBoard(char[][] board){
        for (char[] rows : board) {
            for (char row : rows) {
                System.out.print(row);
            }
            System.out.println();
        }
    }
}
