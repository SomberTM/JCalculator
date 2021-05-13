package Util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

public class Functional {

    @FunctionalInterface
    public static interface Void {
        void dispose();
    }

    public static ActionListener createActionListener(Consumer<ActionEvent> perform) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform.accept(e);
            }     
        };
    }      
    
    public static ActionListener createActionListener(Void perform) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform.dispose();
            }     
        };
    }
    
}
