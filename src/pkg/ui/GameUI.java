package pkg.ui;

import com.sun.org.apache.xpath.internal.SourceTree;
import pkg.domain.Battlefield;
import pkg.domain.FieldType;
import pkg.domain.Player;
import pkg.domain.ShipType;

import java.util.Scanner;

public class GameUI {
    public void play(Player player1, Player player2) {
        gameSetup(player1, player2);
        boolean player1turn = true;
        while (!gameEnded(player1, player2)) {
            if (player1turn) { // player1 turn
                System.out.println("Player 1 playing...");
                markInEnemyField(player2);
            } else { // player2 turn
                System.out.println("Player 2 playing...");
                markInEnemyField(player1);
            }
            player1turn = !player1turn;
        }
        System.out.println(getWinner(player1));
    }

    private void markInEnemyField(Player player) {
        drawPlayingField(player);
        int coordinates[] = getCoordinates();
        player.getBattlefield().fireOn(coordinates[0], coordinates[1]);
    }

    private void gameSetup(Player player1, Player player2) {
        System.out.println("Player 1, please insert locations of your 3 ships (x,y)");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 1; i++) {
            System.out.println("Ship " + (i + 1));
            ShipType shipType = getShipType(sc);
            boolean direction = getDirection(sc);
            doShit(player1, shipType, direction, sc);
        }
        System.out.println("Player 2, please insert locations of your 3 ships (x,y)");
        for (int i = 0; i < 3; i++) {
            System.out.println("Ship " + (i + 1));
            ShipType shipType = getShipType(sc);
            boolean direction = getDirection(sc);
            doShit(player2, shipType, direction, sc);
        }
    }

    void doShit(Player player, ShipType shipType, boolean direction, Scanner sc) {
        System.out.println("Enter ship coordinates:");
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;
        if (wrongInput(player, shipType, direction, x, y)) {
            System.out.println("You inputed wrong coordinates.");
            doShit(player, shipType, direction, sc);
        } else {
            player.getBattlefield().addShip(x, y, direction, shipType);
        }
    }

    private ShipType getShipType(Scanner sc) {
        System.out.println("Which type of ship do you want to add? 1 - Boat, 2 - Submarine, 3 - Cruiser");
        ShipType shipType;
        int tmp = sc.nextInt();
        if (tmp == 1) {
            shipType = ShipType.BOAT;
        } else if (tmp == 2) {
            shipType = ShipType.SUBMARINE;
        } else {
            shipType = ShipType.CRUISER;
        }
        return shipType;
    }

    private boolean getDirection(Scanner sc) {
        System.out.println("Place ship horizontally or vertically? 1 - Horizontally, 2 - Vertically");
        boolean direction;
        int tmp = sc.nextInt();
        if (tmp == 1) {
            direction = true;
        } else {
            direction = false;
        }
        return direction;
    }

    private boolean wrongInput(Player player, ShipType shipType, boolean direction, int x, int y) {
        FieldType[][] battlefield = player.getBattlefield().getBattlefield();
        if (direction == false) {
            for (int i = 0; i < shipType.getLenght(); i++) {
                if (battlefield[x][y] == FieldType.SHIP) {
                    return true;
                }
                x++;
            }
        } else {
            for (int i = 0; i < shipType.getLenght(); i++) {
                if (battlefield[x][y] == FieldType.SHIP) {
                    return true;
                }
                y++;
            }
        }
        return false;
    }

    private boolean gameEnded(Player player1, Player player2) {
        return playerLost(player1) || playerLost(player2);
    }

    private boolean playerLost(Player player) {
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

    private void drawPlayingField(Player player) {
        FieldType[][] battlefield = player.getBattlefield().getBattlefield();
        for (int i = 0; i < battlefield.length; i++) {
            for (int j = 0; j < battlefield[0].length; j++) {
                if (battlefield[i][j] == FieldType.NOTHING) {
                    System.out.print("* ");
                } else if (battlefield[i][j] == FieldType.HIT) {
                    System.out.print("X ");
                } else if (battlefield[i][j] == FieldType.SHIP) {
                    System.out.print("S ");
                } else if (battlefield[i][j] == FieldType.MISS) {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }

    private int[] getCoordinates() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter where you want to shoot (x,y)");
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;
        return new int[]{x, y};
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
