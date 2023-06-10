package commuteTime.view.result;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ExchangeResultPanel extends JPanel {

    public ExchangeResultPanel() {
        setBorder(new EmptyBorder(15, 15, 15, 15));
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("검색결과");
        titleLabel.setForeground(Color.decode("#5F5F5F"));
        titleLabel.setFont(new Font("NotoSans", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(new EmptyBorder(0, 0, 20, 0)); // 하단에 20px의 패딩 추가
        add(titleLabel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(0xCCCCCC))); // 하단에 1px 두께의 테두리 추가
        bottomPanel.setBackground(Color.WHITE); // 배경색 설정
        add(bottomPanel, BorderLayout.CENTER); // 컨테이너 중앙에 배치

        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        infoPanel.setBackground(Color.WHITE);
        bottomPanel.add(infoPanel, BorderLayout.NORTH); // 정보 패널을 상단에 배치

        JLabel startLabel = new JLabel("수원역");
        startLabel.setFont(new Font("NotoSans", Font.BOLD, 18));
        startLabel.setBorder(new EmptyBorder(20, 0, 40, 20));
        infoPanel.add(startLabel); // 시작지점 레이블 추가

        ImageIcon imageIcon = new ImageIcon("../../images/exchangeWithoutBorder.png"); // 이미지 파일 경로에 실제 파일의 경로를 입력해야 합니다.
        Image scaledImage = imageIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBorder(new EmptyBorder(20, 0, 40, 0));
        infoPanel.add(imageLabel); // 이미지 레이블 추가

        JLabel endLabel = new JLabel("서울역");
        endLabel.setFont(new Font("NotoSans", Font.BOLD, 18));
        endLabel.setBorder(new EmptyBorder(20, 20, 40, 0));
        infoPanel.add(endLabel); // 도착지점 레이블 추가

        JPanel pricePanel = new JPanel(new BorderLayout());
        pricePanel.setBackground(Color.WHITE);
        bottomPanel.add(pricePanel, BorderLayout.CENTER); // 가격 패널을 중앙에 배치

        JLabel priceLabel = new JLabel("<html><div style='text-align: center;'>시간을 돈으로 환산하면<br><font color='#000000'><b>42,000원</b></font> 입니다.</div></html>");
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        priceLabel.setBorder(new EmptyBorder(0, 0, 20, 0));
        priceLabel.setFont(new Font("NotoSans", Font.PLAIN, 30));
        priceLabel.setForeground(Color.decode("#5F5F5F"));
        pricePanel.add(priceLabel, BorderLayout.CENTER); // 가격 레이블 추가

        JPanel additionalPanel = new JPanel(new GridBagLayout()); // 추가 패널에 GridBagLayout 사용
        additionalPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(0xCCCCCC))); // 하단에 1px 두께의 테두리 추가
        additionalPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER; // 라벨들을 수직 중앙 정렬
        gbc.insets = new Insets(5, 0, 5, 0); // 위 아래 간격 조절

        JLabel monthlyExpenseLabel = new JLabel("한 달 교통비");
        monthlyExpenseLabel.setFont(new Font("NotoSans", Font.PLAIN, 15));
        monthlyExpenseLabel.setBorder(new EmptyBorder(20, 0, -3, 0));
        monthlyExpenseLabel.setForeground(Color.decode("#5F5F5F"));
        gbc.gridy = 0; // 첫 번째 행에 배치
        additionalPanel.add(monthlyExpenseLabel, gbc);

        JLabel multiplyLabel = new JLabel("x");
        multiplyLabel.setFont(new Font("NotoSans", Font.PLAIN, 15));
        multiplyLabel.setBorder(new EmptyBorder(-5, 0, -5, 0));
        multiplyLabel.setForeground(Color.decode("#5F5F5F"));
        gbc.gridy = 1; // 두 번째 행에 배치
        additionalPanel.add(multiplyLabel, gbc);

        JLabel timeValueLabel = new JLabel("한 달 시간가치");
        timeValueLabel.setFont(new Font("NotoSans", Font.PLAIN, 15));
        timeValueLabel.setBorder(new EmptyBorder(-5, 0,0,0));
        timeValueLabel.setForeground(Color.decode("#5F5F5F"));
        gbc.gridy = 2; // 세 번째 행에 배치
        additionalPanel.add(timeValueLabel, gbc);

        gbc.insets = new Insets(10, 0, 0, 0); // 위쪽 간격 조절

        JLabel totalLabel = new JLabel("총 852,020원");
        totalLabel.setFont(new Font("NotoSans", Font.BOLD, 35));
        totalLabel.setBorder(new EmptyBorder(0, 0, 20, 0));
        totalLabel.setForeground(Color.decode("#333333"));
        gbc.gridy = 3; // 네 번째 행에 배치
        additionalPanel.add(totalLabel, gbc);

        bottomPanel.add(additionalPanel, BorderLayout.SOUTH); // 추가 패널을 하단에 배치
    }
}
