public class Program {

    static int clicks = 1;
    public static void main(String[] args) {
        GUI.Window window = new GUI.Window();
        window.edit(opts -> opts.title("Calculator"));
        Calculator calculator = new Calculator(window);
        // window.view();
    }

}