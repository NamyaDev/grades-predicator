package namya.project.ui.ComboBoxes;

import java.awt.*;
import java.awt.event.ActionListener;

public class GradeComboBox extends CommonComboBox {
    static String[] grades = {"","1","2","3","4","5"};
    public GradeComboBox(Font font, int width, int height, ActionListener listener){
        super(grades,font, width, height, listener);
        this.setEnabled(false);
    }
}
