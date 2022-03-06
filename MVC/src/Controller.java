public class Controller {
    Model model;

    public Controller(Model model){
        this.model = model;
    }

    public void increase(){
        if (model.getCurrentNumber()>= 10){
            model.setCurrentMessage("invalid action");
        }else{
            model.setCurrentNumber(model.getCurrentNumber()+1);
            model.setCurrentMessage("increased");
        }
    }

    public void decrease(){
        if (model.getCurrentNumber()<= 0){
            model.setCurrentMessage("Invalid action");
        }else{
            model.setCurrentNumber(model.getCurrentNumber()-1);
            model.setCurrentMessage("decreased");
        }
    }
}
