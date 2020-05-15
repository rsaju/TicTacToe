package com.example.demo;

import java.util.ArrayList;

public class PrintBoard {
    public ArrayList<Integer> player1Pos = new ArrayList<Integer>();
    public ArrayList<Integer> player2Pos = new ArrayList<Integer>();

    public void createBoard(char[][] board){
        for (char[] rows : board) {
            for (char row : rows) {
                System.out.print(row);
            }
            System.out.println();
        }
    }

    public void placeSymbol(char[][] board, int pos, String user) {

        char symbol = ' ';
        if(user.equals("player1")){
            symbol = 'X';
            player1Pos.add(pos);
        } else if(user.equals("player2")){
            symbol = 'O';
            player2Pos.add(pos);
        }
        switch (pos) {
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][2] = symbol;
                break;
            case 3:
                board[0][4] = symbol;
                break;
            case 4:
                board[2][0] = symbol;
                break;
            case 5:
                board[2][2] = symbol;
                break;
            case 6:
                board[2][4] = symbol;
                break;
            case 7:
                board[4][0] = symbol;
                break;
            case 8:
                board[4][2] = symbol;
                break;
            case 9:
                board[4][4] = symbol;
                break;
        }
    }
}
