import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame{
    private static MainWindow ourInstance = new MainWindow();

    public static MainWindow getInstance() {
        return ourInstance;
    }
//    public static Graphics graphics;
    private MainWindow() {
        super();
        this.setPreferredSize(new Dimension(500,500));
        this.setSize(this.getPreferredSize());
        this.setVisible(true);
        this.setResizable(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

    }

}
