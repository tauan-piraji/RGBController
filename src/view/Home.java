package view;

import business.RGBController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Objects;

public class Home extends JFrame {

    private JButton bGrid;
    private JButton bRead;
    private JButton bGreen;
    private JButton bBlue;
    private JButton bChess;
    private JButton bGreey;
    private JButton bBlackWhite;
    private JTextArea TABlackWhite;
    private JButton bFocus;
    private JLabel img;
    private JLabel imgCleans;

    public Home() {
        this.setSize(1000, 700);
        setTitle("Paint");
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        inicializa();
    }

    public void inicializa() {
        bGrid = new JButton("grid effect");
        bGrid.setBounds(20, 10, 120, 35);
        bGrid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    img.setIcon(new ImageIcon(RGBController.grid(getClass().getResource("/img/dog.jpg"))));
                    img.updateUI();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        getContentPane().add(bGrid);

        bRead = new JButton("Read");
        bRead.setBounds(20, 55, 120, 35);
        bRead.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    img.setIcon(new ImageIcon(RGBController.selectRGB(getClass().getResource("/img/dog.jpg"), "R")));
                    img.updateUI();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        getContentPane().add(bRead);

        bGreen = new JButton("Green");
        bGreen.setBounds(20, 100, 120, 35);
        bGreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    img.setIcon(new ImageIcon(RGBController.selectRGB(getClass().getResource("/img/dog.jpg"), "G")));
                    img.updateUI();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        getContentPane().add(bGreen);

        bBlue = new JButton("Blue");
        bBlue.setBounds(20, 145, 120, 35);
        bBlue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    img.setIcon(new ImageIcon(RGBController.selectRGB(getClass().getResource("/img/dog.jpg"), "B")));
                    img.updateUI();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        getContentPane().add(bBlue);

        bChess = new JButton("chess effect");
        bChess.setBounds(20, 190, 120, 35);
        bChess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    img.setIcon(new ImageIcon(RGBController.chess(getClass().getResource("/img/dog.jpg"))));
                    img.updateUI();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        getContentPane().add(bChess);

        bGreey = new JButton("Greey");
        bGreey.setBounds(20, 235, 120, 35);
        bGreey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    img.setIcon(new ImageIcon(RGBController.blackWhite(getClass().getResource("/img/dog.jpg"))));
                    img.updateUI();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        getContentPane().add(bGreey);

        TABlackWhite = new JTextArea();
        TABlackWhite.setBounds(155, 280, 35, 35);
        TABlackWhite.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        getContentPane().add(TABlackWhite);

        bBlackWhite = new JButton("Black end white");
        bBlackWhite.setBounds(20, 280, 120, 35);
        bBlackWhite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    img.setIcon(new ImageIcon(RGBController.bblackWhite(getClass().getResource("/img/dog.jpg"), TABlackWhite.getText())));
                    img.updateUI();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        getContentPane().add(bBlackWhite);

        bFocus = new JButton("Focus");
        bFocus.setBounds(20, 325, 120, 35);
        bFocus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    img.setIcon(new ImageIcon(RGBController.focus(getClass().getResource("/img/dog.jpg"))));
                    img.updateUI();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        getContentPane().add(bFocus);

        img = new JLabel();
        img.setBounds(200, 55, 332, 300);
        try {
            img.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/dog.jpg"))));
        } catch (Exception e) {
            System.err.println(e);
        }
        getContentPane().add(img);

        imgCleans = new JLabel();
        imgCleans.setBounds(542, 55, 332, 300);
        try {
            imgCleans.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/dog.jpg"))));
        } catch (Exception e) {
            System.err.println(e);
        }
        getContentPane().add(imgCleans);
    }
}
