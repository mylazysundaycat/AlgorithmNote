package home;

import javax.swing.*;
import java.awt.*;

class LogoPanel extends JPanel {
    JLabel logo_label;
    ImageIcon logo_icon;
    Image logo_img;

    public LogoPanel(){
        setLayout(null);
        setBackground(Color.white);
        //로고
        logo_icon = new ImageIcon("src/home/icon/logo.png");
        logo_img = logo_icon.getImage();
        logo_img = logo_img.getScaledInstance(230,60,Image.SCALE_SMOOTH);
        logo_icon = new ImageIcon(logo_img);
        logo_label = new JLabel(logo_icon);
        logo_label.setBounds(120,20, 230, 60);
        add(logo_label);

    }
}