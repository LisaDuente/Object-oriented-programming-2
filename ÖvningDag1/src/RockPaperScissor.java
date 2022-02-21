import java.util.Random;

public class RockPaperScissor {
    private String[] choices = {"sax","påse","sten"};

    public RockPaperScissor(){
    }

    public String randomizeChoice(){
        Random randomizer = new Random();
        int place = randomizer.nextInt(3);

        return choices[place];
    }
}
