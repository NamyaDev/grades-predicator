package namya.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JScrollPanel implements ActionListener {
    JFrame frame = new JFrame();
    JLayeredPane layeredPane;

    //public JLayeredPane getLayeredPane() {
    //    return layeredPane;
    //}
    int subjectIndex = 0;
    double average = 0;

    int grade;
    int credit;
    ArrayList<Integer> gradeList;
    ArrayList<Integer> creditList;

    JPanel backgroundPanel;
    JPanel subjectPanel;
    JPanel gradesPanel;
    JPanel creditsPanel;
    JPanel textFieldPanel;
    JPanel resultPanel;
    JScrollPane predictionPanel;
    JComboBox subjectBox;
    JComboBox gradesBox;
    JComboBox creditsBox;
    JTextField textField;
    JLabel resultBox;
    JPanel predictionBox;
    JButton addGradeButton;
    JLabel creditLabel;
    JLabel gradeLabel;
    JScrollPanel() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setPreferredSize(new Dimension(700, 700));
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setTitle("Predictor");
        frame.setResizable(false);

        backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new GridLayout(5,1,3,3));
        backgroundPanel.setBackground(Color.black);
        backgroundPanel.setBounds(37,37,626,273);
        backgroundPanel.setBorder(BorderFactory.createLineBorder(Color.black,3));

        subjectPanel = new JPanel();
        subjectPanel.setLayout(new BorderLayout());
        subjectPanel.setBackground(Color.lightGray);

        gradesPanel = new JPanel();
        gradesPanel.setLayout(new BorderLayout());
        gradesPanel.setBackground(Color.lightGray);

        creditsPanel = new JPanel();
        creditsPanel.setLayout(new BorderLayout());
        creditsPanel.setBackground(Color.lightGray);

        textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new BorderLayout());
        textFieldPanel.setBackground(Color.lightGray);

        resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());
        resultPanel.setBackground(Color.white);

        backgroundPanel.add(subjectPanel);
        backgroundPanel.add(gradesPanel);
        backgroundPanel.add(creditsPanel);
        backgroundPanel.add(textFieldPanel);
        backgroundPanel.add(resultPanel);


        predictionBox = new JPanel();
        predictionBox.setLayout(new BoxLayout(predictionBox, BoxLayout.Y_AXIS));
        predictionPanel = new JScrollPane(predictionBox);
        predictionPanel.setBorder(BorderFactory.createLineBorder(Color.black,3));
        predictionPanel.setBounds(37,307,626,330);


        String[] subjects = {"Subject","Mathematic", "Physics", "Czech","Geoghraphic","Biologic","History", "English"};
        subjectBox = new JComboBox(subjects);
        subjectBox.setBounds(0,0,subjectPanel.getWidth(),subjectPanel.getHeight());
        subjectBox.setFocusable(false);
        subjectBox.addActionListener(this);
        subjectPanel.add(subjectBox);

        String[] grades = {"Grade","1","2","3","4","5"};
        gradesBox = new JComboBox(grades);
        gradesBox.setBounds(0,0,gradesPanel.getWidth(),gradesPanel.getHeight());
        gradesBox.setFocusable(false);
        gradesBox.addActionListener(this);
        gradesBox.setEnabled(false);
        gradesPanel.add(gradesBox);

        String[] credits = {"Credit","1","2","3","4","5","6","7","8","9","10"};
        creditsBox = new JComboBox(credits);
        creditsBox.setBounds(0,0,creditsPanel.getWidth(),creditsPanel.getHeight());
        creditsBox.setFocusable(false);
        creditsBox.addActionListener(this);
        creditsBox.setEnabled(false);
        creditsPanel.add(creditsBox);

        resultBox = new JLabel();
        resultBox.setBounds(0,0,resultPanel.getWidth(),resultPanel.getWidth());
        resultBox.setText("AVERAGE: " + average);
        resultPanel.add(resultBox);

        textField = new JTextField();
        textField.setBounds(0,0,textFieldPanel.getWidth(),textFieldPanel.getHeight());
        textField.setText("Write topic...");
        textField.setFocusable(false);
        textField.setEnabled(false);
        textFieldPanel.add(textField);


        addGradeButton = new JButton();
        addGradeButton.setBounds(70,640,560,50);
        addGradeButton.setText("ADD GRADE");
        addGradeButton.setFocusable(false);
        addGradeButton.setFont(new Font("Arial",Font.BOLD,20));
        addGradeButton.addActionListener(this);
        addGradeButton.setEnabled(false);


        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,700,700);
        layeredPane.add(backgroundPanel);
        layeredPane.add(addGradeButton);
        layeredPane.add(predictionPanel);

        frame.add(layeredPane);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        addGradeButton.setEnabled(subjectBox.getSelectedIndex() != 0 && gradesBox.getSelectedIndex() != 0 && creditsBox.getSelectedIndex() != 0);
        if (subjectBox.getSelectedIndex() == 0 || subjectBox.getSelectedIndex() != subjectIndex){
            gradesBox.setSelectedIndex(0);
            creditsBox.setSelectedIndex(0);
        }
        if (subjectBox.getSelectedIndex() == 0){
            gradesBox.setEnabled(false);
            creditsBox.setEnabled(false);
            textField.setEnabled(false);
            textField.setFocusable(false);
        }
        else{
            gradesBox.setEnabled(true);
            creditsBox.setEnabled(true);
            textField.setEnabled(true);
            textField.setFocusable(true);
        }
        if(e.getSource() == addGradeButton){
            creditLabel = new JLabel("Credit: " + credit);

            gradeLabel = new JLabel("Grade: " + grade);

            predictionBox.add(creditLabel);
            predictionBox.add(gradeLabel);

            gradeList.add(gradesBox.getSelectedIndex());
            creditList.add(creditsBox.getSelectedIndex());
            AverageCalculator();
            resultBox.setText("AVERAGE: " + average);

            gradesBox.setSelectedIndex(0);
            creditsBox.setSelectedIndex(0);
            textField.setText("Write topic...");
        }
        if(e.getSource() == subjectBox){
            if (subjectBox.getSelectedIndex() == 0 || subjectBox.getSelectedIndex() != subjectIndex) {
                average = 0; //
                resultBox.setText("AVERAGE: " + average);
                gradeList = new ArrayList<Integer>();
                creditList = new ArrayList<Integer>();
//                predictionBox.removeAll();
//                predictionPanel.removeAll(); //todo why is it doing this?
            }
            subjectIndex = subjectBox.getSelectedIndex();
        }
        if(e.getSource() == gradesBox){
            grade = gradesBox.getSelectedIndex();
        }
        if(e.getSource() == creditsBox){
            credit = creditsBox.getSelectedIndex();
        }

    }
    public void AverageCalculator(){
        double result = 0;
        double creditSum = 0;

        for (int i = 0; i < creditList.size(); i++){
            result += gradeList.get(i) * creditList.get(i);
            creditSum += creditList.get(i);
        }
        average = result / creditSum;
    }
}
//todo umoznit mazat labely (znamky)
//todo umoznit mackani na button pomoci enteru