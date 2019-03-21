import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private static MainPanel ourInstance = new MainPanel();

    public static MainPanel getInstance() {
        return ourInstance;
    }

    private MainPanel() {
        this.setVisible(true);
        this.setPreferredSize(new Dimension(500,500));
        this.setSize(this.getPreferredSize());


    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

    }


}
