public class Sorter {
    private int[] array;
    private VisualPanel panel;
    private int delay;

    public Sorter(int[] array, VisualPanel panel, int delay) {
        this.array = array;
        this.panel = panel;
        this.delay = delay;
    }


    public void bubbleSort(){
        //  Bubble Sort Visualization
        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

                panel.repaint();
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        panel.highlightIndex(-1); // Clear highlight after sorting
        panel.repaint();
    }
}
