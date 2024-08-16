package namya.project;

import namya.project.ui.buttons.AddButton;
import namya.project.ui.buttons.ClearButton;
import namya.project.ui.buttons.DeleteButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
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

    static String[] subjects = {"","Mathematic", "Physics", "Czech","Geoghraphic","Biologic","History", "English"};
    static String[] grades = {"","1","2","3","4","5"};
    static String[] credits = {"","1","2","3","4","5","6","7","8","9","10"};

    static Object[] column = new Object[]{"Description", "Credit", "Grade"};
    static Object[] row = new Object[3];

    Font textFont = new Font("Arial", Font.PLAIN, 15);

    ArrayList<Integer> gradeList;
    ArrayList<Integer> creditList;

    JPanel backgroundPanel;
    JPanel subjectPanel;
    JPanel gradesPanel;
    JPanel creditsPanel;
    JPanel textFieldPanel;
    JPanel resultPanel;
    JPanel predictionPanel;

    JScrollPane predictionPane;

    JTable table;
    DefaultTableModel tableModel;

    JComboBox subjectBox;
    JComboBox gradesBox;
    JComboBox creditsBox;

    JTextField textField;

    JLabel resultBox;

    AddButton addGradeButton;
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
        backgroundPanel.setBackground(Color.BLACK);
        backgroundPanel.setBorder(BorderFactory.createLineBorder(Color.black,3));
        backgroundPanel.setBounds(30,30,642,282);

        subjectPanel = new JPanel();
        subjectPanel.setLayout(new GridBagLayout());

        gradesPanel = new JPanel();
        gradesPanel.setLayout(new GridBagLayout());

        creditsPanel = new JPanel();
        creditsPanel.setLayout(new GridBagLayout());

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


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;


        predictionPanel = new JPanel();
        predictionPanel.setBackground(new Color(238, 238, 238));
        predictionPanel.setLayout(new BoxLayout(predictionPanel, BoxLayout.Y_AXIS));

        predictionPane = new JScrollPane(predictionPanel);
        predictionPane.setBorder(BorderFactory.createLineBorder(Color.black,3));
        predictionPane.setBounds(30,307,642,330);

        Font tableHeaderFont = new Font("Arial",Font.PLAIN,18);
        table = new JTable();
        tableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }
        };

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        tableModel.setColumnIdentifiers(column);
        table.setModel(tableModel);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table.setFont(textFont);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setFont(tableHeaderFont);
        predictionPane.setViewportView(table);


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        subjectPanel.add(new JLabel(" Subject: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 10;
        subjectBox = new JComboBox(subjects);
        subjectBox.setFont(textFont);
        subjectBox.setBounds(0,0,subjectPanel.getWidth(),subjectPanel.getHeight());
        subjectBox.setBackground(Color.white);
        subjectBox.setFocusable(false);
        subjectBox.addActionListener(this);
        subjectPanel.add(subjectBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        gradesPanel.add(new JLabel(" Grade:    "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 10;
        gradesBox = new JComboBox(grades);
        gradesBox.setFont(textFont);
        gradesBox.setBounds(0,0,gradesPanel.getWidth(),gradesPanel.getHeight());
        gradesBox.setBackground(Color.white);
        gradesBox.setFocusable(false);
        gradesBox.addActionListener(this);
        gradesBox.setEnabled(false);
        gradesPanel.add(gradesBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        creditsPanel.add(new JLabel(" Credit:    "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 10;
        creditsBox = new JComboBox(credits);
        creditsBox.setFont(textFont);
        creditsBox.setBounds(0,0,creditsPanel.getWidth(),creditsPanel.getHeight());
        creditsBox.setBackground(Color.white);
        creditsBox.setFocusable(false);
        creditsBox.addActionListener(this);
        creditsBox.setEnabled(false);
        creditsPanel.add(creditsBox, gbc);

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

        deleteGradeButton = new DeleteButton(30,643,210,50,"DELETE RECORD", this);

        addGradeButton = new AddButton(247,643,210,50,"ADD RECORD",this);

        clearGradeButton = new ClearButton(462,643,210,50,"CLEAR RECORD",this);


        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,700,700);
        layeredPane.add(backgroundPanel);
        layeredPane.add(deleteGradeButton);
        layeredPane.add(addGradeButton);
        layeredPane.add(clearGradeButton);
        layeredPane.add(predictionPane);

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
                gradeList.remove((tableModel.getValueAt(table.getSelectedRow(),2)));
                creditList.remove((tableModel.getValueAt(table.getSelectedRow(),1)));
                tableModel.removeRow(table.getSelectedRow());
                AverageCalculator();
            } else {
                JOptionPane.showMessageDialog(null, "Choose grade to delete","",JOptionPane.WARNING_MESSAGE);
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