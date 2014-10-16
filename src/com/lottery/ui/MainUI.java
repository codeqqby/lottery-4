package com.lottery.ui;

import com.lottery.action.ExitAction;
import com.lottery.action.ImportBtnAction;
import com.lottery.action.InitDataAction;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class MainUI extends JFrame {

    private static final long serialVersionUID = -2089179114014597392L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public void init() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new NimbusLookAndFeel());
                    MainUI frame = new MainUI();
                    frame.setSize(1000, 700);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MainUI() {
        setTitle("����͸����ϵͳ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("�� ��");
        menuBar.add(mnNewMenu);

        JMenuItem menuItem = new JMenuItem("��������");
        mnNewMenu.add(menuItem);

        JMenuItem menuItem_1 = new JMenuItem("�� ��");
        mnNewMenu.add(menuItem_1);
        menuItem_1.addActionListener(new ExitAction(this));

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JToolBar toolBar = new JToolBar();
        toolBar.setEnabled(false);
        contentPane.add(toolBar, BorderLayout.NORTH);

        JButton initBtn = new JButton("��ʼ������");
        initBtn.addActionListener(new InitDataAction());
        initBtn.setPreferredSize(new Dimension(100, 30));
        toolBar.add(initBtn);

        JButton importBtn = new JButton("��������");
        importBtn.addActionListener(new ImportBtnAction());
        importBtn.setPreferredSize(new Dimension(80, 30));
        toolBar.add(importBtn);

        JComboBox<Object> comboBox_1 = new JComboBox<Object>();
        comboBox_1.setPreferredSize(new Dimension(350, 30));
        toolBar.add(comboBox_1);

        JComboBox<Object> comboBox = new JComboBox<Object>();
        comboBox.setPreferredSize(new Dimension(350, 30));
        toolBar.add(comboBox);
    }

}
