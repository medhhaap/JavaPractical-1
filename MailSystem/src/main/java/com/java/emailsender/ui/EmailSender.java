package com.java.emailsender.ui;

import javax.swing.*;
import java.awt.event.*;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender extends JFrame {
    JTextField sender, receiver, subject;
    JPasswordField password;
    JTextArea message;
    JButton send;

    EmailSender() {
        setTitle("Email Sender");
        setSize(450, 380);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Sender:");
        l1.setBounds(20, 20, 80, 20);
        add(l1);

        JLabel l2 = new JLabel("Password:");
        l2.setBounds(20, 50, 80, 20);
        add(l2);

        JLabel l3 = new JLabel("Receiver:");
        l3.setBounds(20, 80, 80, 20);
        add(l3);

        JLabel l4 = new JLabel("Subject:");
        l4.setBounds(20, 110, 80, 20);
        add(l4);

        JLabel l5 = new JLabel("Message:");
        l5.setBounds(20, 140, 80, 20);
        add(l5);

        sender = new JTextField();
        sender.setBounds(100, 20, 300, 20);
        add(sender);

        password = new JPasswordField();
        password.setBounds(100, 50, 300, 20);
        add(password);

        receiver = new JTextField();
        receiver.setBounds(100, 80, 300, 20);
        add(receiver);

        subject = new JTextField();
        subject.setBounds(100, 110, 300, 20);
        add(subject);

        message = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(message);
        scrollPane.setBounds(100, 140, 300, 120);
        add(scrollPane);

        send = new JButton("Send");
        send.setBounds(180, 280, 100, 30);
        add(send);

        send.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = sender.getText().trim();
                String pwd = new String(password.getPassword()).trim();
                String to = receiver.getText().trim();
                String subj = subject.getText().trim();
                String msgText = message.getText().trim();

                if (email.isEmpty() || pwd.isEmpty() || to.isEmpty() || subj.isEmpty() || msgText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields are required!");
                    return;
                }

                try {
                    Properties props = new Properties();
                    props.put("mail.smtp.host", "smtp.gmail.com");
                    props.put("mail.smtp.port", "587");
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.starttls.enable", "true");

                    Session session = Session.getInstance(props, new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(email, pwd);
                        }
                    });

                    Message msg = new MimeMessage(session);
                    msg.setFrom(new InternetAddress(email)); // must match authenticated email
                    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
                    msg.setSubject(subj);
                    msg.setText(msgText);

                    Transport.send(msg);

                    JOptionPane.showMessageDialog(null, "Email Sent!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new EmailSender();
    }
}
