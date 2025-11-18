package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {

    public static final int PROPORTION = 5;
    private final JFrame frame = new JFrame("My frame");

    /**
     * Builds the application GUI.
     * 
     * @param ctrl the controller instance
     */
    public SimpleGUI(final Controller ctrl) {
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        final JTextArea areaDiTesto = new JTextArea();
        panel.add(areaDiTesto);
        final JButton buttonSave = new JButton("Save");
        panel.add(buttonSave, BorderLayout.SOUTH);
        buttonSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    ctrl.saveString(areaDiTesto.getText());
                } catch (final IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.pack();
    }

    private void display() {
        frame.setVisible(true);
    }

    /**
     * Launches the application.
     *
     * @param args
     *            unused
     */
    public static void main(final String[] args) {
        final Controller control = new Controller();
        new SimpleGUI(control).display();
    }
}
