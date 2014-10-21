<<<<<<< HEAD
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
        setTitle("大乐透分析系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("文 件");
        menuBar.add(mnNewMenu);

        JMenuItem menuItem = new JMenuItem("导入数据");
        mnNewMenu.add(menuItem);

        JMenuItem menuItem_1 = new JMenuItem("退 出");
        mnNewMenu.add(menuItem_1);
        menuItem_1.addActionListener(new ExitAction(this));

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JToolBar toolBar = new JToolBar();
        toolBar.setEnabled(false);
        contentPane.add(toolBar, BorderLayout.NORTH);

        JButton initBtn = new JButton("初始化数据");
        initBtn.addActionListener(new InitDataAction());
        initBtn.setPreferredSize(new Dimension(100, 30));
        toolBar.add(initBtn);

        JButton importBtn = new JButton("导入数据");
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
=======
package com.lottery.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.lottery.action.ExitAction;
import com.lottery.action.ImportLotteryAllAction;
import com.lottery.action.ImportLotteryAnyAction;
import com.lottery.common.SpringBeanFactory;
import com.lottery.service.LotteryAllService;

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

		JButton initBtn = new JButton("����ȫ����");
		initBtn.addActionListener(new ImportLotteryAllAction());
		initBtn.setPreferredSize(new Dimension(100, 30));
		toolBar.add(initBtn);
		LotteryAllService lotteryAllService = (LotteryAllService) SpringBeanFactory.getInstance()
				.getBeanById("lotteryAllService");
		if (lotteryAllService != null) {
			if (lotteryAllService.countLotteryAll() != 0) {
				initBtn.setEnabled(false);
			} else {
				initBtn.setEnabled(true);
			}
		}

		JButton importBtn = new JButton("��������");
		importBtn.addActionListener(new ImportLotteryAnyAction());
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
>>>>>>> dmmxzz/master
