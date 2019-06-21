package pl.jacob_the_liar.tic_tac_toe;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.jacob_the_liar.tic_tac_toe.console.ConsoleGame;
import pl.jacob_the_liar.tic_tac_toe.windowed.WindowedGame;

import java.net.URL;
import java.util.Scanner;

public class App extends Application {

    public static void main( String[] args )
    {

        System.out.println( "Kółko i krzyżyk" );
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        System.out.println("wybierz tryb gry");
        System.out.println("\t1 - tekstowy");
        System.out.println("\t2 - okienkowy");
        System.out.println();
        System.out.println("\t0 - wyjście");
        System.out.println();

        int correctSelect = -1;
        do {
            System.out.print("podaj wybór: ");

            if (scanner.hasNextInt())
                correctSelect = scanner.nextInt();


        } while (!(0<=correctSelect && correctSelect<=2));


        if (correctSelect==1)
            new ConsoleGame().start();
        else if (correctSelect==2)
            Application.launch(args);



        System.out.println("pa!");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        WindowedGame windowedGame = new WindowedGame(primaryStage);
        windowedGame.show();
    }




}
