package home;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;

//Body
//홈 화면
class HeadPanel extends JPanel {
    public HeadPanel(){
        setSize(500, 900);
        setBackground(Color.white);
        setLayout(null);
        //검색 패널
        SearchPanel search_panel = new SearchPanel();
        search_panel.setBounds(0,0,500,70);
        add(search_panel);
        //상품리스트 패널
        ListPanel list_panel = new ListPanel();
        list_panel.setBounds(0,70,500,800);
        add(list_panel);
        setVisible(true);
    }
}
class SearchPanel extends JPanel{
    JLabel search_label, basket_label;
    ImageIcon search_icon, basket_icon;
    Image search_img, basket_img;
    JTextField search_txt;
    public SearchPanel(){
        setBackground(Color.white);
        setSize(500,135);
        setLayout(null);
        //검색아이콘
        search_icon = new ImageIcon("src/home/icon/search.png");
        search_img = search_icon.getImage();
        search_img = search_img.getScaledInstance(50,55,Image.SCALE_SMOOTH);
        search_icon = new ImageIcon(search_img);
        search_label = new JLabel(search_icon);
        search_label.setBounds(350,10, 55, 55);
        add(search_label);
        //장바구니아이콘
        basket_icon = new ImageIcon("src/home/icon/basket.png");
        basket_img = basket_icon.getImage();
        basket_img = basket_img.getScaledInstance(50, 55, Image.SCALE_SMOOTH);
        basket_icon = new ImageIcon(basket_img);
        basket_label = new JLabel(basket_icon);
        basket_label.setBounds(410, 10, 55, 55);
        add(basket_label);
        //검색창
        search_txt = new JTextField(30);
        search_txt.setBackground(new Color(167,184,184));
        search_txt.setBounds(100,10,230,50);
        search_txt.setFont(new Font("맑은고딕",Font.PLAIN,24));
        search_txt.setBorder(new LineBorder(new Color(167,184,184)));
        add(search_txt);

        //TODO 코드 구현 필요. 검색/장바구니 데이터연결
        search_label.addMouseListener(new MouseAdapter() {});
        basket_label.addMouseListener(new MouseAdapter() {});

        setVisible(true);
    }
}