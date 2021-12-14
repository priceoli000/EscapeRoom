import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscapeRoom {

    static JPanel panel;
    static JRadioButton Op1, Op2, Op1Pt2, Op2Pt2, Op1Pt3, Op2Pt3;
    static JLabel sitLabel, op1Text, op2Text;
    static JButton nextBtn, nextBtn2;
    static JFrame frame;

    //user clicks Next Button to tell background story
    //the logic is... very messed up
    //today create more buttons so one is not doing multiple things

    public static void main(String[] args) {
        EscapeRoomGUI();
    }

    public static void EscapeRoomGUI() {
        frame = new JFrame("Escape Room");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        Op1 = new JRadioButton("Option 1:");
        Op1Pt2 = new JRadioButton("Option 1:");
        Op1Pt3 = new JRadioButton("Option 1:");
        Op2 = new JRadioButton("Option 2:");
        Op2Pt2 = new JRadioButton("Option 2:");
        Op2Pt3 = new JRadioButton("Option 2:");
        ButtonGroup radios = new ButtonGroup();
        nextBtn = new JButton("Next");
        nextBtn2 = new JButton("Next");
        sitLabel = new JLabel("You and your friend Jake are stuck on an abandoned ship after your boat was hijacked.");
        op1Text = new JLabel("Open the door.");
        op2Text = new JLabel("Look around the desk.");


        Op1.setBounds(100, 150, 75, 50);
        Op1Pt2.setBounds(100, 150, 75, 50);
        Op1Pt3.setBounds(100, 150, 75, 50);
        Op2.setBounds(100, 275, 75, 50);
        Op2Pt2.setBounds(100, 275, 75, 50);
        Op2Pt3.setBounds(100, 275, 75, 50);
        nextBtn.setBounds(250, 88, 100, 25);
        nextBtn2.setBounds(250, 88, 100, 25);
        op1Text.setBounds(175, 150, 250, 50);
        op1Text.setBounds(175, 150, 250, 50);
        op1Text.setBounds(175, 150, 250, 50);
        op2Text.setBounds(175, 275, 250, 50);
        op2Text.setBounds(175, 275, 250, 50);
        op2Text.setBounds(175, 275, 250, 50);
        sitLabel.setBounds(10, 25, 500, 100);


        nextBtn.addActionListener(new StoryBtn());
        nextBtn2.addActionListener(new StoryBtn2());
        Op1.addActionListener(new RadiosButtonListener1());
        Op2.addActionListener(new RadiosButtonListener1());
        Op1Pt2.addActionListener(new RadiosButtonListener1());
        Op2Pt2.addActionListener(new RadiosButtonListener1());
        Op2Pt3.addActionListener(new RadiosButtonListener1());

        radios.add(Op1);
        radios.add(Op1Pt2);
        radios.add(Op1Pt3);
        radios.add(Op2);
        radios.add(Op2Pt2);
        radios.add(Op2Pt3);

        panel.add(Op1);
        panel.add(Op1Pt2);
        panel.add(Op1Pt3);
        panel.add(Op2);
        panel.add(Op2Pt2);
        panel.add(Op2Pt3);
        panel.add(nextBtn);
        panel.add(nextBtn2);
        panel.add(sitLabel);
        panel.add(op1Text);
        panel.add(op2Text);


        panel.setLayout(null);

        frame.add(panel);
        frame.setVisible(true);

        nextBtn2.setVisible(false);
        Op1Pt2.setVisible(false);
        Op1Pt3.setVisible(false);
        Op2Pt2.setVisible(false);
        Op2Pt3.setVisible(false);


    }

    private static class StoryBtn implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            sitLabel.setText("You have to radio for help or get off the boat while avoiding the hijackers.");
            nextBtn.setVisible(false);
            nextBtn2.setVisible(true);
        }
    }

    private static class StoryBtn2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            sitLabel.setText("There's a door with the label office. There may be something in there.");
            panel.remove(nextBtn2);
            panel.updateUI();
        }
    }

    private static class RadiosButtonListener1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (Op1.isSelected()) {
                Shrink();
            }
            if (Op2.isSelected()) {
                ShrinkPt2();
            }
            if (Op1Pt2.isSelected()) {
                ShrinkPt3();
            }
            if (Op2Pt2.isSelected()) {
                ShrinkPt4();
            }
            if (Op2Pt3.isSelected()) {
                ShrinkPt5();
            }

        }
    }


    public static void Shrink() {
        sitLabel.setText("It's locked. You need to find a key first.");
        op1Text.setText("Look for a key.");
        Op1.setVisible(false);
        Op1Pt2.setVisible(true);
    }

    public static void ShrinkPt2() {
        sitLabel.setText("You found a key. It might open the door.");
        op1Text.setText("Try to open the office door");
        op2Text.setText("Keep looking in the desk.");
        Op1.setVisible(false);
        Op1Pt2.setVisible(true);
        Op2.setVisible(false);
        Op2Pt2.setVisible(true);
    }

    public static void ShrinkPt3() {
        sitLabel.setText("You're in the office now. There's a window and what looks to be a broken radio.");
        op1Text.setText("Jump out the window.");
        op2Text.setText("Jake is an electrician. See if he can fix it.");
        Op1Pt3.setVisible(true);
        Op2Pt2.setVisible(false);
        Op2Pt3.setVisible(true);
    }

    public static void ShrinkPt4() {
        sitLabel.setText("You found a pack of smokes. You just wasted you time. Go open the door.");
        op2Text.setText("Unlock the office door");
        Op2Pt2.setVisible(true);
        Op2Pt2.setVisible(false);
        Op2Pt3.setVisible(true);
        Op1Pt3.setVisible(true);
    }

    public static void ShrinkPt5() {
        sitLabel.setText("You got saved and lived. That was too easy. If you jumped out the window you suck.");
        Op2Pt3.setVisible(false);
        Op1Pt3.setVisible(false);
        op1Text.setVisible(false);
        op2Text.setVisible(false);
    }

}








