import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ivan on 10.11.2017.
 */
public class CodecGUI extends JFrame implements ActionListener{

    public static void main(String[] args) {

        CodecGUI a = new CodecGUI();

    }

    private Container c;
    private JLabel text;
    private JButton button1;
    private JTextField text1;
    private JTextArea area1, area2;

    private CodecGUI() {
        c = getContentPane();
        c.setLayout(null);
        this.setSize(300, 300);

        text =  new JLabel("Text zum kodieren eingeben: ");
        button1 = new JButton("kodiere");
        area1 = new JTextArea();
        area2 = new JTextArea();
        text1 = new JTextField();

        text.setBounds(60, 30, 180, 30);
        text1.setBounds(60, 60, 130, 30);
        area1.setBounds(60, 100, 150, 15);
        area2.setBounds(60, 120, 150, 15);
        button1.setBounds(60, 150, 120, 30);

        c.add(area1);
        c.add(area2);
        c.add(text);
        c.add(button1);
        button1.addActionListener(this);
        c.add(text1);

        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1) {
            String name = text1.getText();
            JOptionPane.showMessageDialog(null, "Hello " + name);
        }
    }
}
