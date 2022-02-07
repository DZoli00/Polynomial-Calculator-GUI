package view;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private JLabel corExp = new JLabel("For correct results, please introduce polynoms like: ");
    private JLabel corExp1 = new JLabel("a*x^n+b*x^m-c*x+d");
    private JLabel corExp2 = new JLabel(", where a,b,c,d = floats; n,m = integers;\n");

    private JTextField text1 = new JTextField(30);
    private JTextField text2 = new JTextField(30);
    private JTextField textRest = new JTextField(20);
    private JPanel panelText = new JPanel();

    private JButton butonAdaugare = new JButton("+");
    private JButton butonScadere = new JButton("-");
    private JButton butonInmultire = new JButton("*");
    private JButton butonImpartire = new JButton("/");
    private JButton butonDerivare = new JButton("Derivation");
    private JButton butonIntegrare = new JButton("Integration");
    private JButton butonReset = new JButton("Reset");
    private JPanel panelButoane1 = new JPanel();
    private JPanel panelButoane2 = new JPanel();

    private JPanel finalPanel = new JPanel();

    Controller controler = new Controller(this);

    public  View(String name) {
        super(name);
        super.setSize(500,250);

        this.panelText.add(this.corExp);
        this.panelText.add(this.corExp1);
        this.panelText.add(this.corExp2);
        this.panelText.add(this.text1);
        this.panelText.add(this.textRest);
        this.textRest.setEditable(false);
        this.panelText.add(this.text2);
        this.panelText.setLayout(new BoxLayout(panelText,BoxLayout.Y_AXIS));

        this.panelButoane1.add(butonAdaugare);
        this.panelButoane1.add(butonScadere);
        this.panelButoane1.add(butonInmultire);
        this.panelButoane1.add(butonImpartire);
        this.panelButoane2.add(butonDerivare);
        this.panelButoane2.add(butonIntegrare);
        this.panelButoane2.add(butonReset);
        this.finalPanel.add(panelText);
        this.finalPanel.add(panelButoane1);
        this.finalPanel.add(panelButoane2);
        this.setContentPane(finalPanel);

    }

    public void setSumator(ActionListener a) {
        butonAdaugare.addActionListener(a);
    }

    public void setScazator(ActionListener a) {
        butonScadere.addActionListener(a);
    }

    public void setImpatitor(ActionListener a) {
        butonImpartire.addActionListener(a);
    }

    public void setInmultitor(ActionListener a) {
        butonInmultire.addActionListener(a);
    }

    public void setIntegrare(ActionListener a) {
        butonIntegrare.addActionListener(a);
    }

    public void setDerivare(ActionListener a) {
        butonDerivare.addActionListener(a);
    }

    public void setReset(ActionListener a){butonReset.addActionListener(a);}


    public JTextField getText1() {
        return text1;
    }

    public JTextField getTextRest(){ return textRest;}

    public JTextField getText2() {
        return text2;
    }


    public static void main(String[] args){
        JFrame view  = new View("Calculator de Polinoame");
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setVisible(true);

    }
}
