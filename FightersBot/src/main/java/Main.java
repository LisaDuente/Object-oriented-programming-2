import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.message.MessageFlag;
import org.javacord.api.interaction.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String token = "OTUzMzM0Mzg4MDg5ODM1NTIw.YjDD1g.ISQ7qI8_KeKq3HkZ9J75W8PJipo";
        DiscordApi api = new DiscordApiBuilder().setToken(token)
                .login().join();
        System.out.println(api.createBotInvite());

        //add the command first and then add an eventListener to the command
        //there you define what it should do
        //SlashCommand.with("hello","Greets you Back").createGlobal(api).join();

        api.addSlashCommandCreateListener(event ->{
            SlashCommandInteraction interact = event.getSlashCommandInteraction();
            if(interact.getCommandName().equals("hello")){
                interact.createImmediateResponder()
                        .setContent("Hello handsome stranger!")
                        .respond();
            }
        });

    }

}
