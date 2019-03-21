import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Main { // bazi e dooz !

    static MainWindow mainWindow;
    static  MainPanel panel;
    static MyButton[] buttons = new MyButton[9];
    public static JButton makeButton(int id)
    {
        buttons[id] = new MyButton();
        return  buttons[id];
    }

    public static void  main(String[] args)
    {
        mainWindow = MainWindow.getInstance();
        int NumberOfButtons = 9;
        mainWindow.setLayout(null);
        panel = MainPanel.getInstance();
//        mainWindow.add(panel);

        for (int i = 0 ; i < NumberOfButtons ; i ++)
        {
            mainWindow.add(makeButton(i));
//            mainWindow.getContentPane().getComponent(i).setVisible(true);
        }

        mainWindow.repaint();
        mainWindow.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                for (int i = 0 ; i < mainWindow.getContentPane().getComponentCount() ; i ++){
                    if (mainWindow.getContentPane().getComponent(i) instanceof MyButton){
                        try {
                            ((MyButton) mainWindow.getContentPane().getComponent(i)).UPDATE();
                        }
                        catch(Exception E){
                            E.printStackTrace();
                        }
                    }
                }
            }
        });
    }

}
