package com.lottery.component;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by tasly on 2014/10/22.
 */
public class CrystalImageButton extends ImageButton {
    private int frameType = 0; // �߿�
    public static int FRAME_RIGHT = 1;
    public static int FRAME_AROUND = 4;

    private int mbStatus = 0;// ����¼�״̬ 0: ��굯��,1:��갴��
    private boolean clicked = false; // ����

    private float alpha = 1f; // ��͸��

    public CrystalImageButton(String name) {
        setName(name);
        setOpaque(false);
        setBorderPainted(false);
    }

    public void mouseEntered(MouseEvent e) {
        if (clicked)
            return;
        new Thread() {
            public void run() {
                float a = 0f;
                while (a <= 1f) {
                    alpha = a;
                    CrystalImageButton.this.repaint();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                    }
                    a += 0.1;
                }
            }
        }.start();
    }

    public void mouseExited(MouseEvent e) {
    }

    public int getFrameType() {
        return frameType;
    }

    public void setFrameType(int frameType) {
        this.frameType = frameType;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        AlphaComposite composite = AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, alpha);
        g2.setComposite(composite);

        // ���Ʊ߿�
        if (this.isMouseEntered) {
            PaintUtils.drawButtonBackground(g2, this, new Color(253, 236, 219),
                    new Color(253, 223, 187), new Color(255, 206, 105),
                    new Color(255, 255, 222));
        }
        // ��ť�����µ�Ч��
        if (clicked) {
            PaintUtils.drawButtonBackground(g2, this, new Color(255, 199, 99),
                    new Color(253, 236, 219), new Color(253, 236, 219),
                    new Color(255, 199, 99));
        }
        composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f);
        g2.setComposite(composite);
        if (frameType == FRAME_AROUND) {
            g.setColor(ApplicationConfig.COLOR_TOOLBAR_FRAME);
            g.drawRoundRect(1, 1, getWidth() - 4, getHeight() - 2, 3, 3);
        } else if (frameType == FRAME_RIGHT) {
            g.setColor(ApplicationConfig.COLOR_TOOLBAR_FRAME);
            g.drawLine(getWidth() - 1, 1, getWidth() - 1, getHeight() - 2);
        }

        // �������
        PaintUtils.setFractionalmetricsOn(g2);
        // ���ַ��
        g.setColor(ApplicationConfig.COLOR_UI_TEXT);
        g.setFont(ApplicationConfig.FONT_UI_TEXT);

        // ����ͼ��
        if (getImage() != null) {
            g.drawImage(getImage(),
                    (getWidth() - getImage().getWidth(this)) / 2, 5 + mbStatus,
                    this);
            g.drawString(getName(), (getWidth() - getName().length()
                            * ApplicationConfig.FONT_UI_TEXT.getSize()) / 2,
                    getImage().getHeight(this) + mbStatus);
        } else {
            g.drawString(getName(), (getWidth() - getName().length()
                    * ApplicationConfig.FONT_UI_TEXT.getSize()) / 2, 10 + mbStatus);
        }
    }

    public void pushButton(boolean x) {
        clicked = x;
    }

    public void mousePressed(MouseEvent e) {
        mbStatus = 1;
    }

    public void mouseReleased(MouseEvent e) {
        mbStatus = 0;
    }
}
