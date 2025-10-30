import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class VisualPanel extends JPanel {
    private int[] array;
    private final int BAR_WIDTH = 10;
    private final int DELAY = 30;
    private int highlightedIndex = -1;
    
    public VisualPanel(){
        generateArray();
    }

    private void generateArray(){
        int size = getWidth() == 0 ? 80 : getWidth() / BAR_WIDTH;
        array = new int[size];
        Random rand = new Random();
        for(int i = 0; i < size; i++){
            array[i] = rand.nextInt(500) + 50;
        }
        
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        for (int i = 0; i < array.length; i++) {
            g.setColor(Color.RED);
            g.fillRect(i * BAR_WIDTH, getHeight() - array[i], BAR_WIDTH - 2, array[i]);
        }
    }

    public void highlightIndex(int index){
        highlightedIndex = index;
        repaint();
    }

    public void startSorting(){
       Sorter sorter = new Sorter(array, this, DELAY);
         sorter.bubbleSort();
    }

    
}
