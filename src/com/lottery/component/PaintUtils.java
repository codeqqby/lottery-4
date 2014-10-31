package com.lottery.component;

import java.awt.*;

/**
 * Created by tasly on 2014/10/22.
 */
public class PaintUtils {
    //�����������
    public static void setFractionalmetricsOn(Graphics2D g2) {
        //�������
        RenderingHints qualityHints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        qualityHints.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        qualityHints.put(RenderingHints.KEY_FRACTIONALMETRICS,
                RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2.setRenderingHints(qualityHints);
    }

    /**
     * ��ť��ɫ����
     *
     * @param g2         ����
     * @param bt         ���
     * @param c1         ������ɫ1
     * @param c2         ������ɫ2
     * @param c3         ������ɫ3
     * @param c4         ������ɫ4
     * @param frameColor �߿���ɫ
     */
    public static void drawButtonBackground(Graphics2D g2, CrystalImageButton bt, Color c1, Color c2, Color c3, Color c4, Color frameColor) {

        g2.setColor(frameColor);
        g2.drawRoundRect(1, 1, bt.getWidth() - 4, bt.getHeight() - 2, 3, 3);

        //���䱳��
        g2.setPaint(new GradientPaint(2, 2, c1, 1, bt.getHeight() / 3, c2));
        g2.fillRect(2, 2, bt.getWidth() - 5, bt.getHeight() / 3);
        //�������
        g2.setPaint(new GradientPaint(1, bt.getHeight() / 3, c3, 1, bt.getHeight(), c4));
        g2.fillRect(2, bt.getHeight() / 3, bt.getWidth() - 5, bt.getHeight() / 3 * 2 - 1);
    }

    public static void drawButtonBackground(Graphics2D g2, CrystalImageButton bt, Color c1, Color c2, Color c3, Color c4) {
        drawButtonBackground(g2, bt, c1, c2, c3, c4, ApplicationConfig.COLOR_UI_FRAME);
    }
}
