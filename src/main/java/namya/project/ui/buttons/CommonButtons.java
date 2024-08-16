package namya.project.ui.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class CommonButtons extends JButton{
    CommonButtons(ActionListener listener){
        this.setBorder(BorderFactory.createLineBorder(Color.black,3));
        this.setFocusable(false);
        this.setFont(new Font("Arial",Font.BOLD,18));
        this.setEnabled(false);
        this.addActionListener(listener);
    }
}
