import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyButton extends JButton  {
    int id;
    static int counter = 0;
    static int turn = 0 ;
    boolean clicked = false;
    boolean type = false;
    public MyButton()
    {
        id = counter;
        counter ++;

        int satr = id/3;
        int sotoon = id%3;
        int X = sotoon * MainWindow.getInstance().getWidth()/3;
        int Y = satr * MainWindow.getInstance().getHeight()/3;
        this.setLocation(X,Y);
        this.setSize(MainWindow.getInstance().getWidth()/3,MainWindow.getInstance().getHeight()/3);
        this.addActionListener(e -> {
            if (getText()  != ""){
                new PopOutError();
                return ;
            }
            System.out.println("hey there");


            clicked = true;

            if (turn == 0){
                setText("X");
                type = false;

            }else {
                setText("O");
                type = true;
            }
            turn ^= 1;
            checkForWinner();
        });


    }
    public void UPDATE(){
        int satr = id/3;
        int sotoon = id%3;
        int X = sotoon * MainWindow.getInstance().getWidth()/3;
        int Y = satr * MainWindow.getInstance().getHeight()/3;
        this.setLocation(X,Y);
        this.setSize(MainWindow.getInstance().getWidth()/3,MainWindow.getInstance().getHeight()/3);
    }
    public void declareWinner(boolean type)
    {
        if (type == false){
            JOptionPane.showMessageDialog(MainWindow.getInstance(),"the winner is X","game over",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(MainWindow.getInstance(),"the winner is O","game over",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void checkForWinner()
    {
        for (int i = 0 ; i < 3 ; i ++){
            boolean fl = true;
            for (int j =  3 * i ; j < 3 * i + 3 ; j ++){
                fl &= Main.buttons[j].clicked;
                fl &= (j == 3 * i) || (Main.buttons[j].type == Main.buttons[j-1].type);
            }
            if (fl ){
                declareWinner(Main.buttons[3*i].type);
            }


            fl = true;
            for (int row = 0 ; row < 3 ; row ++){
                fl &= Main.buttons[row*3+i].clicked;
                fl &= (row == 0) || (Main.buttons[(row-1)*3+i].type == Main.buttons[row*3 + i].type);

            }
            if (fl){
                declareWinner(Main.buttons[i].type);
            }

        }
        boolean fl = true;
        for (int i = 0 ; i < 3 ; i ++){
            fl &= Main.buttons[3*i+i].clicked;
            fl &= (i == 0 )|| (Main.buttons[3*i+i].type == Main.buttons[3*(i-1)+(i-1)].type);
        }


        if (fl)
            declareWinner(Main.buttons[0].type);

        fl = true;
        for (int i = 0 ; i < 3 ; i ++){
            fl &= Main.buttons[3*i+2-i].clicked;
            fl &= (i == 0 )|| (Main.buttons[3*i+2-i].type  == Main.buttons[3*(i-1)+2-(i-1)].type);

        }
        if (fl)
            declareWinner(Main.buttons[2].type);
    }



}
