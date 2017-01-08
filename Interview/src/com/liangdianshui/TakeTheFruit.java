package com.liangdianshui;

import java.util.Scanner;


/**
 * <p>
 *   ��������ˮ����ÿ��ˮ������Ҳ������ģ�������������ȡ��ˮ�����������£�
 *   1��ÿһ��Ӧȡ������һ��ˮ����ÿһ��ֻ��ȡ��һ��ˮ����һ������ȫ��
 *   2�����˭ȡ�����һ��ˮ����ʤ
 *	  ����ˮ������N��ÿ��ˮ���ĸ���M1��M2����Mn�����˭ȡʤ��
 *   ����Ŀ�������������������㹻������������Ϊ��ȡʤ���������ù���
 * </p>
 * 
 * @author liangdianshui
 *
 */
public class TakeTheFruit {
	private static final String EXIT = "q";

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String input;
		int[] fruitNums;

		do {
			System.out.println("���� A �� B �����ˣ�A ��ȡˮ��");
			System.out.println("������ÿ��ˮ���ĸ������ո��س��ָ�����");
			System.out.println("���� Q ��  q �˳�");

			if (EXIT.equalsIgnoreCase(input = scanner.nextLine())) {
				System.out.println("Exit");
				break;
			}

			input = input.trim();
			if (input.length() != 0) {
				fruitNums = initFruitNums(input);
				boolean isWin = takeTheFruitGame(fruitNums, fruitNums.length);
				if(isWin){
					System.out.println("A Ӯ");
				}else{
					System.out.println("B Ӯ");
				}
				System.out.println("--------------------------------------------");
			}
		} while (true);
	}

	/**
	 * ��ʼ��ÿ��ˮ���ĸ���
	 * 
	 * @param input
	 * @return
	 */
	private static int[] initFruitNums(String input) {
		String[] nums = input.split("\\s+");
		int[] fruitNums = new int[nums.length];
		int num;
		for (int i = 0; i < nums.length; i++) {
			num = Integer.parseInt(nums[i]);
			if (num <= 0) {
				throw new IllegalArgumentException("ˮ����������Ϊ 0 ������" + num);
			}

			fruitNums[i] = num;
		}

		return fruitNums;
	}

	/**
	 * �ݹ鷨
	 * 
	 * @param fruitNums
	 * @param numOfTypes
	 * @return
	 */
	private static boolean takeTheFruitGame(int[] fruitNums, int numOfTypes) {
		
		//��ˮ������Ϊ1��ʱ�򣬱�ʤ
		if (numOfTypes == 1) {
			return true;
		}

		// ��ˮ������Ϊ2��ʱ��
		if (numOfTypes == 2) {
			return sumOfTwoFruitNums(fruitNums) % 2 == 1;
		}

		// ��ˮ��������ڵ���3��ʱ��
		int num;
		for (int i = 0; i < fruitNums.length; i++) {
			num = fruitNums[i];
			if (num == 0)
				continue;

			fruitNums[i] = 0;
			if (!takeTheFruitGame(fruitNums, numOfTypes - 1)) {
				fruitNums[i] = num;
				return true;
			}
			if (num > 1) {
				fruitNums[i] = num - 1;
				if (!takeTheFruitGame(fruitNums, numOfTypes)) {
					fruitNums[i] = num;
					return true;
				}
			}

			fruitNums[i] = num;
		}

		return false;
	}

	/**
	 * <p>
	 * 	ͨ������ֱ��������
	 *  N Ϊ������A ��ʤ
	 *  N Ϊż������� M Ϊ������A ��ʤ����� M Ϊż����A �ذ�
	 * </p>
	 * @param fruitNums
	 * @return
	 */
	private static boolean takeTheFruitGame2(int[] fruitNums) {
		if (fruitNums.length % 2 == 1) {
			return true;
		}

		return sumOfFruitNums(fruitNums) % 2 == 1;
	}

	private static int sumOfTwoFruitNums(int[] fruitNums) {
		int num1 = 0;
		int num2 = 0;

		for (int num : fruitNums) {
			if (num > 0) {
				if (num1 == 0) {
					num1 = num;
				} else {
					num2 = num;
					break;
				}
			}
		}

		return num1 + num2;
	}

	private static int sumOfFruitNums(int[] fruitNums) {
		int sum = 0;

		for (int num : fruitNums) {
			sum += num;
		}

		return sum;
	}
}
