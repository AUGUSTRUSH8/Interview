package com.liangdianshui;

/**
 * <p>
 * 6�� 9�ĵķ����У��������½ǣ��յ������Ͻǣ�����㵽�յ㣬ֻ�ܴ������ϣ����������ߣ���һ���ж����ֲ�ͬ���߷���
 *  A. 4200 
 *  B. 5005
 *  C. 1005 
 *  D. ���϶�����ȷ
 * </p>
 * 
 * @author liangdianshui
 *
 */
public class Catalan {

	public static void main(String[] args) {
		System.out.println(func(6, 9));
	}

	public static int func(int m, int n) {

		if (m < 1 || n < 1) {
			return 1;
		}

		return func(m - 1, n) + func(m, n - 1);
	}
}
