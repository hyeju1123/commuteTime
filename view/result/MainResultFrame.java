package commuteTime.view.result;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainResultFrame extends JFrame {

    ExchangeResultPanel exchangeResultPanel;
    PieChartPanel pieChartPanel;
    ResetButtonPanel resetButtonPanel;

    public MainResultFrame() {
        setTitle("이동 비용 계산기");
        setSize(500, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        exchangeResultPanel = new ExchangeResultPanel();
        contentPane.add(exchangeResultPanel, BorderLayout.NORTH);

        pieChartPanel = new PieChartPanel();
        contentPane.add(pieChartPanel, BorderLayout.CENTER);

        resetButtonPanel = new ResetButtonPanel();
        contentPane.add(resetButtonPanel, BorderLayout.SOUTH);

//        setVisible(true);
    }
    public void createResultFrame(){
        exchangeResultPanel.showResult();
    }
    public void setDeparture(String departure){
        exchangeResultPanel.setDeparture(departure);
    }
    public void setDestination(String destination){
        exchangeResultPanel.setDestination(destination);
    }
    public void setCommuteCost(int cost){
        exchangeResultPanel.setCommuteCost(cost);
    }
    public void setFare(int fare){
        exchangeResultPanel.setFare(fare);
    }

}
