package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 *
 */

public final class SimpleGUI {
    private static final int PROPORTION = 5;

    private final JFrame frame = new JFrame();
    private final Controller control = new SimpleController();

    /**
     * to set the GUI.
     * 
     * @param control the controller implemented
     */
    public SimpleGUI(final Controller control) {
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        final JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.LINE_AXIS));
        final JTextField textField = new JTextField("Text Field");
        final JTextArea textArea = new JTextArea();
        final JButton print = new JButton("Print");
        final JButton showHistory = new JButton("Show Histrory");
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(textField, BorderLayout.NORTH);
        southPanel.add(print);
        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                SimpleGUI.this.control.setNextStringToPrint(textField.getText());
                SimpleGUI.this.control.printCurrentString();
            }

        });
        southPanel.add(showHistory);
        showHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final StringBuilder text = new StringBuilder();
                final List<String> history = SimpleGUI.this.control.getHistoryOfPrintedStrings();
                for (final String print: history) {
                    text.append(print).append('\n');
                }
                if (!history.isEmpty()) {
                    text.deleteCharAt(text.length() - 1);
                }
                textArea.setText(text.toString());
            }
        });
        panel.add(southPanel, BorderLayout.SOUTH);
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * to set the display.
     */
    public void display() {
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * to run the application.
     * 
     * @param args unused
     */
    public static void main(final String[] args) {
        new SimpleGUI(new SimpleController()).display();
    }

}
