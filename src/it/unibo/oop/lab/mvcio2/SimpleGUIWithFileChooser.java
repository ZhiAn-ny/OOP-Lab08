package it.unibo.oop.lab.mvcio2;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;

import it.unibo.oop.lab.mvcio.Controller;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    private final JFrame frame = new JFrame();
    private final Controller ctrl = new Controller();

    /*
     * TODO: Starting from the application in mvcio:
     * 
     * 4) When in the controller a new File is set, also the graphical interface
     * must reflect such change. Suggestion: do not force the controller to
     * update the UI: in this example the UI knows when should be updated, so
     * try to keep things separated.
     * 
     * I didn't force the controller to update the UI, did I?
     */

    public SimpleGUIWithFileChooser() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);

        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final JPanel browse = new JPanel();
        final JTextField browseField = new JTextField(ctrl.getFile().getName());
        browseField.setEditable(false);
        final JButton browseButton = new JButton("Browse...");
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser chooser = new JFileChooser();
                final var choice = chooser.showSaveDialog(chooser);
                if (choice == JFileChooser.APPROVE_OPTION) {
                    ctrl.setFile(chooser.getSelectedFile());
                    browseField.setText(ctrl.getFile().getName());
                } else if (choice != JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(browseButton, "An error has occurred.");
                }
            }
        });

        browse.setLayout(new BorderLayout());
        browse.add(browseField, BorderLayout.CENTER);
        browse.add(browseButton, BorderLayout.LINE_END);

        final JPanel main = new JPanel();
        final JTextArea text = new JTextArea();
        final JButton save = new JButton("Save");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                ctrl.saveToFile(text.getText());
            }
        });

        main.setLayout(new BorderLayout());
        main.add(browse, BorderLayout.NORTH);
        main.add(text, BorderLayout.CENTER);
        main.add(save, BorderLayout.SOUTH);

        frame.setContentPane(main);
        frame.setVisible(true);
    }

    /**
     * Displays the interface. 
     *
     * @param args are ignored.
     */
    public static void main(final String[] args) {
        new SimpleGUIWithFileChooser();
    }

}
