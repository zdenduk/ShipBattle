package pkg.ui;

import pkg.domain.Battlefield;
import pkg.domain.FieldType;
import pkg.domain.Player;

import java.util.Scanner;

public class GameUI {
    public void play(Player player1, Player player2) {
        gameSetup(player1, player2);
        int counter = 0;
        while (!gameEnded(player1, player2)) {
            if (counter % 2 == 0) { // player1 turn
                System.out.println("Player 1 playing...");
                drawPlayingField(player2);
                int coordinates[] = getCoordinates();
                player2.getBattlefield().fireOn(coordinates[0], coordinates[1]);
            } else { // player2 turn
                System.out.println("Player 2 playing...");
                drawPlayingField(player1);
                int coordinates[] = getCoordinates();
                player1.getBattlefield().fireOn(coordinates[0], coordinates[1]);
            }
            counter++;
        }
        System.out.println(getWinner(player1));
    }

    private boolean gameEnded(Player player1, Player player2) {
        if(playerLost(player1)){
            return true;
        }
        else if(playerLost(player2)){
            return true;
        }
        return false;
    }

    private boolean playerLost(Player player){
        FieldType[][] battlefield = player.getBattlefield().getBattlefield();
        for (int i = 0; i < battlefield.length; i++) {
            for (int j = 0; j < battlefield[0].length; j++) {
                if (battlefield[i][j] == FieldType.SHIP) {
                    return false;
                }
            }
        }
        return true;
    }

    private void gameSetup(Player player1, Player player2) {
        System.out.println("Player 1, please insert locations of your 3 ships (x,y)");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 1; i++) {
            System.out.println("Ship " + (i + 1));
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            player1.getBattlefield().addShip(x, y);
        }
        System.out.println("Player 2, please insert locations of your 3 ships (x,y)");
        for (int i = 0; i < 1; i++) {
            System.out.println("Ship " + (i + 1));
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            player2.getBattlefield().addShip(x, y);
        }
    }


    private int[] getCoordinates() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter where you want to shoot (x,y)");
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;
        return new int[]{x, y};
    }

    private void drawPlayingField(Player player) {
        FieldType[][] battlefield = player.getBattlefield().getBattlefield();
        for (int i = 0; i < battlefield.length; i++) {
            for (int j = 0; j < battlefield[0].length; j++) {
                if (battlefield[i][j] == FieldType.NOTHING) {
                    System.out.print("* ");
                } else if (battlefield[i][j] == FieldType.HIT) {
                    System.out.print("X ");
                } else if (battlefield[i][j] == FieldType.SHIP) {
                    System.out.print("* ");
                } else if (battlefield[i][j] == FieldType.MISS) {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }

    private String getWinner(Player player1) {
        FieldType[][] battlefield1 = player1.getBattlefield().getBattlefield();
        for (int i = 0; i < battlefield1.length; i++) {
            for (int j = 0; j < battlefield1[0].length; j++) {
                if (battlefield1[i][j] == FieldType.SHIP) {
                    return "Player 1 won";
                }
            }
        }
        return "Player 2 won";
    }
}
