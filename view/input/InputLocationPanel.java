package commuteTime.view.input;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InputLocationPanel extends JPanel {

    private final JTextField departureField;
    private final JTextField destinationField;
    private final JTextField departureTimeField;

    public String getDeparture() {
        return departureField.getText();
    }

    public String getDestination() {
        return destinationField.getText();
    }

    public String getDepartureTime() {
        return departureTimeField.getText();
    }

    public InputLocationPanel() {
        setBorder(new EmptyBorder(15, 15, 15, 15));
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        departureField = new JTextField();
        destinationField = new JTextField();
        departureTimeField = new JTextField();

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.WHITE);
        topPanel.setBorder(new EmptyBorder(15, 90, 35, 90));
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));

        JLabel departureLabel = new JLabel("출발");
        departureLabel.setFont(new Font("NotoSans", Font.PLAIN, 17));
        departureLabel.setForeground(new Color(0x5F5F5F));
        topPanel.add(departureLabel);

        ImageIcon icon = new ImageIcon("../../images/exchangeIcon.png");
        Image scaledImage = icon.getImage().getScaledInstance(75, 35, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel iconLabel = new JLabel(scaledIcon);
        topPanel.add(Box.createHorizontalGlue());
        topPanel.add(iconLabel);
        topPanel.add(Box.createHorizontalGlue());

        JLabel destinationLabel = new JLabel("도착");
        destinationLabel.setFont(new Font("NotoSans", Font.PLAIN, 17));
        destinationLabel.setForeground(new Color(0x5F5F5F));
        topPanel.add(destinationLabel);

        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 15, 0));
        centerPanel.setBackground(Color.WHITE);
        departureField.setFont(new Font("NotoSans", Font.BOLD, 30));
        departureField.setText("수원역");
        departureField.setHorizontalAlignment(JTextField.CENTER);
        destinationField.setFont(new Font("NotoSans", Font.BOLD, 30));
        destinationField.setText("서울역");
        destinationField.setHorizontalAlignment(JTextField.CENTER);

        departureField.setBorder(null);
        destinationField.setBorder(null);

        centerPanel.add(departureField);
        centerPanel.add(destinationField);

        add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        JLabel departureTimeLabel = new JLabel("출발시간");
        departureTimeLabel.setFont(new Font("NotoSans", Font.PLAIN, 17));
        departureTimeLabel.setForeground(new Color(0x5F5F5F));
        departureTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        departureTimeLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(0xCCCCCC)),
                BorderFactory.createEmptyBorder(7, 0, 7, 0)
        ));
        bottomPanel.add(departureTimeLabel, BorderLayout.NORTH);

        // Add spacing between departureTimeLabel and departureTimeField
        bottomPanel.add(Box.createVerticalStrut(30), BorderLayout.CENTER);

        bottomPanel.add(Box.createVerticalStrut(30), BorderLayout.CENTER);

        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 (E) HH:mm");
        String currentDateTime = currentTime.format(formatter);
        departureTimeField.setFont(new Font("NotoSans", Font.BOLD, 20));
        departureTimeField.setText(currentDateTime);
        departureTimeField.setBorder(null);
        departureTimeField.setHorizontalAlignment(JTextField.CENTER);
        departureTimeField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(20, 0, 20, 0), // Add top and bottom margin of 20 pixels
                departureTimeField.getBorder()
        ));
        departureLabel.setBorder(null);
        bottomPanel.add(departureTimeField, BorderLayout.CENTER);

        JLabel durationLabel = new JLabel("왕복 약 3시간 30분 소요");
        durationLabel.setFont(new Font("NotoSans", Font.BOLD, 18));
        durationLabel.setForeground(new Color(0x5F5F5F));
        durationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bottomPanel.add(durationLabel, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);
    }
}



