package namya.project.logic;

import javax.swing.*;
import java.util.ArrayList;

public class Calculation extends JLabel{
    public Calculation(){
    }
    public double averageCalculation(ArrayList<Integer> gradeList, ArrayList<Integer> creditList, double average, JLabel resultBox){
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
        resultBox.setText("AVERAGE: " + String.format("%.2f", average));
        return  average;
    }
}
