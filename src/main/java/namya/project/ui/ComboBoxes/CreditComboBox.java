package namya.project.ui.ComboBoxes;

import java.awt.*;
import java.awt.event.ActionListener;

public class CreditComboBox extends CommonComboBox {
    static String[] credits = {"","1", "2", "3","4","5","6", "7","8","9","10"};
    public CreditComboBox(Font font, int width, int height, ActionListener listener){
        super(credits,font, width, height, listener);
        this.setEnabled(false);
    }
}
