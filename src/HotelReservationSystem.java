import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;

public class HotelReservationSystem extends JFrame {

    private JTextField txtGuestName;
    private JTextField txtPhone;
    private JTextField txtEmail;

    private JComboBox<String> cmbRoomType;
    private JSpinner spnGuests;

    private JTextField txtCheckIn;
    private JTextField txtCheckOut;

    private JComboBox<String> cmbPaymentMethod;
    private JTextField txtAmount;

    private JTextArea txtSummary;

    // Luxury Dark Theme Colors
    private static final Color DARK_BG = new Color(20, 22, 25);
    private static final Color CARD_BG = new Color(30, 33, 38);
    private static final Color GOLD_ACCENT = new Color(201, 163, 100);
    private static final Color TEXT_MUTED = new Color(170, 175, 185);
    private static final Color INPUT_BG = new Color(42, 46, 54);

    public HotelReservationSystem() {

        // Main Window Settings
        setTitle("The Azure - Luxury Hotel Reservation");
        setSize(1000, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(DARK_BG);
        setLayout(new BorderLayout(15, 15));

        // =====================================
        // 1. BRANDING HEADER
        // =====================================

        JPanel headerPanel = new JPanel();

        headerPanel.setBackground(new Color(15, 17, 20));

        headerPanel.setLayout(
                new BoxLayout(headerPanel, BoxLayout.Y_AXIS)
        );

        headerPanel.setBorder(
                new EmptyBorder(25, 20, 25, 20)
        );

        // =====================================
        // CUSTOM GOLD LOGO
        // =====================================

        JLabel logoIcon = new JLabel() {

            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);

                Graphics2D g2 =
                        (Graphics2D) g.create();

                g2.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON
                );

                g2.setColor(GOLD_ACCENT);

                // Outer Gold Ring
                g2.setStroke(new BasicStroke(1.5f));

                g2.drawOval(
                        4,
                        4,
                        52,
                        52
                );

                // Inner Dashed Ring
                float[] dash = {
                        3.0f,
                        3.0f
                };

                g2.setStroke(
                        new BasicStroke(
                                1.0f,
                                BasicStroke.CAP_BUTT,
                                BasicStroke.JOIN_MITER,
                                10.0f,
                                dash,
                                0.0f
                        )
                );

                g2.drawOval(
                        8,
                        8,
                        44,
                        44
                );

                // Sun
                g2.fillOval(
                        27,
                        16,
                        6,
                        6
                );

                // First Ocean Wave
                g2.setStroke(
                        new BasicStroke(
                                1.8f,
                                BasicStroke.CAP_ROUND,
                                BasicStroke.JOIN_ROUND
                        )
                );

                Path2D wave1 =
                        new Path2D.Float();

                wave1.moveTo(18, 34);

                wave1.quadTo(
                        30,
                        26,
                        42,
                        34
                );

                g2.draw(wave1);

                // Second Ocean Wave
                Path2D wave2 =
                        new Path2D.Float();

                wave2.moveTo(22, 40);

                wave2.quadTo(
                        30,
                        33,
                        38,
                        40
                );

                g2.draw(wave2);

                g2.dispose();
            }

            @Override
            public Dimension getPreferredSize() {

                return new Dimension(
                        60,
                        60
                );
            }
        };

        logoIcon.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        // =====================================
        // HOTEL BRAND NAME
        // =====================================

        JLabel lblBrandName =
                new JLabel("T H E   A Z U R E");

        lblBrandName.setFont(
                new Font(
                        "Serif",
                        Font.PLAIN,
                        12
                )
        );

        lblBrandName.setForeground(
                GOLD_ACCENT
        );

        lblBrandName.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        // Main Header Title
        JLabel lblHeroTitle =
                new JLabel("Seaside Serenity");

        lblHeroTitle.setFont(
                new Font(
                        "Serif",
                        Font.ITALIC,
                        36
                )
        );

        lblHeroTitle.setForeground(
                Color.WHITE
        );

        lblHeroTitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        // Hotel Tagline
        JLabel lblTagline =
                new JLabel(
                        "WHERE LUXURY MEETS THE OCEAN"
                );

        lblTagline.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        10
                )
        );

        lblTagline.setForeground(
                new Color(210, 215, 225)
        );

        lblTagline.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        // Add header components
        headerPanel.add(logoIcon);

        headerPanel.add(
                Box.createRigidArea(
                        new Dimension(0, 5)
                )
        );

        headerPanel.add(lblBrandName);

        headerPanel.add(
                Box.createRigidArea(
                        new Dimension(0, 2)
                )
        );

        headerPanel.add(lblHeroTitle);

        headerPanel.add(
                Box.createRigidArea(
                        new Dimension(0, 4)
                )
        );

        headerPanel.add(lblTagline);

        add(
                headerPanel,
                BorderLayout.NORTH
        );

        // =====================================
        // 2. MAIN GRIDLAYOUT
        // =====================================

        JPanel mainPanel =
                new JPanel(
                        new GridLayout(
                                3,
                                2,
                                15,
                                15
                        )
                );

        mainPanel.setOpaque(false);

        mainPanel.setBorder(
                new EmptyBorder(
                        0,
                        25,
                        10,
                        25
                )
        );

        // =====================================
        // GUEST INFORMATION PANEL
        // =====================================

        JPanel guestPanel =
                createLuxuryPanel(
                        "GUEST INFORMATION"
                );

        guestPanel.setLayout(
                new GridLayout(
                        3,
                        2,
                        8,
                        8
                )
        );

        guestPanel.add(
                createLabel("Guest Name:")
        );

        txtGuestName =
                createStyledTextField("");

        guestPanel.add(txtGuestName);

        guestPanel.add(
                createLabel("Phone Number:")
        );

        txtPhone =
                createStyledTextField("");

        guestPanel.add(txtPhone);

        guestPanel.add(
                createLabel("Email Address:")
        );

        txtEmail =
                createStyledTextField("");

        guestPanel.add(txtEmail);

        // =====================================
        // ROOM SELECTION PANEL
        // =====================================

        JPanel roomPanel =
                createLuxuryPanel(
                        "ACCOMMODATIONS"
                );

        roomPanel.setLayout(
                new GridLayout(
                        2,
                        2,
                        8,
                        8
                )
        );

        roomPanel.add(
                createLabel("Room Selection:")
        );

        String[] rooms = {
                "Ocean Suite ($299/night)",
                "Family Villa ($450/night)",
                "Spa Retreat Villa ($620/night)",
                "Presidential Penthouse ($1,200/night)"
        };

        cmbRoomType =
                createStyledComboBox(rooms);

        roomPanel.add(cmbRoomType);

        roomPanel.add(
                createLabel(
                        "Number of Guests:"
                )
        );

        spnGuests =
                new JSpinner(
                        new SpinnerNumberModel(
                                1,
                                1,
                                10,
                                1
                        )
                );

        styleSpinner(spnGuests);

        roomPanel.add(spnGuests);

        // =====================================
        // BOOKING DATES PANEL
        // =====================================

        JPanel datePanel =
                createLuxuryPanel(
                        "STAY DATES"
                );

        datePanel.setLayout(
                new GridLayout(
                        2,
                        2,
                        8,
                        8
                )
        );

        datePanel.add(
                createLabel(
                        "Check-in Date:"
                )
        );

        txtCheckIn =
                createStyledTextField(
                        "YYYY-MM-DD"
                );

        datePanel.add(txtCheckIn);

        datePanel.add(
                createLabel(
                        "Check-out Date:"
                )
        );

        txtCheckOut =
                createStyledTextField(
                        "YYYY-MM-DD"
                );

        datePanel.add(txtCheckOut);

        // =====================================
        // PAYMENT DETAILS PANEL
        // =====================================

        JPanel paymentPanel =
                createLuxuryPanel(
                        "PAYMENT & RATES"
                );

        paymentPanel.setLayout(
                new GridLayout(
                        2,
                        2,
                        8,
                        8
                )
        );

        paymentPanel.add(
                createLabel(
                        "Payment Method:"
                )
        );

        String[] paymentMethods = {
                "Cash",
                "Credit Card",
                "Debit Card",
                "Mobile Money",
                "Bank Transfer"
        };

        cmbPaymentMethod =
                createStyledComboBox(
                        paymentMethods
                );

        paymentPanel.add(
                cmbPaymentMethod
        );

        paymentPanel.add(
                createLabel(
                        "Total Amount ($):"
                )
        );

        txtAmount =
                createStyledTextField("");

        paymentPanel.add(txtAmount);

        // =====================================
        // RESERVATION SUMMARY PANEL
        // =====================================

        JPanel summaryPanel =
                createLuxuryPanel(
                        "RESERVATION OVERVIEW"
                );

        summaryPanel.setLayout(
                new BorderLayout()
        );

        txtSummary =
                new JTextArea();

        txtSummary.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        12
                )
        );

        txtSummary.setBackground(
                INPUT_BG
        );

        txtSummary.setForeground(
                Color.WHITE
        );

        txtSummary.setEditable(false);

        txtSummary.setCaretColor(
                Color.WHITE
        );

        JScrollPane scrollPane =
                new JScrollPane(
                        txtSummary
                );

        scrollPane.setBorder(
                BorderFactory.createEmptyBorder()
        );

        summaryPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );

        // =====================================
        // ACTION BUTTON PANEL
        // =====================================

        JPanel buttonPanel =
                createLuxuryPanel(
                        "ACTIONS"
                );

        buttonPanel.setLayout(
                new GridLayout(
                        3,
                        1,
                        8,
                        8
                )
        );

        JButton btnReserve =
                createPillButton(
                        "RESERVE YOUR STAY",
                        GOLD_ACCENT,
                        DARK_BG
                );

        JButton btnClear =
                createPillButton(
                        "Reset Details",
                        CARD_BG,
                        GOLD_ACCENT
                );

        JButton btnExit =
                createPillButton(
                        "Close System",
                        CARD_BG,
                        new Color(
                                230,
                                90,
                                90
                        )
                );

        buttonPanel.add(btnReserve);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnExit);

        // =====================================
        // ADD ALL PANELS TO MAIN GRID
        // =====================================

        mainPanel.add(guestPanel);
        mainPanel.add(roomPanel);

        mainPanel.add(datePanel);
        mainPanel.add(paymentPanel);

        mainPanel.add(summaryPanel);
        mainPanel.add(buttonPanel);

        add(
                mainPanel,
                BorderLayout.CENTER
        );

        // =====================================
        // FOOTER
        // =====================================

        JPanel footerPanel =
                new JPanel(
                        new BorderLayout()
                );

        footerPanel.setOpaque(false);

        footerPanel.setBorder(
                new EmptyBorder(
                        0,
                        25,
                        12,
                        25
                )
        );

        JLabel lblWeb =
                new JLabel(
                        "The Azure Luxury Hotel"
                );

        lblWeb.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        10
                )
        );

        lblWeb.setForeground(
                TEXT_MUTED
        );

        JLabel lblPhone =
                new JLabel(
                        "Hotel Reservation System"
                );

        lblPhone.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        10
                )
        );

        lblPhone.setForeground(
                TEXT_MUTED
        );

        footerPanel.add(
                lblWeb,
                BorderLayout.WEST
        );

        footerPanel.add(
                lblPhone,
                BorderLayout.EAST
        );

        add(
                footerPanel,
                BorderLayout.SOUTH
        );

        // =====================================
        // MAKE RESERVATION BUTTON
        // =====================================

        btnReserve.addActionListener(e -> {

            String guestName =
                    txtGuestName.getText();

            String checkIn =
                    txtCheckIn.getText();

            String checkOut =
                    txtCheckOut.getText();

            // Validation
            if (guestName.trim().isEmpty()
                    || checkIn.trim().isEmpty()
                    || checkOut.trim().isEmpty()
                    || checkIn.equals("YYYY-MM-DD")
                    || checkOut.equals("YYYY-MM-DD")) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter the guest name and valid booking dates.",
                        "Incomplete Reservation",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            // Display Reservation Summary
            txtSummary.setText(

                    "=====================================\n" +
                            "        THE AZURE LUXURY HOTEL       \n" +
                            "=====================================\n" +

                            " Guest Name : "
                            + guestName + "\n" +

                            " Phone      : "
                            + txtPhone.getText()
                            + "\n" +

                            " Email      : "
                            + txtEmail.getText()
                            + "\n" +

                            " Room Type  : "
                            + cmbRoomType.getSelectedItem()
                            + "\n" +

                            " Guests     : "
                            + spnGuests.getValue()
                            + "\n" +

                            " Check-In   : "
                            + checkIn
                            + "\n" +

                            " Check-Out  : "
                            + checkOut
                            + "\n" +

                            " Payment    : "
                            + cmbPaymentMethod.getSelectedItem()
                            + "\n" +

                            " Total      : $"
                            + txtAmount.getText()
                            + "\n" +

                            "-------------------------------------\n" +

                            " STATUS     : CONFIRMED & RESERVED\n" +

                            "====================================="
            );
        });

        // =====================================
        // CLEAR BUTTON
        // =====================================

        btnClear.addActionListener(e -> {

            txtGuestName.setText("");
            txtPhone.setText("");
            txtEmail.setText("");

            cmbRoomType.setSelectedIndex(0);

            spnGuests.setValue(1);

            txtCheckIn.setText(
                    "YYYY-MM-DD"
            );

            txtCheckOut.setText(
                    "YYYY-MM-DD"
            );

            cmbPaymentMethod.setSelectedIndex(0);

            txtAmount.setText("");

            txtSummary.setText("");
        });

        // =====================================
        // EXIT BUTTON
        // =====================================

        btnExit.addActionListener(
                e -> System.exit(0)
        );
    }

    // =====================================
    // METHOD FOR CREATING PANELS
    // =====================================

    private JPanel createLuxuryPanel(
            String title
    ) {

        JPanel panel =
                new JPanel();

        panel.setBackground(
                CARD_BG
        );

        panel.setBorder(
                BorderFactory.createCompoundBorder(

                        BorderFactory.createLineBorder(
                                new Color(
                                        50,
                                        54,
                                        62
                                ),
                                1
                        ),

                        BorderFactory.createTitledBorder(
                                BorderFactory.createEmptyBorder(
                                        4,
                                        8,
                                        4,
                                        8
                                ),
                                title,
                                javax.swing.border.TitledBorder.LEFT,
                                javax.swing.border.TitledBorder.TOP,
                                new Font(
                                        "SansSerif",
                                        Font.BOLD,
                                        10
                                ),
                                GOLD_ACCENT
                        )
                )
        );

        return panel;
    }

    // =====================================
    // METHOD FOR CREATING LABELS
    // =====================================

    private JLabel createLabel(
            String text
    ) {

        JLabel label =
                new JLabel(text);

        label.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        11
                )
        );

        label.setForeground(
                TEXT_MUTED
        );

        return label;
    }

    // =====================================
    // METHOD FOR TEXT FIELDS
    // =====================================

    private JTextField createStyledTextField(
            String defaultText
    ) {

        JTextField textField =
                new JTextField(
                        defaultText
                );

        textField.setBackground(
                INPUT_BG
        );

        textField.setForeground(
                Color.WHITE
        );

        textField.setCaretColor(
                GOLD_ACCENT
        );

        textField.setBorder(
                BorderFactory.createCompoundBorder(

                        BorderFactory.createLineBorder(
                                new Color(
                                        60,
                                        65,
                                        75
                                ),
                                1
                        ),

                        BorderFactory.createEmptyBorder(
                                3,
                                6,
                                3,
                                6
                        )
                )
        );

        return textField;
    }

    // =====================================
    // METHOD FOR COMBO BOXES
    // =====================================

    private JComboBox<String> createStyledComboBox(
            String[] items
    ) {

        JComboBox<String> comboBox =
                new JComboBox<>(items);

        comboBox.setBackground(
                INPUT_BG
        );

        comboBox.setForeground(
                Color.WHITE
        );

        return comboBox;
    }

    // =====================================
    // METHOD FOR SPINNER
    // =====================================

    private void styleSpinner(
            JSpinner spinner
    ) {

        JComponent editor =
                spinner.getEditor();

        if (editor instanceof JSpinner.DefaultEditor) {

            JTextField textField =
                    ((JSpinner.DefaultEditor) editor)
                            .getTextField();

            textField.setBackground(
                    INPUT_BG
            );

            textField.setForeground(
                    Color.WHITE
            );

            textField.setCaretColor(
                    GOLD_ACCENT
            );
        }
    }

    // =====================================
    // METHOD FOR ROUNDED BUTTONS
    // =====================================

    private JButton createPillButton(
            String text,
            Color background,
            Color foreground
    ) {

        JButton button =
                new JButton(text) {

                    @Override
                    protected void paintComponent(
                            Graphics g
                    ) {

                        Graphics2D g2 =
                                (Graphics2D) g.create();

                        g2.setRenderingHint(
                                RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON
                        );

                        g2.setColor(
                                background
                        );

                        g2.fill(
                                new RoundRectangle2D.Float(
                                        0,
                                        0,
                                        getWidth(),
                                        getHeight(),
                                        20,
                                        20
                                )
                        );

                        g2.setFont(
                                getFont()
                        );

                        FontMetrics fontMetrics =
                                g2.getFontMetrics();

                        int x =
                                (getWidth()
                                        - fontMetrics.stringWidth(
                                        getText()
                                )) / 2;

                        int y =
                                (getHeight()
                                        + fontMetrics.getAscent()
                                        - fontMetrics.getDescent())
                                        / 2;

                        g2.setColor(
                                foreground
                        );

                        g2.drawString(
                                getText(),
                                x,
                                y
                        );

                        g2.dispose();
                    }
                };

        button.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        11
                )
        );

        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        return button;
    }

    // =====================================
    // MAIN METHOD
    // =====================================

    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(() -> {

            HotelReservationSystem system =
                    new HotelReservationSystem();

            system.setVisible(true);
        });
    }
}