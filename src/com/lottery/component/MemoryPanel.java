package com.lottery.component;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tasly on 2014/10/21.
 */
public class MemoryPanel extends JPanel {
    //״̬������ɫ
    private Color edgeColor = new Color(82, 115, 214);
    private Color centerColor = new Color(180, 200, 230);

    public void paint(Graphics g) {
        super.paint(g);
        //�õ���ǰ�����JPanel���Ĵ�С
        Dimension dimension = getSize();
        //�õ����߿�Ŀ��
        Insets insets = getInsets();
        int left = insets.left;
        int top = insets.top;
        //�õ��ڴ�ʹ��״̬��Ϣ
        Runtime runtime = Runtime.getRuntime();
        long freeMemory = runtime.freeMemory();
        long totalMemory = runtime.totalMemory();
        //�����JPanel����ȥ���ұ߿��Ŀ��
        int insideWidth = dimension.width - (insets.left + insets.right);
        //�ڴ�ʹ��������ʾ���
        int usedAmount = insideWidth - (int) (((long) insideWidth * freeMemory) / totalMemory);
        int insideHeight = dimension.height - (insets.bottom + insets.top);
        Graphics2D g2 = (Graphics2D) g;
        //���ý���Ч���Ļ���
        g2.setPaint(new GradientPaint(left, top, edgeColor, left, insideHeight / 2, centerColor, true));
        g.fillRect(left, top, usedAmount, insideHeight);
        g.setColor(getBackground());
        g.fillRect(left + usedAmount, top, insideWidth - usedAmount, insideHeight);
        g.setFont(getFont());
        g.setColor(Color.black);
        //��ʾ״̬������
        String memory = (Long.toString((totalMemory - freeMemory) / 1048576L) + "M of " + Long.toString(totalMemory / 1048576L) + 'M');
        //ȷ�����ֵ���ʾλ��
        FontMetrics fontmetrics = g.getFontMetrics();
        int stringWidth = fontmetrics.charsWidth(memory.toCharArray(), 0, memory.length());
        int stringHeight = fontmetrics.getHeight() - fontmetrics.getDescent();
        //��ʾ����
        g.drawString(memory, left + (insideWidth - stringWidth) / 2, top + (insideHeight + stringHeight) / 2);
    }
}
