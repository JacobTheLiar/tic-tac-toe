package pl.jacob_the_liar.tic_tac_toe.console;


import java.util.Scanner;


public class Input {

    public static int getInt(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print(">");
            if(scanner.hasNextInt()){
                int value = scanner.nextInt();
                return value;
            } else {
                System.out.println("invalid characters, try again");
            }
            scanner.nextLine();
        }
    }
}
