public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Control control = new Control(model);
        View view = new View(control);
        model.addPCL(view);
    }
}
