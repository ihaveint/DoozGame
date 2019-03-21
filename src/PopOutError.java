import javax.swing.*;

public class PopOutError {
    public PopOutError(){
        JOptionPane.showMessageDialog(MainWindow.getInstance(),"this area is clicked before , select another area","error",JOptionPane.ERROR_MESSAGE);
    }

}
