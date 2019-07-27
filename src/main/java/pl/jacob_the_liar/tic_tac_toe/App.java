package pl.jacob_the_liar.tic_tac_toe;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.jacob_the_liar.tic_tac_toe.console.ConsoleGame;
import pl.jacob_the_liar.tic_tac_toe.player_move.HumanPlayerMove;
import pl.jacob_the_liar.tic_tac_toe.player_move.RandomPlayerMove;
import pl.jacob_the_liar.tic_tac_toe.windowed.WindowedGame;


import java.util.Scanner;

public class App extends Application {

    public static void main( String[] args )
    {

        System.out.println( "Kółko i krzyżyk" );
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
        System.out.println();
        System.out.println();
        System.out.println("\t0 - wyjście");
        System.out.println();

        int correctSelect = -1;
        do {
            System.out.print("podaj wybór: ");

            if (scanner.hasNextInt())
                correctSelect = scanner.nextInt();


        } while (!(0<=correctSelect && correctSelect<=5));


        switch ( correctSelect){
    
            case 1:
                new ConsoleGame(new HumanPlayerMove(), new HumanPlayerMove()).start();
                System.exit(1);
                break;
            case 2:
                new ConsoleGame(new HumanPlayerMove(), new RandomPlayerMove()).start();
                System.exit(1);
                break;
            case 4:
                new ConsoleGame(new RandomPlayerMove(), new RandomPlayerMove()).start();
                System.exit(1);
                break;
            case 5:
                Application.launch(args);
                break;
        }
        



        System.out.println("pa!");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        WindowedGame windowedGame = new WindowedGame(primaryStage);
        windowedGame.show();
    }




}
