public class Main{
    public static void main(String[] args) {
        Model model = new Model();
        Controller control = new Controller(model);
        View view = new View(control);
        model.addPCL(view);
    }
}
