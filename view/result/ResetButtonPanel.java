package commuteTime.view.result;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class ResetButtonPanel extends JPanel {
    JButton searchAgainButton;
    JButton resetButton;

    public ResetButtonPanel() {
        setBorder(new EmptyBorder(10, 0, 0, 0));
        setBackground(Color.WHITE);

        searchAgainButton = new JButton("재검색");
        searchAgainButton.setFont(new Font("NotoSans", Font.BOLD, 18));
        searchAgainButton.setPreferredSize(new Dimension(130, 50));
        searchAgainButton.setBackground(Color.decode("#EDEDED"));
        searchAgainButton.setFocusPainted(false);
        searchAgainButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        searchAgainButton.setUI(new RoundedButtonUI());

        resetButton = new JButton("초기화면");
        resetButton.setFont(new Font("NotoSans", Font.BOLD, 18));
        resetButton.setPreferredSize(new Dimension(130, 50));
        resetButton.setBackground(Color.decode("#EDEDED"));
        resetButton.setFocusPainted(false);
        resetButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        resetButton.setUI(new RoundedButtonUI());

        JPanel buttonContainer = new JPanel(new GridBagLayout());
        buttonContainer.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 15, 0, 15);
        buttonContainer.add(searchAgainButton, gbc);
        gbc.gridx = 1;
        buttonContainer.add(resetButton, gbc);

        add(buttonContainer);
    }

    public JButton getSearchAgainButton() {
        return searchAgainButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    private static class RoundedButtonUI extends BasicButtonUI {
        private static final int BORDER_RADIUS = 50;

        @Override
        protected void installDefaults(AbstractButton button) {
            super.installDefaults(button);
            button.setOpaque(false);
        }

        @Override
        public void paint(Graphics g, JComponent c) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            AbstractButton button = (AbstractButton) c;
            ButtonModel model = button.getModel();
            boolean isPressed = model.isPressed();
            boolean isRollover = model.isRollover();

            int width = button.getWidth();
            int height = button.getHeight();

            RoundRectangle2D roundedRectangle = new RoundRectangle2D.Double(0, 0, width - 1, height - 1, BORDER_RADIUS, BORDER_RADIUS);

            if (isPressed) {
                g2.setColor(button.getBackground().darker());
            } else if (isRollover) {
                g2.setColor(button.getBackground().brighter());
            } else {
                g2.setColor(button.getBackground());
            }

            g2.fill(roundedRectangle);

            super.paint(g2, button);
            g2.dispose();
        }
    }
}
