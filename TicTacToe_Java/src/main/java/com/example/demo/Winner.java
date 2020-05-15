package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Winner {

    public String winner(List<Integer> player1Pos, List<Integer> player2Pos){

        List<List> winningCondition = new ArrayList<>();
        winningCondition.add(Arrays.asList(1, 2, 3));
        winningCondition.add(Arrays.asList(4, 5, 6));
        winningCondition.add(Arrays.asList(7, 8, 9));
        winningCondition.add(Arrays.asList(1, 4, 7));
        winningCondition.add(Arrays.asList(2, 5, 8));
        winningCondition.add(Arrays.asList(3, 6, 9));
        winningCondition.add(Arrays.asList(1, 5, 9));
        winningCondition.add(Arrays.asList(3, 5, 7));

        for (List list : winningCondition) {
            if(player1Pos.containsAll(list)){
                return "Player1 Won";
            }else if(player2Pos.containsAll(list)){
                return "player2 Won";
            }else if(player1Pos.size() + player2Pos.size() == 9){
                return "Draw";
            }
        }
        return "";

    }
}
