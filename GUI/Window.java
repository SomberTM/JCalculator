package GUI;

import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Util.IntVector;

public class Window extends JFrame {

    public static final Options DEFAULT_OPTIONS = new Options()
                                                    .size(800, 600)
                                                    .visible(true)
                                                    .title("Hello World!")
                                                    .maximized(false)
                                                    .centered(true)
                                                    .resizable(true)
                                                    .closeOperation(EXIT_ON_CLOSE)
                                                    .build();
    public static class Options {
        private boolean built = false;
        private IntVector size = new IntVector(0, 0);
        private String title;
        private int closeOperation;
        private boolean resizable,
                        visible,
                        maximized,
                        centered;
        
        public Options width(int x) { if (!built) this.size.x = x; return this; }
        public Options height(int y) { if (!built) this.size.y = y; return this; }
        public Options size(int x, int y) { if (!built) { width(x); height(y); } return this; }
        public Options size(IntVector size) {  if (!built) this.size.replace(size); return this; }
        public Options resizable(boolean resizable) {  if (!built) this.resizable = resizable; return this; }
        public Options visible(boolean visible) {  if (!built) this.visible = visible; return this; }
        public Options maximized(boolean maximized) {  if (!built) this.maximized = maximized; return this; }
        public Options centered(boolean centered) { if (!built) this.centered = centered; return this; }
        public Options title(String title) {  if (!built) this.title = title; return this; }
        public Options closeOperation(int close) { this.closeOperation = close; return this; }
        public Options build() { this.built = true; return this; }
        private Options open() { this.built = false; return this; }
    }
    
    private Options options = DEFAULT_OPTIONS;
    private Map<String, Button> buttons = new HashMap<>();

    public Window() {
        super();
    }

    public Window(String title) {
        super(title);
    }

    public Window(Options options) {
        this();
        this.options = options;
    }

    @FunctionalInterface
    public static interface EditOptions {
        Options edit(Options current);
    }

    public void edit(EditOptions editor) {
        this.options.open();
        this.options = editor.edit(this.options);
        this.options.build();
        this.view();
    }

    public void view() {
        if (this.options.maximized)
            this.setExtendedState(MAXIMIZED_BOTH);
        else
            this.setSize(this.options.size.x, this.options.size.y);

        if (this.options.centered)
            this.center();

        this.setTitle(this.options.title);
        this.setDefaultCloseOperation(this.options.closeOperation);
        this.setResizable(this.options.resizable);
        this.setVisible(this.options.visible);
    }

    public void center() {
        IntVector screen = IntVector.fromDimension(Toolkit.getDefaultToolkit().getScreenSize()).divide(2);
        IntVector win = this.options.size.divout(2);
        this.setLocation(screen.x - win.x, screen.y - win.y);
    }

    public Button addButton(Button button, String label) {
        this.add(button);
        this.buttons.put(label, button);
        return button;
    }

    public Button addButton(JPanel parent, Button button, String label) {
        parent.add(button);
        this.buttons.put(label, button);
        return button;
    }

    public Button getButton(String name) {
        return this.buttons.get(name);
    }

}