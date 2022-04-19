import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;

import static java.lang.Double.parseDouble;


public class mainFrame extends JFrame {
    JPanel panel = new JPanel();

    JLabel label1 = new JLabel("Welcome to Units Converter");
    Dimension dim = new Dimension(120, 25);
    Dimension dim1 = new Dimension(200, 70);
    Dimension dim2 = new Dimension(400, 400);
    JLabel label = new JLabel("From ");
    JComboBox comboBFrom = new JComboBox();
    JLabel label2 = new JLabel("To");
    JComboBox comboBTo = new JComboBox();
    JComboBox comboBUnitType = new JComboBox();
    JTextField textFResult = new JTextField();
    JTextField textFToChange = new JTextField();

    JButton btn = new JButton("Change!");

    public mainFrame() {
        super();

        setLayout(new FlowLayout());
        add(label1);
        add(panel);
        add(comboBUnitType);
        add(label);
        add(comboBFrom);
        add(label2);
        add(comboBTo);
        add(textFToChange);
        add(textFResult);
        add(btn);

        ArrayList<String> unitsList = new ArrayList<>(4);
        unitsList.add(0, "Length");
        unitsList.add(1, "Mass");
        unitsList.add(2, "Time");

        comboBUnitType.addItem(unitsList.get(0));
        comboBUnitType.addItem(unitsList.get(1));
        comboBUnitType.addItem(unitsList.get(2));

        textFResult.setEnabled(false);

        comboBUnitType.addActionListener(ActionEvent ->{
            if (comboBUnitType.getSelectedIndex() == 0) {
                refreshToComboBox();
                setComboBUnitsType();
            } else if(comboBUnitType.getSelectedIndex() == 1){
                refreshToComboBox();
                setComboBUnitsType1();
            }else{
                refreshToComboBox();
                setComboBUnitsType2();
            }
        });

        /*comboBUnitType.addActionListener(ActionListener ->{
            for(int i = 0; i <=4; i++) {
                if (comboBUnitType.getSelectedIndex() == 0){
                    refreshToComboBox();
                    setComboBUnitsType();
                }else{
                    comboBUnitType.setSelectedIndex(++i);
                    refreshToComboBox();
                    setComboBUnitsType1();


                }
            }
        });

*/

        btn.addActionListener(ActionEvent ->

                {
                    if (comboBFrom.getSelectedIndex() == 0 && comboBTo.getSelectedIndex() == 0) {
                        exceptionMethod();
                    } else if (comboBFrom.getSelectedIndex() == 0 && comboBTo.getSelectedIndex() == 1) {
                        if(comboBUnitType.getSelectedIndex() == 0 || comboBUnitType.getSelectedIndex() == 1) {
                            setScaleUnitsFromGToDk();
                        }else{
                            refreshToButton();

                        }
                    } else if (comboBFrom.getSelectedIndex() == 0 && comboBTo.getSelectedIndex() == 2) {
                        if(comboBUnitType.getSelectedIndex() == 0 || comboBUnitType.getSelectedIndex() == 1) {
                            setScaleUnitsFromGToKg();
                        }else {
                        refreshToButton();
                        }
                    }else if (comboBFrom.getSelectedIndex() == 0 && comboBTo.getSelectedIndex() == 3) {
                        if(comboBUnitType.getSelectedIndex() == 0 || comboBUnitType.getSelectedIndex() == 1) {
                            setScaleUnitsFromGToT();
                        }else {
                            refreshToButton();
                        }
                        } else if (comboBFrom.getSelectedIndex() == 1 && comboBTo.getSelectedIndex() == 0) {
                        if(comboBUnitType.getSelectedIndex() == 0 || comboBUnitType.getSelectedIndex() == 1) {
                            setScaleUnitsFromDkToG();
                        }else {
                            refreshToButton();
                        }
                    } else if (comboBFrom.getSelectedIndex() == 1 && comboBTo.getSelectedIndex() == 1) {
                        exceptionMethod();
                    } else if (comboBFrom.getSelectedIndex() == 1 && comboBTo.getSelectedIndex() == 2) {
                        if(comboBUnitType.getSelectedIndex() == 0 || comboBUnitType.getSelectedIndex() == 1) {
                            setScaleUnitsFromDkToKg();
                        }else {
                            refreshToButton();
                        }
                    } else if (comboBFrom.getSelectedIndex() == 1 && comboBTo.getSelectedIndex() == 3) {
                        if(comboBUnitType.getSelectedIndex() == 0 || comboBUnitType.getSelectedIndex() == 1) {
                            setScaleUnitsFromDkToT();
                        }else {
                            refreshToButton();
                        }
                    } else if (comboBFrom.getSelectedIndex() == 2 && comboBTo.getSelectedIndex() == 0) {
                        if(comboBUnitType.getSelectedIndex() == 0 || comboBUnitType.getSelectedIndex() == 1) {
                            setScaleUnitsFromKgToG();
                        }else {
                            refreshToButton();
                        }
                    } else if (comboBFrom.getSelectedIndex() == 2 && comboBTo.getSelectedIndex() == 1) {
                        if(comboBUnitType.getSelectedIndex() == 0 || comboBUnitType.getSelectedIndex() == 1) {
                            setScaleUnitsFromKgToDk();
                        }else {
                            refreshToButton();
                        }
                    } else if (comboBFrom.getSelectedIndex() == 2 && comboBTo.getSelectedIndex() == 2) {
                            exceptionMethod();
                    } else if (comboBFrom.getSelectedIndex() == 2 && comboBTo.getSelectedIndex() == 3) {
                        if(comboBUnitType.getSelectedIndex() == 0 || comboBUnitType.getSelectedIndex() == 1) {
                            setScaleUnitsFromKgToT();
                        }else {
                            refreshToButton();
                        }
                    } else if (comboBFrom.getSelectedIndex() == 3 && comboBTo.getSelectedIndex() == 0) {
                        if(comboBUnitType.getSelectedIndex() == 0 || comboBUnitType.getSelectedIndex() == 1) {
                            setScaleUnitsFromTToG();
                        }else {
                            refreshToButton();
                        }
                    } else if (comboBFrom.getSelectedIndex() == 3 && comboBTo.getSelectedIndex() == 1) {
                        if(comboBUnitType.getSelectedIndex() == 0 || comboBUnitType.getSelectedIndex() == 1) {
                            setScaleUnitsFromTToDk();
                        }else {
                            refreshToButton();
                        }
                    } else if (comboBFrom.getSelectedIndex() == 3 && comboBTo.getSelectedIndex() == 2) {
                        if(comboBUnitType.getSelectedIndex() == 0 || comboBUnitType.getSelectedIndex() == 1) {
                            setScaleUnitsFromTToKg();
                        }else {
                            refreshToButton();
                        }
                    } else if (comboBFrom.getSelectedIndex() == 3 && comboBTo.getSelectedIndex() == 3) {
                        exceptionMethod();
                    }

                });

        textFToChange.setPreferredSize(dim);
        textFResult.setPreferredSize(dim);
        label1.setPreferredSize(dim1);
        btn.setBounds(100,500,100,25);
        comboBTo.setPreferredSize(dim);
        comboBFrom.setPreferredSize(dim);
        textFResult.setLocation(new Point(100,500));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,400);
        setLocation(650,350);
        setVisible(true);
        setMaximumSize(dim2);
                }
  public void exceptionMethod()
    {
        if (textFToChange.getText().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Proszę się upewnić że została wpisana wartość do zamiany");
        } else {
            try {
                throw new IllegalArgumentException("Nie można zamienić dwóch takich samych wymiarów");
            } catch (IllegalArgumentException exception) {
                JOptionPane.showMessageDialog(panel, "Nie można zamienić dwóch takich samych wymiarów");
            }
        }
    }
   public void exceptionNumberFormat() {
        if (textFToChange.getText().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Proszę się upewnić że została wpisana wartość do zamiany");
        }else{
            try {
                throw new NumberFormatException("Proszę się upewnić że została wpisana wartość do zamiany.");
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(panel, "Nie można zamienić dwóch takich samych wymiarów");
            }
        }
   }

    public void setScaleUnitsFromGToDk() {
        if(textFToChange.getText().isEmpty()) {
            exceptionNumberFormat();
        }else {
            double g = parseDouble(textFToChange.getText());
            double dk = g / 10;

            textFResult.setText(String.valueOf(dk));
        }
        }
    public void setScaleUnitsFromGToKg(){
        if(textFToChange.getText().isEmpty()) {
            exceptionNumberFormat();
        }else {
            double g = parseDouble(textFToChange.getText());
            double kg = g / 1000;
            textFResult.setText(String.valueOf(kg));
        }
    }
    public void setScaleUnitsFromGToT(){
        if(textFToChange.getText().isEmpty()) {
            exceptionNumberFormat();
        }else {
            double g = parseDouble(textFToChange.getText());
            double T = g / 1000000;

            textFResult.setText(String.valueOf(T));
        }
    }
    public void setScaleUnitsFromDkToG() {
        if (textFToChange.getText().isEmpty()) {
            exceptionNumberFormat();
        } else {
            double dk = parseDouble(textFToChange.getText());
            double g = dk * 10;

            textFResult.setText(String.valueOf(g));
        }
    }
    public void setScaleUnitsFromDkToKg() {
        if(textFToChange.getText().isEmpty()) {
            exceptionNumberFormat();
        }else {
            double dk = parseDouble(textFToChange.getText());
            double kg = dk / 100;

            textFResult.setText(String.valueOf(kg));
        }
    }
    public void setScaleUnitsFromDkToT() {
        if (textFToChange.getText().isEmpty()) {
            exceptionNumberFormat();
        } else {
            double dk = parseDouble(textFToChange.getText());
            double T = dk / 100000;

            textFResult.setText(String.valueOf(T));
        }
    }
    public void setScaleUnitsFromKgToG() {
        if(textFToChange.getText().isEmpty()) {
            exceptionNumberFormat();
        }else {
            double kg = parseDouble(textFToChange.getText());
            double g = kg * 1000;

            textFResult.setText(String.valueOf(g));
        }
    }
    public void setScaleUnitsFromKgToDk() {
        if(textFToChange.getText().isEmpty()) {
            exceptionNumberFormat();
        }else {
            double kg = parseDouble(textFToChange.getText());
            double dk = kg * 100;

            textFResult.setText(String.valueOf(dk));
        }
    }
    public void setScaleUnitsFromKgToT() {
        if (textFToChange.getText().isEmpty()) {
            exceptionNumberFormat();
        } else {
            double kg = parseDouble(textFToChange.getText());
            double T = kg / 1000;

            textFResult.setText(String.valueOf(T));
        }
    }
    public void setScaleUnitsFromTToG() {
        if (textFToChange.getText().isEmpty()) {
            exceptionNumberFormat();
        } else {
            double T = parseDouble(textFToChange.getText());
            double g = T * 1000000;

            textFResult.setText(String.valueOf(g));
        }
    }
    public void setScaleUnitsFromTToDk() {
        if (textFToChange.getText().isEmpty()) {
            exceptionNumberFormat();
        } else {
            double T = parseDouble(textFToChange.getText());
            double dk = T * 100000;

            textFResult.setText(String.valueOf(dk));
        }
    }
    public void setScaleUnitsFromTToKg() {
        if (textFToChange.getText().isEmpty()) {
            exceptionNumberFormat();
        } else {
            double T = parseDouble(textFToChange.getText());
            double kg = T * 1000;

            textFResult.setText(String.valueOf(kg));
        }
    }
    public void setComboBUnitsType() {
        if (comboBUnitType.getSelectedIndex() == 0) {

            ArrayList<String> unit1 = new ArrayList<>(4);
            unit1.add(0, "Milimetr");
            unit1.add(1, "Centymetr");
            unit1.add(2, "Metr");
            unit1.add(3, "Kilometr");

            comboBFrom.addItem(unit1.get(0));
            comboBFrom.addItem(unit1.get(1));
            comboBFrom.addItem(unit1.get(2));
            comboBFrom.addItem(unit1.get(3));

            comboBTo.addItem(unit1.get(0));
            comboBTo.addItem(unit1.get(1));
            comboBTo.addItem(unit1.get(2));
            comboBTo.addItem(unit1.get(3));
        }
    }
        public void setComboBUnitsType1() {
            if(comboBUnitType.getSelectedIndex() == 1)
        {
            ArrayList<String> unit1 = new ArrayList<>(4);
            unit1.add(0, "Gram");
            unit1.add(1, "Dekagram");
            unit1.add(2, "Kilogram");
            unit1.add(3, "Tona");

            comboBFrom.addItem(unit1.get(0));
            comboBFrom.addItem(unit1.get(1));
            comboBFrom.addItem(unit1.get(2));
            comboBFrom.addItem(unit1.get(3));

            comboBTo.addItem(unit1.get(0));
            comboBTo.addItem(unit1.get(1));
            comboBTo.addItem(unit1.get(2));
            comboBTo.addItem(unit1.get(3));
        }
    }
    public void setComboBUnitsType2() {
        if (comboBUnitType.getSelectedIndex() == 2) {

            ArrayList<String> unit1 = new ArrayList<>(4);
            unit1.add(0, "Milisekunda");
            unit1.add(1, "Sekunda");
            unit1.add(2, "Minuta");
            unit1.add(3, "Godzina");

            comboBFrom.addItem(unit1.get(0));
            comboBFrom.addItem(unit1.get(1));
            comboBFrom.addItem(unit1.get(2));
            comboBFrom.addItem(unit1.get(3));

            comboBTo.addItem(unit1.get(0));
            comboBTo.addItem(unit1.get(1));
            comboBTo.addItem(unit1.get(2));
            comboBTo.addItem(unit1.get(3));
        }
    }
    public void refreshToComboBox() {
        if (comboBUnitType.getSelectedIndex() == 0)
        {
            comboBFrom.removeAllItems();
            comboBTo.removeAllItems();
            comboBUnitType.setSelectedIndex(0);

        }else if (comboBUnitType.getSelectedIndex() == 1){
            comboBFrom.removeAllItems();
            comboBTo.removeAllItems();
            comboBUnitType.setSelectedIndex(1);
        }else{
            comboBFrom.removeAllItems();
            comboBTo.removeAllItems();
            comboBUnitType.setSelectedIndex(2);
        }
    }
    public void setScaleUnitsMSToS() {
        if (textFToChange.getText().isEmpty()) {
            exceptionNumberFormat();
        } else {
            double mS = parseDouble(textFToChange.getText());
            double s = mS * 100;
            textFResult.setText(String.valueOf(s));
        }
    }
    public void setScaleUnitsMSToM() {
        if (textFToChange.getText().isEmpty()) {
            exceptionNumberFormat();
        } else {
            double mS = parseDouble(textFToChange.getText());
            double M = mS / 60000;
            textFResult.setText(String.valueOf(M));
        }
    }
    public void setScaleUnitsMSToH() {
        if (textFToChange.getText().isEmpty()) {
            exceptionNumberFormat();
        } else {
            double mS = parseDouble(textFToChange.getText());
            double H = mS / 3600000;
            textFResult.setText(String.valueOf(H));
        }
    }
    public void setScaleUnitsSTomS() {
        if (textFToChange.getText().isEmpty()) {
            exceptionNumberFormat();
        } else {
            double S = parseDouble(textFToChange.getText());
            double mS = S * 100;
            textFResult.setText(String.valueOf(mS));
        }
    }
    public void setScaleUnitsSToM() {
        if (textFToChange.getText().isEmpty()) {
            exceptionNumberFormat();
        } else {
            double S = parseDouble(textFToChange.getText());
            double M = S / 60;
            textFResult.setText(String.valueOf(M));
        }
    }
    public void setScaleUnitsSToH() {
        if (textFToChange.getText().isEmpty()) {
            exceptionNumberFormat();
        } else {
            double S = parseDouble(textFToChange.getText());
            double H = S / 3600;
            textFResult.setText(String.valueOf(H));
        }
    }
    public void setScaleUnitsMToMS() {
        if (textFToChange.getText().isEmpty()) {
            exceptionNumberFormat();
        } else {
            double M = parseDouble(textFToChange.getText());
            double mS = M * 60000;
            textFResult.setText(String.valueOf(mS));
        }
    }
    public void setScaleUnitsMToS() {
        if (textFToChange.getText().isEmpty()) {
            exceptionNumberFormat();
        } else {
            double M = parseDouble(textFToChange.getText());
            double S = M * 60;
            textFResult.setText(String.valueOf(S));
        }
    }
    public void setScaleUnitsMToH() {
        if (textFToChange.getText().isEmpty()) {
            exceptionNumberFormat();
        } else {
            double M = parseDouble(textFToChange.getText());
            double H = M / 60;
            textFResult.setText(String.valueOf(H));
        }
    }
    public void setScaleUnitsHToMS() {
        if (textFToChange.getText().isEmpty()) {
            exceptionNumberFormat();
        } else {
            double H = parseDouble(textFToChange.getText());
            double mS = H * 3600000;
            textFResult.setText(String.valueOf(mS));
        }
    }
    public void setScaleUnitsHToS() {
        if (textFToChange.getText().isEmpty()) {
            exceptionNumberFormat();
        } else {
            double H = parseDouble(textFToChange.getText());
            double S = H * 3600;
            textFResult.setText(String.valueOf(S));
        }
    }
    public void setScaleUnitsHToM() {
        if (textFToChange.getText().isEmpty()) {
            exceptionNumberFormat();
        } else {
            double H = parseDouble(textFToChange.getText());
            double M = H * 60;
            textFResult.setText(String.valueOf(M));
        }
    }
    public void refreshToButton()
    {
        if(comboBUnitType.getSelectedIndex() == 2 && comboBFrom.getSelectedIndex() == 0 && comboBTo.getSelectedIndex() == 1)
            {
                setScaleUnitsMSToS();
            }else if(comboBUnitType.getSelectedIndex() == 2 && comboBFrom.getSelectedIndex() == 0 && comboBTo.getSelectedIndex() == 2)
            {
             setScaleUnitsMSToM();
            }else if(comboBUnitType.getSelectedIndex() == 2 && comboBFrom.getSelectedIndex() == 0 && comboBTo.getSelectedIndex() == 3)
            {
                setScaleUnitsMSToH();
            }else if(comboBUnitType.getSelectedIndex() == 2 && comboBFrom.getSelectedIndex() == 1 && comboBTo.getSelectedIndex() == 0)
            {
                setScaleUnitsSTomS();
            }else if(comboBUnitType.getSelectedIndex() == 2 && comboBFrom.getSelectedIndex() == 1 && comboBTo.getSelectedIndex() == 2)
            {
                setScaleUnitsSToM();
            }else if(comboBUnitType.getSelectedIndex() == 2 && comboBFrom.getSelectedIndex() == 1 && comboBTo.getSelectedIndex() == 3)
            {
                setScaleUnitsSToH();
            }else if(comboBUnitType.getSelectedIndex() == 2 && comboBFrom.getSelectedIndex() == 2 && comboBTo.getSelectedIndex() == 0)
            {
                setScaleUnitsMToMS();
            }else if(comboBUnitType.getSelectedIndex() == 2 && comboBFrom.getSelectedIndex() == 2 && comboBTo.getSelectedIndex() == 1)
            {
                setScaleUnitsMToS();
            }else if(comboBUnitType.getSelectedIndex() == 2 && comboBFrom.getSelectedIndex() == 2 && comboBTo.getSelectedIndex() == 3)
            {
                setScaleUnitsMToH();
            }else if(comboBUnitType.getSelectedIndex() == 2 && comboBFrom.getSelectedIndex() == 3 && comboBTo.getSelectedIndex() == 0)
            {
                setScaleUnitsHToMS();
            }else if(comboBUnitType.getSelectedIndex() == 2 && comboBFrom.getSelectedIndex() == 3 && comboBTo.getSelectedIndex() == 1)
            {
                setScaleUnitsHToS();
            }else if(comboBUnitType.getSelectedIndex() == 2 && comboBFrom.getSelectedIndex() == 3 && comboBTo.getSelectedIndex() == 2)
            {
                setScaleUnitsHToM();
            }
       }

}

