package namya.project.ui.ComboBoxes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CommonComboBox extends JComboBox<String> {
    public CommonComboBox(String[] subjects, Font font, int width, int height, ActionListener listener){
        super(subjects);
        this.setFont(font);
        this.setSize(width,height);
        this.setBackground(Color.white);
        this.setFocusable(false);
        this.addActionListener(listener);
    }
}
