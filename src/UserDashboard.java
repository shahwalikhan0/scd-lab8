import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserDashboard extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel inboxPanel, sentBoxPanel;
    private JTextField recipientField;
    private JTextArea messageTextArea;

    public UserDashboard() {
        setTitle("User Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();

        inboxPanel = new JPanel();
        sentBoxPanel = new JPanel();

        tabbedPane.addTab("Inbox", inboxPanel);
        tabbedPane.addTab("Sent Box", sentBoxPanel);

        createSendMessageForm();

        add(tabbedPane);
    }

    private void createSendMessageForm() {
        JPanel sendMessagePanel = new JPanel();
        sendMessagePanel.setLayout(new GridLayout(3, 2));

        JLabel recipientLabel = new JLabel("Recipient User ID:");
        recipientField = new JTextField();
        JLabel messageLabel = new JLabel("Message:");
        messageTextArea = new JTextArea();
        JButton sendButton = new JButton("Send");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        sendMessagePanel.add(recipientLabel);
        sendMessagePanel.add(recipientField);
        sendMessagePanel.add(messageLabel);
        sendMessagePanel.add(messageTextArea);
        sendMessagePanel.add(sendButton);

        tabbedPane.addTab("Send Message", sendMessagePanel);
    }

    private void sendMessage() {
        // Implement logic to save the message in the database
        String recipientID = recipientField.getText();
        String messageContent = messageTextArea.getText();

        // Add the logic to save the message in the database (e.g., using JDBC)

        // Display the sent message in the Sent Box tab
        JTextArea sentBoxTextArea = new JTextArea();
        sentBoxTextArea.append("To: " + recipientID + "\n");
        sentBoxTextArea.append("Message: " + messageContent + "\n");
        sentBoxPanel.add(sentBoxTextArea);

        // Clear the form after sending the message
        recipientField.setText("");
        messageTextArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UserDashboard().setVisible(true);
            }
        });
    }
}
