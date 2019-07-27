package pl.jacob_the_liar.tic_tac_toe;


import javafx.application.Application;
import javafx.stage.Stage;
import pl.jacob_the_liar.tic_tac_toe.console.ConsoleGame;
import pl.jacob_the_liar.tic_tac_toe.player_move.AIPlayerMove;
import pl.jacob_the_liar.tic_tac_toe.player_move.HumanPlayerMove;
import pl.jacob_the_liar.tic_tac_toe.player_move.PlayerMove;
import pl.jacob_the_liar.tic_tac_toe.player_move.RandomPlayerMove;
import pl.jacob_the_liar.tic_tac_toe.windowed.WindowedGame;

import java.util.Scanner;


public class App extends Application{
    
    public static PlayerMove circlePlayer;
    public static PlayerMove crossPlayer;
    
    
    public static void main(String[] args){
        
        System.out.println("Kółko i krzyżyk");
        System.out.println();
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("wybierz tryb gry");
        System.out.println("\t1 - tekstowy człowiek kontra człowiek");
        System.out.println("\t2 - tekstowy człowiek kontra komputer słaby");
        System.out.println("\t3 - tekstowy człowiek kontra komputer lepszy");
        System.out.println();
        System.out.println("\t4 - tekstowy komputer kontra komputer");
        System.out.println();
        System.out.println("\t5 - okienkowy człowiek kontra człowiek");
        System.out.println("\t6 - okienkowy człowiek kontra komputer słaby");
        System.out.println("\t7 - okienkowy człowiek kontra komputer lepszy");
        System.out.println();
        System.out.println("\t8 - okienkowy komputer kontra komputer");
        System.out.println();
        System.out.println();
        System.out.println("\t0 - wyjście");
        System.out.println();
        
        int correctSelect = -1;
        do {
            System.out.print("podaj wybór: ");
            
            if (scanner.hasNextInt()) correctSelect = scanner.nextInt();
        }
        while (!(0 <= correctSelect && correctSelect <= 8));
        
        circlePlayer = new HumanPlayerMove();
        crossPlayer = new HumanPlayerMove();
        
        switch (correctSelect % 4) {
            
            case 0:
                circlePlayer = new RandomPlayerMove();
                crossPlayer = new RandomPlayerMove();
                break;
            case 2:
                crossPlayer = new RandomPlayerMove();
                break;
            case 3:
                crossPlayer = new AIPlayerMove();
                ;
                break;
        }
        
        if (correctSelect <= 4) {
            new ConsoleGame(circlePlayer, crossPlayer).start();
            System.exit(1);
        } else {
            Application.launch(args);
        }
        
        System.out.println("pa!");
    }
    
    
    @Override
    public void start(Stage primaryStage){
        WindowedGame windowedGame = new WindowedGame(primaryStage, circlePlayer, crossPlayer);
        windowedGame.show();
    }
}
