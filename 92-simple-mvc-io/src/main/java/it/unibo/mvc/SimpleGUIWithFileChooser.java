package it.unibo.mvc;

import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUIWithFileChooser {
    public static final int PROPORTION = 5;

    private final JFrame frame = new JFrame("My second java graphical interface");

    /**
     * Create a new GUI.
     * 
     * @param controller the controller instance
     */
    public SimpleGUIWithFileChooser(final Controller controller) {
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        final JTextArea areaDiTesto = new JTextArea();
        panel1.add(areaDiTesto);
        final JButton buttonSave = new JButton("Save");
        panel1.add(buttonSave, BorderLayout.SOUTH);
        buttonSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.saveString(areaDiTesto.getText());
                } catch (final IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        final JTextField textField = new JTextField(controller.getCurrentFilePath());
        textField.setEditable(false);
        final JButton browse = new JButton("Browse");
        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fc = new JFileChooser("Choose where to save");
                fc.setSelectedFile(controller.getCurrentFile());
                final int n = fc.showSaveDialog(frame);
                if (n == JFileChooser.APPROVE_OPTION) {
                    final File newDest = fc.getSelectedFile();
                    controller.setDestination(newDest);
                } else if (n != JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(frame, n, "Errore qui", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel2.add(textField, BorderLayout.CENTER);
        panel2.add(browse, BorderLayout.LINE_END);
        panel1.add(panel2, BorderLayout.NORTH);
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.pack();
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
        new SimpleGUIWithFileChooser(control).display();
    }
}
