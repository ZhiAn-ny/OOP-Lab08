package it.unibo.oop.lab.mvc;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private final ControllerImpl ctrl = new ControllerImpl();

    /**
     * builds a new {@link SimpleGUI}.
     */
    public SimpleGUI() {

        /*
         * Make the frame half the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected.
         * 
         * In order to deal coherently with multimonitor setups, other
         * facilities exist (see the Java documentation about this issue). It is
         * MUCH better than manually specify the size of a window in pixel: it
         * takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);

        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final JPanel pan = new JPanel();
        pan.setLayout(new BorderLayout());

        final JTextField field = new JTextField();
        final JTextArea text = new JTextArea();
        text.setEditable(false);
        final JButton print = new JButton("Print");
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    ctrl.setNextString(field.getText());
                    ctrl.printString();
                    field.setText("");
                } catch (IllegalStateException e1) {
                    JOptionPane.showMessageDialog(pan, e1.getMessage());
                } catch (IllegalArgumentException e2) {
                    JOptionPane.showMessageDialog(pan, e2.getMessage());
                }
            }
        });
        final JButton history = new JButton("Show history");
        history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                text.setText("");
                final List<String> h = ctrl.getStringHistory();
                for (final String str : h) {
                    text.append(str + "\n");
                }
            }
        });

        final JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
        buttons.add(print);
        buttons.add(history);

        pan.add(field, BorderLayout.NORTH);
        pan.add(text, BorderLayout.CENTER);
        pan.add(buttons, BorderLayout.SOUTH);

        frame.setContentPane(pan);
        frame.setVisible(true);
    }

    /**
     * Starts the graphical application.
     * 
     * @param args are ignored
     */
    public static void main(final String[] args) {
        new SimpleGUI();
    }

}
