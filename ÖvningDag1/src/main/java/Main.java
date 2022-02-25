import javafx.application.Application;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main {
    public static void main (String[] args) {
        launch(args);
        View view = new View("hello");
        Controller control = new Controller();
        control.gameLoop();

    }

}
