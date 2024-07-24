package namya.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginToPredicator implements ActionListener {

    JFrame frame = new JFrame();
    JButton button = new JButton("enter to predicator");
    LoginToPredicator(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750,750);
        frame.setLayout(new GridBagLayout());

        button.setFocusable(false);
        button.addActionListener(this);


        frame.add(button);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            frame.dispose();
            Predicator predicator = new Predicator();
        }
    }
}
