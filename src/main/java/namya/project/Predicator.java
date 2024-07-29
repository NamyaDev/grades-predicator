package namya.project;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class Predicator implements ActionListener {
    JFrame frame = new JFrame();
    JLayeredPane layeredPane;
    int subjectIndex = 0;
    double average = 0;

    int grade;
    int credit;
    Font textFont = new Font("Arial", Font.PLAIN, 15);
    ArrayList<Integer> gradeList;
    ArrayList<Integer> creditList;
    JPanel backgroundPanel;
    JPanel subjectPanel;
    JPanel gradesPanel;
    JPanel creditsPanel;
    JPanel textFieldPanel;
    JPanel resultPanel;
    JScrollPane predictionPanel;
    JTable table;
    DefaultTableModel tableModel;
    Object[] column;
    Object[] row;
    JComboBox subjectBox;
    JComboBox gradesBox;
    JComboBox creditsBox;
    JTextField textField;
    JLabel resultBox;
    JPanel predictionBox;
    JButton addGradeButton;
    JButton deleteGradeButton;
    JButton clearGradeButton;
    Predicator() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setPreferredSize(new Dimension(700, 700));
        frame.getContentPane().setBackground(new Color(255, 112, 56));
        frame.setTitle("Predictor");
        frame.setResizable(false);

        backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new GridLayout(5,1,3,3));
        backgroundPanel.setBackground(Color.black);
        backgroundPanel.setBounds(30,30,642,282);
        backgroundPanel.setBorder(BorderFactory.createLineBorder(Color.black,3));

        subjectPanel = new JPanel();
        subjectPanel.setLayout(new BorderLayout());

        gradesPanel = new JPanel();
        gradesPanel.setLayout(new BorderLayout());

        creditsPanel = new JPanel();
        creditsPanel.setLayout(new BorderLayout());

        textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new BorderLayout());
        textFieldPanel.setBackground(new Color(238, 238, 238));

        resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());
        resultPanel.setBackground(Color.white);

        backgroundPanel.add(subjectPanel);
        backgroundPanel.add(gradesPanel);
        backgroundPanel.add(creditsPanel);
        backgroundPanel.add(textFieldPanel);
        backgroundPanel.add(resultPanel);


        predictionBox = new JPanel();
        predictionBox.setBackground(new Color(238, 238, 238));
        predictionBox.setLayout(new BoxLayout(predictionBox, BoxLayout.Y_AXIS));

        predictionPanel = new JScrollPane(predictionBox);
        predictionPanel.setBorder(BorderFactory.createLineBorder(Color.black,3));
        predictionPanel.setBounds(30,307,642,330);

        Font tableHeaderFont = new Font("Arial",Font.PLAIN,18);
        table = new JTable();
        tableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        column = new Object[]{"Description", "Credit", "Grade"};
        row = new Object[3];
        tableModel.setColumnIdentifiers(column);
        table.setModel(tableModel);
        predictionPanel.setViewportView(table);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setFont(tableHeaderFont);



        String[] subjects = {"Subject","Mathematic", "Physics", "Czech","Geoghraphic","Biologic","History", "English"};
        subjectBox = new JComboBox(subjects);
        subjectBox.setFont(textFont);
        subjectBox.setBounds(0,0,subjectPanel.getWidth(),subjectPanel.getHeight());
        subjectBox.setBackground(Color.white);
        subjectBox.setFocusable(false);
        subjectBox.addActionListener(this);
        subjectPanel.add(subjectBox);

        String[] grades = {"Grade","1","2","3","4","5"};
        gradesBox = new JComboBox(grades);
        gradesBox.setFont(textFont);
        gradesBox.setBounds(0,0,gradesPanel.getWidth(),gradesPanel.getHeight());
        gradesBox.setBackground(Color.white);
        gradesBox.setFocusable(false);
        gradesBox.addActionListener(this);
        gradesBox.setEnabled(false);
        gradesPanel.add(gradesBox);

        String[] credits = {"Credit","1","2","3","4","5","6","7","8","9","10"};
        creditsBox = new JComboBox(credits);
        creditsBox.setFont(textFont);
        creditsBox.setBounds(0,0,creditsPanel.getWidth(),creditsPanel.getHeight());
        creditsBox.setBackground(Color.white);
        creditsBox.setFocusable(false);
        creditsBox.addActionListener(this);
        creditsBox.setEnabled(false);
        creditsPanel.add(creditsBox);

        textField = new JTextField();
        textField.setFont(textFont);
        textField.setBorder(new EmptyBorder(0,3,0,0));
        textField.setBounds(0,0,textFieldPanel.getWidth(),textFieldPanel.getHeight());
        textField.setBackground(new Color(238, 238, 238));
        textField.setText("Write topic...");
        textField.setFocusable(false);
        textField.setEnabled(false);
        textFieldPanel.add(textField);

        Font resultBoxFont = new Font("Arial",Font.BOLD,14);
        resultBox = new JLabel();
        resultBox.setFont(resultBoxFont);
        resultBox.setBorder(new EmptyBorder(0,3,0,0));
        resultBox.setBounds(0,0,resultPanel.getWidth(),resultPanel.getWidth());
        resultBox.setText("AVERAGE: " + average);
        resultPanel.add(resultBox);

        deleteGradeButton = new JButton();
        deleteGradeButton.setBorder(BorderFactory.createLineBorder(Color.black,3));
        deleteGradeButton.setBounds(30,643,210,50);
        deleteGradeButton.setText("DELETE GRADE");
        deleteGradeButton.setFocusable(false);
        deleteGradeButton.setFont(new Font("Arial",Font.BOLD,18));
        deleteGradeButton.addActionListener(this);
        deleteGradeButton.setEnabled(false);

        addGradeButton = new JButton();
        addGradeButton.setBorder(BorderFactory.createLineBorder(Color.black,3));
        addGradeButton.setBounds(247,643,210,50);
        addGradeButton.setText("ADD GRADE");
        addGradeButton.setFocusable(false);
        addGradeButton.setFont(new Font("Arial",Font.BOLD,18));
        addGradeButton.addActionListener(this);
        addGradeButton.setEnabled(false);

        clearGradeButton = new JButton();
        clearGradeButton.setBorder(BorderFactory.createLineBorder(Color.black,3));
        clearGradeButton.setBounds(462,643,210,50);
        clearGradeButton.setText("CLEAR GRADES");
        clearGradeButton.setFocusable(false);
        clearGradeButton.setFont(new Font("Arial",Font.BOLD,18));
        clearGradeButton.addActionListener(this);
        clearGradeButton.setEnabled(false);


        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,700,700);
        layeredPane.add(backgroundPanel);
        layeredPane.add(deleteGradeButton);
        layeredPane.add(addGradeButton);
        layeredPane.add(clearGradeButton);
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
            textField.setBackground(new Color(238, 238, 238));
        } else {
            gradesBox.setEnabled(true);
            creditsBox.setEnabled(true);
            textField.setEnabled(true);
            textField.setFocusable(true);
            textField.setBackground(Color.white);
        }
        if (e.getSource() == addGradeButton){
            if (Objects.equals(textField.getText(), "Write topic...")){
                row[0] = "";
            } else {
                row[0] = textField.getText();
            }
            row[1] = credit;
            row[2] = grade;
            tableModel.addRow(row);

            gradeList.add(gradesBox.getSelectedIndex());
            creditList.add(creditsBox.getSelectedIndex());
            AverageCalculator();

            gradesBox.setSelectedIndex(0);
            creditsBox.setSelectedIndex(0);
            textField.setText("Write topic...");

            deleteGradeButton.setEnabled(true);
            clearGradeButton.setEnabled(true);
        }
        if (e.getSource() == subjectBox){
            if (subjectBox.getSelectedIndex() == 0 || subjectBox.getSelectedIndex() != subjectIndex) {
                average = 0; //
                resultBox.setText("AVERAGE: " + average);
                gradeList = new ArrayList<Integer>();
                creditList = new ArrayList<Integer>();
                for (int i = table.getRowCount(); i > 0; i--) {
                    tableModel.removeRow(0);
                }
            }
            subjectIndex = subjectBox.getSelectedIndex();
        }
        if (e.getSource() == gradesBox){
            grade = gradesBox.getSelectedIndex();
        }
        if (e.getSource() == creditsBox){
            credit = creditsBox.getSelectedIndex();
        }
        if (e.getSource() == deleteGradeButton){
            if (table.getSelectedRowCount()==1){
                gradeList.remove((tableModel.getValueAt(table.getSelectedRow(),1)));
                creditList.remove((tableModel.getValueAt(table.getSelectedRow(),1)));
                tableModel.removeRow(table.getSelectedRow());
                AverageCalculator();
            } else {
                JOptionPane.showMessageDialog(null, "Choose grade to delete");
            }

            if (table.getRowCount()==0){
                deleteGradeButton.setEnabled(false);
                clearGradeButton.setEnabled(false);
            }

            table.clearSelection();
        }
        if (e.getSource()== clearGradeButton){
            for (int i = table.getRowCount(); i > 0; i--){
                tableModel.removeRow(0);
            }
            gradeList.clear();
            creditList.clear();
            average = 0;
            resultBox.setText("AVERAGE: " + average);
            deleteGradeButton.setEnabled(false);
            clearGradeButton.setEnabled(false);
        }
    }
    public void AverageCalculator(){
        double result = 0;
        double creditSum = 0;
        for (int i = 0; i < creditList.size(); i++){
            result += gradeList.get(i) * creditList.get(i);
            creditSum += creditList.get(i);
        }
        if (creditSum == 0){
            average = 0;
        } else {
            average = result / creditSum;
        }
        resultBox.setText("AVERAGE: " + average);
    }
}