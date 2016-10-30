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
        Player player1, player2;
        /*player1 = player2 = createPlayer();*/
        player1 = createPlayer();
        player2 = createPlayer();
        GameUI gameUI = new GameUI();
        gameUI.play(player1, player2);
    }

    private static Player createPlayer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter battlefield size");
        int size = sc.nextInt();
        Battlefield battlefield = new BattlefieldImpl(size);
        Player player = new PlayerImpl(battlefield);
        return player;
    }
}

