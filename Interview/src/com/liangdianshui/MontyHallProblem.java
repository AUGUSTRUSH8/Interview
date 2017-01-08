package com.liangdianshui;

import java.util.Random;

public class MontyHallProblem {

    public static void main(String[] args) {
        // �ظ����
        for (int i = 0; i < 4; i++) {
            montyHallProblem();
            System.out.println("----------------------------------");
        }
    }

    public static void montyHallProblem() {
        Random random = new Random(); // ���ﲻ����RandomΪα���������
        int changeCount = 0;
        for (int i = 0; i < 1000000.0f; i++) { // ģ��һ�����
            // ������������
            int[] doors = new int[3];

            // �����ȡһ���� ,���ź�Ž�Ʒ
            int rIndex = random.nextInt(3);
            doors[rIndex] = 1;

            // ����ѡ���ź�
            int randomSelect = random.nextInt(3);

            // �����˴�ʣ�µ����������ų�һ��
            while (true) {
                int randomDelete = random.nextInt(3);
                // �����˲���򿪲������Ѿ�ѡ�˵��ţ��ų�������ѡ����ţ�
                if (randomDelete == randomSelect) {
                    continue;
                }
                // �����˲�����н�Ʒ���ţ��ų��н�Ʒ���ţ�
                if (doors[randomDelete] == 1) {
                    continue;
                }

                for (int j = 0; j < 3; j++)// ����
                {
                    if (j == randomSelect)// �����ţ���Ϊ����Ҫ�õ����ǻ��ŵĸ��ʣ���˰Ѳ����ŵ��ų�����
                        continue;
                    // �ų������˴����Ǹ��ţ���Ϊ���Ѿ��򿪣����Բ��ܻ����ų�����
                    if (j == randomDelete)
                        continue;
                    if (doors[j] == 1) {
                        changeCount++;// �����ź��н��Ĵ���
                        break;
                    }
                }
                break;
            }
        }
        System.out.println("�����н���:" + changeCount / 1000000.0f);
    }

}