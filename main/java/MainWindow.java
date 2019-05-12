import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;
import java.lang.*;
import javax.swing.Timer;


class MainWindow extends JFrame {
    private JPanel panelMain;
    private JButton ButtonClick;
    double randomWidth;
    double randomHeight;
    Timer timer;
    boolean b;
    int ver = 0;

    MainWindow() {
        super();

        this.setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()), (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
        this.setTitle("Klikaj mnie!");
        this.setUndecorated(true);
        this.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        this.setContentPane(panelMain);

        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {



                if (ver ==1) {

                if(ButtonClick.getLocation().x > randomWidth) {
                    ButtonClick.setBounds(ButtonClick.getLocation().x - (int)((ButtonClick.getLocation().x - randomWidth)/10), ButtonClick.getLocation().y + (int)((randomHeight - ButtonClick.getLocation().y )/10), 100, 50);
                }
                else
                {
                    timer.stop();
                }
            } else if (ver ==2) {
                if(ButtonClick.getLocation().x > randomWidth)
                {
                    ButtonClick.setBounds(ButtonClick.getLocation().x - (int)((ButtonClick.getLocation().x - randomWidth)/10)  , ButtonClick.getLocation().y - (int)((  ButtonClick.getLocation().y - randomHeight)/10), 100, 50);
                }
                else
                {
                    timer.stop();
                }
            } else if (ver ==3) {
                if(ButtonClick.getLocation().x < randomWidth) {
                    ButtonClick.setBounds(ButtonClick.getLocation().x + (int)(( randomWidth - ButtonClick.getLocation().x )/10), ButtonClick.getLocation().y - (int)((  ButtonClick.getLocation().y - randomHeight)/10), 100, 50);
                }
                else
                {
                    timer.stop();
                }
            } else if (ver ==4) {
                if(ButtonClick.getLocation().x < randomWidth)
                {
                    ButtonClick.setBounds(ButtonClick.getLocation().x + (int)(( randomWidth - ButtonClick.getLocation().x )/10)  , ButtonClick.getLocation().y + (int)((randomHeight - ButtonClick.getLocation().y )/10), 100, 50);
                }
                else
                {
                    timer.stop();
                }
            }

        }
        });


        ButtonClick.setOpaque(true);
        ButtonClick.setBounds((int)randomWidth, (int)randomHeight, 100, 50);
        ButtonClick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomWidth = Math.random();
                randomHeight = Math.random();
                randomWidth = randomWidth * (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 100);
                randomHeight = randomHeight * (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 100);


                if (ButtonClick.getX() - randomWidth > 0 && ButtonClick.getY() - randomHeight < 0) {

                    ver = 1;
                } else if (ButtonClick.getX() - randomWidth > 0 && ButtonClick.getY() - randomHeight > 0) {
                    ver = 2 ;
                } else if (ButtonClick.getX() - randomWidth < 0 && ButtonClick.getY() - randomHeight > 0) {
                    ver = 3 ;
                } else if (ButtonClick.getX() - randomWidth < 0 && ButtonClick.getY() - randomHeight < 0) {
                    ver = 4;

                }

                timer.start();


            }
        });




}
    }