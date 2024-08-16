package namya.project.ui.buttons;

import java.awt.event.ActionListener;

public class ClearButton extends CommonButtons {
    public ClearButton(int x, int y, int width, int height, String text, ActionListener listener){
        super(listener);
        this.setBounds(x,y,width,height);
        this.setText(text);
    }
}
