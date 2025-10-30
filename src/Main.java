import javax.swing.*;
import java.awt.*;

public class Main{
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Algorithm Visualiser");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setResizable(false);

            VisualPanel panel = new VisualPanel();
            frame.add(panel, BorderLayout.CENTER);

            JButton startButton = new JButton("Start");
            startButton.addActionListener(e -> new Thread(() -> panel.startSorting()).start());
            frame.add(startButton, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }
}