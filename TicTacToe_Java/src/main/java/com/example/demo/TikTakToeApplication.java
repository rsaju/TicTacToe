package com.example.demo;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class TikTakToeApplication {

    static ArrayList<Integer> player1Pos = new ArrayList<Integer>();
    static ArrayList<Integer> player2Pos = new ArrayList<Integer>();
    public static void main(String[] args) {
//		SpringApplication.run(TikTakToeApplication.class, args);
        char[][] board = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
        };
        Winner winner = new Winner();
        PrintBoard printBoard = new PrintBoard();
        Scanner input = new Scanner(System.in);
        printBoard.createBoard(board);
        while (true) {
            System.out.print("Enter the position from 1-9 player1: ");
            int player1 = input.nextInt();
            while (player1Pos.contains(player1) || player2Pos.contains(player1)){
                System.out.println("position Taken Enter another one");
                player1 = input.nextInt();
            }
            placeSymbol(board, player1, "player1");
            printBoard.createBoard(board);
            String result = winner.winner(player1Pos, player2Pos);
            if(result.length() > 0){
                System.out.println(result);
                break;
            }
            System.out.print("Enter position from 1-9 player2 : ");
            int player2 = input.nextInt();
            while (player1Pos.contains(player2) || player2Pos.contains(player2)){
                System.out.println("position Taken Enter another one");
                player2 = input.nextInt();
            }
            placeSymbol(board, player2, "player2");
            printBoard.createBoard(board);
            result = winner.winner(player1Pos, player2Pos);
            if(result.length() > 0) {
                System.out.println(result);
                break;
            }
        }
    }

    public static void placeSymbol(char[][] board, int pos, String user) {

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
            default: System.out.println("You have entered a wrong position");
            break;
        }
    }

}