package GUI;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.Icon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton {
    
    private List<Consumer<Button>> listeners = new ArrayList<>();
    private ActionListener listener;

    public Button() {
        this(null, null);
    }

    public Button(Icon icon) {
        this(null, icon);
    }

    public Button(String text) {
        this(text, null);
    }

    public Button(String text, Icon icon) {
        super(text, icon);
    }

    public void onClick(Consumer<Button> consumer) {
        Button reference = this;
        this.listeners.add(consumer);
        if (this.listener == null)
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    consumer.accept(reference);
                }
            });
            // this.addActionListener((this.listener = Functional.createActionListener((event) -> {
            //     for (Consumer<ActionEvent> e : this.listeners) 
            //         e.accept(event);
            // })));
    }

}
