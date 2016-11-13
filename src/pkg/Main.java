package pkg;

import com.sun.org.apache.xpath.internal.SourceTree;
import pkg.domain.Battlefield;
import pkg.domain.Player;
import pkg.domain.impl.BattlefieldImpl;
import pkg.domain.impl.PlayerImpl;
import pkg.ui.GameUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter battlefield size");
        int size = sc.nextInt();
        Player player1, player2;
        player1 = createPlayer(size);
        player2 = createPlayer(size);
        GameUI gameUI = new GameUI();
        gameUI.play(player1, player2);
    }

    private static Player createPlayer(int size) {
        Battlefield battlefield = new BattlefieldImpl(size);
        Player player = new PlayerImpl(battlefield);
        return player;
    }
}

