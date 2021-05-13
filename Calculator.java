import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import GUI.Button;
import GUI.Window;

public class Calculator {

    private static final String SEQUENCE_MARKER = "|";

    private Window window;
    private ArrayList<String> history = new ArrayList<>() {{ add(SEQUENCE_MARKER); }};

    public Calculator(Window window) {
        this.window = window;

        JPanel main = new JPanel();
        BoxLayout mainLayout = new BoxLayout(main, BoxLayout.X_AXIS);
        main.setLayout(mainLayout);       

        GridLayout layout = new GridLayout(3, 4);
        JPanel numbers = new JPanel(layout);
        main.add(numbers);
        
        numbers.setSize(400, 300);

        initButtons(numbers);
        window.add(main);
    }

    private void initButtons(JPanel attach) {
        int label = 1;

        ArrayList<String> operators = new ArrayList<>() {{
            add("+");
            add("-");
            add("=");
        }};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                GUI.Button button = new GUI.Button("" + label);
                window.addButton(attach, button, "number_" + label);

                button.onClick(this::buttonClick);

                label++;
            }
            GUI.Button equal = new GUI.Button(operators.get(i));
            window.addButton(attach, equal, "equal");
        }

    }

    private void buttonClick(Button button) {
        System.out.println(button.getText());
    }
    
}
