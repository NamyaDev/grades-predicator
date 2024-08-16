package namya.project.ui.buttons;

import javax.swing.*;
import java.awt.*;

public abstract class CommonButton extends JButton{
    CommonButton(){
        this.setBorder(BorderFactory.createLineBorder(Color.black,3));
        this.setFocusable(false);
        this.setFont(new Font("Arial",Font.BOLD,18));
        this.setEnabled(false);
    }
}
