package home;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

//Head
class TopBarPanel extends JPanel {
    JLabel jtime, battery, wifi;
    Date time;
    SimpleDateFormat formatter;
    Timer timer;
    ImageIcon battery_icon, wifi_icon;
    Image battery_img, wifi_img;
    public TopBarPanel(){
        setLayout(null);
        setSize(500,50);
        setBackground(new Color(241, 241, 241));
        //시간
        time = new Date();
        formatter = new SimpleDateFormat("HH:mm:ss");
        String formatedNow = formatter.format(time);
        jtime = new JLabel(formatedNow);
        jtime.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        jtime.setBounds(10, 5, 100, 30);
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

class ListPanel extends JPanel{
    //TODO 데이터와 연결할 때, 밑에 배열 처리한 데이터를 List<String> 이런식으로 바꾸시면 될 듯
    String[] temporary_title = {
            "아이폰15", "캡 모자(흰색,회색,검정색)", "갤럭시탭S9 플러스", "겨울 히터기", "멀티탭", "말차 쿠키 로켓프레시"
    };
    String[] temporary_money = {
            "1,000,000", "5,000", "950,000", "80,000", "12,000", "10,000"
    };
    JLabel[] temporary_title_lables;
    JLabel[] temporary_file_labels;
    ImageIcon[] temporary_icons;
    Image[] temporary_imgs;
    JPanel[] temporary_products;
    JButton pre, next;
    int row, column;
    public ListPanel(){
        setSize(500,700);
        setLayout(null);

        temporary_products = new JPanel[temporary_title.length];
        temporary_icons = new ImageIcon[temporary_title.length];
        temporary_imgs = new Image[temporary_title.length];
        temporary_file_labels = new JLabel[temporary_title.length];
        //각 패널에 상품 배정 (화면에 4개씩 끊어서 보여줍시다.. 스크롤 기능 노력해봤는데 실패함)
        for(int i=0; i<4; i++){
            temporary_products[i] = new JPanel();
            temporary_products[i].setSize(250,325);
            temporary_products[i].setLayout(null);
            //상품 이미지
            temporary_icons[i] = new ImageIcon("src/home/product/"+(i+1)+".png");
            temporary_imgs[i] = temporary_icons[i].getImage();
            temporary_imgs[i] = temporary_imgs[i].getScaledInstance(250,250,Image.SCALE_SMOOTH);
            temporary_icons[i] = new ImageIcon(temporary_imgs[i]);
            temporary_file_labels[i] = new JLabel(temporary_icons[i]);
            temporary_file_labels[i].setBounds(0,0, 250, 250);
            //패널에 이미지 추가
            temporary_products[i].add(temporary_file_labels[i]);
            //패널에 제목 추가
            JLabel title = new JLabel(temporary_title[i]);
            title.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
            title.setBounds(10,250,250,35);
            temporary_products[i].add(title);
            //패널에 가격 추가
            JLabel pay = new JLabel(temporary_money[i]);
            pay.setFont(new Font("맑은 고딕", Font.BOLD, 20));
            pay.setBounds(10,280,250,35);
            temporary_products[i].add(pay);

            temporary_products[i].setVisible(true);
            //List패널에 상품패널추가
            row = i/2; //상품이 1행,2행,3행... 이런식으로 나열되기 위해 만든 코드
            column = i%2;
            temporary_products[i].setBounds((250*row), (320*column), 250,320);
            add(temporary_products[i]);
        }

        //상품 목록 다음 페이지
        pre = new JButton("◀");
        pre.setBounds(10,640,50,50);
        pre.setBackground(Color.white);
        next = new JButton("▶");
        next.setBounds(420,640,50,50);
        next.setBackground(Color.white);
        add(pre);
        add(next);

        //TODO 버튼 액션리스너 추가
        //pre.addActionListener();
        //next.addActionListener();

        setVisible(true);

    }
}

/**
 * 상품페이지 화면
 */
class ProductPanel extends JPanel{

    ImageIcon product_icon;
    Image product_img;
    JLabel product_img_label, product_title_label, product_price_label;
    JButton basket_btn, buy_btn;
    JPanel buy_panel;

    public ProductPanel(){
        setLayout(null);
        setSize(500,900);
        setBackground(new Color(241,241,241));

        //로고 패널


        //검색 패널
        SearchPanel search_panel = new SearchPanel();
        search_panel.setBounds(0,0,500,70);
        add(search_panel);

        //TODO 서버 연결시 수정해야 할 부분
        //상품 사진
        product_icon = new ImageIcon("src/home/product/3.png");
        product_img = product_icon.getImage();
        product_img = product_img.getScaledInstance(400,400, Image.SCALE_SMOOTH);
        product_icon = new ImageIcon(product_img);
        product_img_label = new JLabel(product_icon);
        product_img_label.setBounds(40,90,400,400);
        add(product_img_label);

        //TODO 서버 연결시 수정해야 할 부분
        //구매 패널
        buy_panel = new JPanel();
        buy_panel.setLayout(null);
        buy_panel.setBackground(new Color(217,217,217));
        buy_panel.setBounds(0,530,500,400);

        product_title_label = new JLabel("갤럭시탭S9 플러스");
        product_title_label.setFont(new Font("맑은고딕", Font.BOLD, 24));
        product_title_label.setForeground(new Color(100,100,100));
        product_title_label.setBounds(20, 40, 250,30);
        buy_panel.add(product_title_label);

        product_price_label = new JLabel("950,000");
        product_price_label.setFont(new Font("맑은고딕", Font.BOLD, 34));
        product_price_label.setForeground(new Color(100,100,100));
        product_price_label.setBounds(20,65,250,60);
        buy_panel.add(product_price_label);

        basket_btn = new JButton("장바구니 담기");
        basket_btn.setBackground(new Color(78,78,78));
        basket_btn.setForeground(Color.white);
        basket_btn.setBounds(270,45,190,60);
        basket_btn.setFont(new Font("맑은 고딕",Font.BOLD,24));
        buy_panel.add(basket_btn);


        buy_btn = new JButton("구매하기");
        buy_btn.setBackground(new Color(46,46,46));
        buy_btn.setForeground(Color.white);
        buy_btn.setFont(new Font("맑은 고딕", Font.BOLD, 37));
        buy_btn.setBounds(20,130,450,90);
        buy_panel.add(buy_btn);

        add(buy_panel);
        setVisible(true);

        //TODO 장바구니, 구매하기 버튼에 addActionListener 추가하기


    }


}
//마이페이지 화면
class MypagePanel extends JPanel {}
//설정 화면 (회원가입 및 로그인)
class SettingPanel extends JPanel {}
//상품주문페이지 화면
class BuyPanel extends JPanel {}
//회원가입 페이지




public class ApplicationMain extends JFrame{
    public ApplicationMain(){
        setLayout(null);
        setTitle("CP2-ShoppingMall");
        setSize(500,1020);
        //헤더
        TopBarPanel topbar_panel = new TopBarPanel();
        topbar_panel.setBounds(0,0,500,45);
        add(topbar_panel);
        //로고
        LogoPanel logo_panel = new LogoPanel();
        logo_panel.setBounds(0,45,500,90);
        add(logo_panel);
        /**
         * 바디 부분만
         * HomePanel
         * ProductPanel
         * MypagePanel
         * SettingPanel
         * 로 갈아끼시면 뷰를 다양하게 보실 수 있습니다
         */
        //바디
        //1. HomePanel
        HeadPanel head_panel = new HeadPanel();
        head_panel.setBounds(0,130,500,765);
        add(head_panel);
        //2. ProductPanel
//        ProductPanel product_panel = new ProductPanel();
//        product_panel.setBounds(0,45,500,765);
//        add(product_panel);
        //푸터
        FootPanel foot_panel = new FootPanel();
        foot_panel.setBounds(0,900,500,100);
        add(foot_panel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ApplicationMain();
        System.out.println("Hello world!");
    }
}