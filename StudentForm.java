import javax.swing.*;
import java.awt.*;

public class StudentForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Information");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel idLabel = new JLabel("Student ID:");
        JTextField idField = new JTextField();

        JLabel genderLabel = new JLabel("Gender:");
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JPanel genderPanel = new JPanel();
        genderPanel.add(male);
        genderPanel.add(female);

        JLabel programmeLabel = new JLabel("Programme:");
        JComboBox<String> programmeBox = new JComboBox<>();
        programmeBox.addItem("Computer Science");
        programmeBox.addItem("Information Technology");
        programmeBox.addItem("Data Science");
        programmeBox.addItem("Cybersecurity");

        JButton submitButton = new JButton("Submit");
        JButton clearButton = new JButton("Clear");

        JLabel feedback = new JLabel("");

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(idLabel);
        panel.add(idField);
        panel.add(genderLabel);
        panel.add(genderPanel);
        panel.add(programmeLabel);
        panel.add(programmeBox);
        panel.add(submitButton);
        panel.add(clearButton);
        panel.add(new JLabel(""));
        panel.add(feedback);

        submitButton.addActionListener(e -> {
            if (nameField.getText().trim().isEmpty()
                    || idField.getText().trim().isEmpty()
                    || genderGroup.getSelection() == null) {
                feedback.setForeground(Color.RED);
                feedback.setText("Please complete all fields.");
            } else {
                feedback.setForeground(new Color(0, 128, 0));
                feedback.setText("Information submitted successfully.");
            }
        });

        clearButton.addActionListener(e -> {
            nameField.setText("");
            idField.setText("");
            genderGroup.clearSelection();
            programmeBox.setSelectedIndex(0);
            feedback.setText("");
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
