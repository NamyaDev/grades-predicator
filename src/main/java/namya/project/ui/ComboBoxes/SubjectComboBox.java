package namya.project.ui.ComboBoxes;

import java.awt.*;
import java.awt.event.ActionListener;

public class SubjectComboBox extends CommonComboBox{
    static String[] subjects = {"","Mathematic", "Physics", "Czech","Geoghraphic","Biologic","History", "English"};
    public SubjectComboBox(Font font, int width, int height, ActionListener listener){
        super(subjects,font, width, height, listener);
    }
}
