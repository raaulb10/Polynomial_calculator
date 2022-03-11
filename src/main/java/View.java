import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class View extends JFrame {

    private JLabel labelpolinom1=new JLabel("P1:");
    private JLabel labelpolinom2=new JLabel("P2:");
    private JLabel labelpolinomrez=new JLabel("Rezult:");
    private JTextField fieldpolinom1=new JTextField(15);
    private JTextField fieldpolinom2=new JTextField(15);
    private JTextField fieldpolinomrez=new JTextField(15);
    private JButton buttonsubp1=new JButton("submitP1");
    private JButton buttonsubp2=new JButton("submitP2");
    private JButton buttonadd=new JButton("+");
    private JButton buttonsub=new JButton("-");
    private JButton buttonmultiply=new JButton("*");
    private JButton buttonder=new JButton("Der");
    private JButton buttondiv=new JButton("/");
    private JButton buttonres=new JButton("%");
    private JButton buttonint=new JButton("Integral");

    private JTextField m_userInputTf = new JTextField(5);
    private JTextField m_totalTf     = new JTextField(20);
    private JButton    m_multiplyBtn = new JButton("Multiply");
    private JButton    m_clearBtn    = new JButton("Clear");

   // private Polinom model;

    View(){


        labelpolinom1.setForeground(Color.green);
        labelpolinom2.setForeground(Color.green);
        labelpolinomrez.setForeground(Color.green);
        buttonsubp1.setBackground(Color.white);
        buttonsubp1.setForeground(Color.green);
        buttonsubp2.setBackground(Color.white);
        buttonsubp2.setForeground(Color.green);
        buttonadd.setBackground(Color.white);
        buttonadd.setForeground(Color.green);
        buttonsub.setBackground(Color.white);
        buttonsub.setForeground(Color.green);
        buttonmultiply.setBackground(Color.white);
        buttonmultiply.setForeground(Color.green);
        buttonder.setBackground(Color.white);
        buttonder.setForeground(Color.green);
        buttondiv.setBackground(Color.white);
        buttondiv.setForeground(Color.green);
        buttonres.setBackground(Color.white);
        buttonres.setForeground(Color.green);
        buttonint.setBackground(Color.white);
        buttonint.setForeground(Color.green);


        fieldpolinomrez.setEditable(false);
        JPanel content = new JPanel();
        content.setBackground(Color.black);
        content.setLayout(new GridBagLayout());


        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        content.add(labelpolinom1, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 0;
        content.add(fieldpolinom1,c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 2;
        c.gridy = 0;
        content.add(buttonsubp1, c);

        //c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 1;
        content.add(labelpolinom2, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        content.add(fieldpolinom2,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 2;
        c.gridy = 1;
        content.add(buttonsubp2, c);

        c.gridx = 0;
        c.gridy = 2;
        content.add(labelpolinomrez, c);
        c.gridx = 1;
        c.gridy = 2;
        content.add(fieldpolinomrez,c);


        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 3;
        content.add(buttonadd, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 2;
        c.gridy = 3;
        content.add(buttonsub,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 4;
        content.add(buttonmultiply,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 2;
        c.gridy = 4;
        content.add(buttonder,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 5;
        content.add(buttondiv,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 2;
        c.gridy = 5;
        content.add(buttonres,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 6;
        content.add(buttonint,c);


        /*
        content.add(new JLabel("Input"));
        content.add(m_userInputTf);
        content.add(m_multiplyBtn);
        content.add(new JLabel("Total"));
        content.add(m_totalTf);
        content.add(m_clearBtn);
        */
        //finalizare
        this.setContentPane(content);
        this.pack();

        this.setTitle("Polynomial calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    String getP1() {
        return fieldpolinom1.getText();
    }
    String getP2() {
        return fieldpolinom2.getText();
    }
    void setRez(String rezultat) {
        fieldpolinomrez.setText(rezultat);
    }

    void addSubmit1Listener(ActionListener mal) {
        buttonsubp1.addActionListener(mal);
    }
    void addSubmit2Listener(ActionListener mal) {
        buttonsubp2.addActionListener(mal);
    }

    void addAddListener(ActionListener mal) {
        buttonadd.addActionListener(mal);
    }
    void addSubListener(ActionListener mal) {
        buttonsub.addActionListener(mal);
    }
    void addMultiplyListener(ActionListener mal) {
        buttonmultiply.addActionListener(mal);
    }
    void addDerListener(ActionListener mal) {
        buttonder.addActionListener(mal);
    }
    void addDivListener(ActionListener mal) {
        buttondiv.addActionListener(mal);
    }
    void addResListener(ActionListener mal) {
        buttonres.addActionListener(mal);
    }
    void addIntListener(ActionListener mal) {
        buttonint.addActionListener(mal);
    }

}
