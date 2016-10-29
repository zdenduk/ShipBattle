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
                int coordinates[] = getCoordinates();
                player2.getBattlefield().fireOn(coordinates[0], coordinates[1]);
            } else { // player2 turn
                System.out.println("Player 2 playing...");
                int coordinates[] = getCoordinates();
                player1.getBattlefield().fireOn(coordinates[0], coordinates[1]);
            }
            counter++;
            System.out.println(counter);
        }
    }

    private boolean gameEnded(Player player1, Player player2) {
        FieldType[][] battlefield1 = player1.getBattlefield().getBattlefield();
        FieldType[][] battlefield2 = player2.getBattlefield().getBattlefield();
        for (int i = 0; i < battlefield1.length; i++) {
            for (int j = 0; j < battlefield1[0].length; j++) {
                if (battlefield1[i][j] == FieldType.SHIP) {
                    return false;
                }
            }
        }
        for (int i = 0; i < battlefield2.length; i++) {
            for (int j = 0; j < battlefield2[0].length; j++) {
                if (battlefield2[i][j] == FieldType.SHIP) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[] getCoordinates() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter where you want to shoot (x,y)");
        int x = sc.nextInt();
        int y = sc.nextInt();
        return new int[]{x, y};
    }

    private void gameSetup(Player player1, Player player2) {
        System.out.println("Player 1, please insert locations of your 3 ships (x,y)");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 1; i++) {
            System.out.println("Ship " + (i + 1));
            int x = sc.nextInt();
            int y = sc.nextInt();
            player1.getBattlefield().addShip(x, y);
        }
        System.out.println("Player 2, please insert locations of your 3 ships (x,y)");
        for (int i = 0; i < 1; i++) {
            System.out.println("Ship " + (i + 1));
            int x = sc.nextInt();
            int y = sc.nextInt();
            player2.getBattlefield().addShip(x, y);
        }
    }
}

