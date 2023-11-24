package home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

//Head
class HeadPanel extends JPanel {
    JLabel jtime, battery, wifi;
    Date time;
    SimpleDateFormat formatter;
    Timer timer;
    ImageIcon battery_icon, wifi_icon;
    Image battery_img, wifi_img;
    public HeadPanel(){
        setLayout(null);
        setSize(500,50);
        setBackground(Color.gray);
        //시간
        time = new Date();
        formatter = new SimpleDateFormat("HH:mm");
        String formatedNow = formatter.format(time);
        jtime = new JLabel(formatedNow);
        jtime.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
        jtime.setBounds(10, 5, 70, 30);
        add(jtime);

        //배터리 이미지
        battery_icon = new ImageIcon("src/home/icon/battery.png");
        battery_img = battery_icon.getImage();
        battery_img = battery_img.getScaledInstance(50,30,Image.SCALE_SMOOTH);
        battery_icon = new ImageIcon(battery_img);
        battery = new JLabel(battery_icon);
        battery.setBounds(427,5, 50, 30);
        add(battery);

        //와이파이 이미지
        wifi_icon = new ImageIcon("src/home/icon/wifi.png");
        wifi_img = wifi_icon.getImage();
        wifi_img = wifi_img.getScaledInstance(35,30,Image.SCALE_SMOOTH);
        wifi_icon = new ImageIcon(wifi_img);
        wifi = new JLabel(wifi_icon);
        wifi.setBounds(384,5, 40, 30);
        add(wifi);

        //시간 동기화
        timer = new Timer(1000, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 time = new Date();
                 String formatedNow = formatter.format(time);
                 jtime.setText(formatedNow);
             }
        });
        timer.start();
        setVisible(true);
    }
}

/**
 * 백연동 코드 구현 필요
 */
//Foot
class FootPanel extends JPanel{
    JLabel home_label, mypage_label, setting_label;
    ImageIcon home_icon, mypage_icon, setting_icon;
    Image home_img, mypage_img, setting_img;

    public FootPanel(){
        setSize(500, 120);
        setBackground(Color.cyan);
        setLayout(null);
        //홈아이콘
        home_icon = new ImageIcon("src/home/icon/home.png");
        home_img = home_icon.getImage();
        home_img = home_img.getScaledInstance(70 ,70,Image.SCALE_SMOOTH);
        home_icon = new ImageIcon(home_img);
        home_label = new JLabel(home_icon);
        home_label.setBounds(20,10, 70, 70);
        add(home_label);
        //마이페이지아이콘
        mypage_icon = new ImageIcon("src/home/icon/person.png");
        mypage_img = mypage_icon.getImage();
        mypage_img = mypage_img.getScaledInstance(70,70,Image.SCALE_SMOOTH);
        mypage_icon = new ImageIcon(mypage_img);
        mypage_label = new JLabel(mypage_icon);
        mypage_label.setBounds(215,10, 70, 70);
        add(mypage_label);
        //셋팅아이콘
        setting_icon = new ImageIcon("src/home/icon/setting.png");
        setting_img = setting_icon.getImage();
        setting_img = setting_img.getScaledInstance(70,70,Image.SCALE_SMOOTH);
        setting_icon = new ImageIcon(setting_img);
        setting_label = new JLabel(setting_icon);
        setting_label.setBounds(395,10, 70, 70);
        add(setting_label);
        setVisible(true);

        //TO DO : 코드 구현 필요
        home_label.addMouseListener(new MouseAdapter() {});
        mypage_label.addMouseListener(new MouseAdapter() {});
        setting_label.addMouseListener(new MouseAdapter() {});

    }

}

//Body
//홈 화면
class HomePanel extends JPanel {
    public HomePanel(){
        setSize(500,735);
        setLayout(null);
        SearchPanel search_panel = new SearchPanel();
        search_panel.setBounds(0,0,500,135);

        ListPanel list_panel = new ListPanel();
        list_panel.setBounds(0,135,500,600
        );
    }
}
class SearchPanel extends JPanel{

}
class ListPanel extends JPanel{

}


//상품 화면
class ProductPanel extends JPanel {}
//마이페이지 화면
class MypagePanel extends JPanel {}
//설정 화면
class SettingPanel extends JPanel {}


public class ApplicationMain extends JFrame{
    public ApplicationMain(){
        setLayout(null);
        setTitle("CP2-ShoppingMall");
        setSize(500,900);

        HeadPanel headPanel = new HeadPanel();
        headPanel.setBounds(0,0,500,45);
        add(headPanel);

        FootPanel footPanel = new FootPanel();
        footPanel.setBounds(0,770,500,100);
        add(footPanel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ApplicationMain();
        System.out.println("Hello world!");
    }
}