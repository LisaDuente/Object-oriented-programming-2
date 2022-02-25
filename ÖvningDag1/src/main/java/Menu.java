import java.util.Scanner;

public class Menu {

    public Menu(){
    }

    public void printMenu(){
        System.out.println("""
                        ## Welcome to Rock Paper Scissors! ##
                        _____________________________________
                        Please choose one option:
                        
                        > Press 1 to load a user!
                        > Press 2 to play the game!
                        > Press 3 to  end the game!"""
                );
    }

}
