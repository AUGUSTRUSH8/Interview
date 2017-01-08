package com.liangdianshui;

import java.util.ArrayList;

public class Pilgrimage {

    final static int times[] = { 1, 2, 5, 10 };// ����ʱ��
    final static String names[] = { "��ʦ��", "��ʦ��", "��ʦ��", "ʦ��" };// ����

    public static void main(String[] args) {
        Integer other_bridges[] = { 0, 0, 0, 0 };// ����һ��
        Integer bridges[] = { 1, 1, 1, 1 };// ��ǰ����� ��1��ʾ���ڣ�0��ʾ����

        // ��ʼ�ݹ�
        loop(bridges, other_bridges, 0, new StringBuffer());
    }

    private static void loop(Integer[] bridges, Integer[] other_bridges,
            int time, StringBuffer msg) {
        ArrayList<Integer> positions = new ArrayList<Integer>();// ��¼������ʼ���˵��±�
        for (int i = 0; i < bridges.length; i++) {
            if (bridges[i] == 1) {
                positions.add(i);// ��¼�±�
            }
        }
        int len = positions.size();

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) { // ѭ��ȡ���
                // ��¼״̬
                Integer[] zt_bridges = bridges.clone();
                Integer[] zt_other_bridges = other_bridges.clone();
                int zt_time = time;
                StringBuffer zt_msg = new StringBuffer(msg);

                // ����---------
                time += times[positions.get(j)];// ����ʱ��ֱ��ȡ����
                move(bridges, other_bridges, 1, positions.get(i));
                move(bridges, other_bridges, 1, positions.get(j));
                msg.append(" ����:" + names[positions.get(i)] + "&"
                        + names[positions.get(j)]);
                // System.out.print(" ����:" + names[positions.get(i)] + "_"
                // + names[positions.get(j)]);

                // ��������------
                if (isend(other_bridges)) {
                    msg.append(" �ܹ�����:" + time);
                    System.out.println(msg.toString());
                    // System.out.println(" �ܹ�����:" + time);
                    return;
                }
                int k = 0;
                for (int ii = 0; ii < other_bridges.length; ii++) {// ѡ�����Ļ���
                    if (other_bridges[ii] == 1) {
                        k = ii;
                        break;
                    }
                }
                time += times[k];
                move(bridges, other_bridges, 0, k);
                msg.append("  ����:" + names[k]+"  ***  ");
                // System.out.print(" ����:" + names[k]);

                // ����ѭ������
                loop(bridges.clone(), other_bridges.clone(), time,
                        new StringBuffer(msg));

                // ��ԭ״̬
                bridges = zt_bridges;
                other_bridges = zt_other_bridges;
                time = zt_time;
                msg = zt_msg;
            }
        }
    }

    /**
     * �ƶ����Ǹ���
     * 
     * @param bridges
     * @param other_bridges
     * @param direction
     *            ����
     * @param position
     */
    private static void move(Integer[] bridges, Integer[] other_bridges,
            int direction, int position) {
        if (direction == 1) {// ����һ����
            bridges[position] = 0;
            other_bridges[position] = 1;
        } else {// ����������
            bridges[position] = 1;
            other_bridges[position] = 0;
        }
    }

    // �ж��Ƿ��Ѿ�������
    // ��other_bridges {1,1,1,1}��ʾ����
    private static boolean isend(Integer[] other_bridges) {
        for (int i : other_bridges) {
            if (i == 0)
                return false;
        }
        return true;
    }

}