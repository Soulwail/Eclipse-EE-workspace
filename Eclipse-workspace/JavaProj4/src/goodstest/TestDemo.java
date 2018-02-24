package goodstest;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import goods.Goods;
import goods.GoodsManage;
import goods.ShoppingCart;

public class TestDemo {
	static GoodsManage goodsManage = new GoodsManage();
	ShoppingCart shoppingCart = new ShoppingCart();

	public void mainMenu() {
		System.out.println("***********************************");
		System.out.println("             **���˵�**");
		System.out.println("             1--��Ʒ����");
		System.out.println("             2--���ﳵ");
		System.out.println("             0--�˳�");
		System.out.println("***********************************");
		System.out.println("�������Ӧ���ֽ��в�����");
	}

	public void goodsMan() {
		System.out.println("*****************************************************");
		System.out.println("                 **��Ʒ����**");
		System.out.println("                1--��Ʒ��Ϣ����");
		System.out.println("                2--��ʾ������Ʒ��Ϣ");
		System.out.println("                9--������һ���˵�");
		System.out.println("*****************************************************");
		System.out.println("�������Ӧ�����ֶ���Ʒ���й�����");

		TestDemo test = new TestDemo();
		Scanner scr = new Scanner(System.in);
		int i;

		do {
			i = scr.nextInt();

			if (i == 9 || i == 1 || i == 2) {
				switch (i) {
				case 1:
					System.out.println("��Ʒ��Ϣ����");
					goodsManage.importGoods(); // ��Ʒ��Ϣ����
					goodsMan();
					break;
				case 2:
					if (goodsManage.getGoodsSet().isEmpty()) {
						System.out.println("��û����Ʒ���ǵõ�����Ʒ��ϢӴ��");
					} else {
						System.out.println("��ʾ������Ʒ��Ϣ");
						goodsManage.displayAllGoods(); // ��ʾ������Ʒ��Ϣ
					}
					goodsMan();
					break;
				case 9:
					main(null);
					break;
				}

			} else {
				System.out.println("������û�ж�Ӧ�Ĳ�����");
			}

		} while (i != 9);

	}

	public void shoppingCartMan() {

		System.out.println("*****************************************************");
		System.out.println("                 **���ﳵ����**");
		System.out.println("                1--������Ʒ�����ﳵ");
		System.out.println("                2--�޸Ĺ��ﳵ�е���Ʒ����");
		System.out.println("                3--��ʾ���ﳵ�е�������Ʒ");
		System.out.println("                4--����");
		System.out.println("                9--������һ���˵�");
		System.out.println("*****************************************************");
		System.out.println("�������Ӧ�����ֶԹ��ﳵ���в�����");

		TestDemo test = new TestDemo();
		Scanner scr2 = new Scanner(System.in);
		int i;

		do {
			i = scr2.nextInt();

			if (i == 1 || i == 2 || i == 3 || i == 4 || i == 9) {
				switch (i) {
				case 1:
					System.out.println("������Ʒ�����ﳵ");
					if (goodsManage.getGoodsSet().isEmpty()) { // �ж���Ʒ��Ϣ�Ƿ���
						System.out.println("��û����Ʒ���ǵõ�����Ʒ��ϢӴ��");
					} else {
						goodsManage.displayAllGoods();
						shoppingCart.addGoodsToCart(goodsManage); // ������Ʒ�����ﳵ
					}
					shoppingCartMan();
					break;
				case 2:
					shoppingCart.updateNumInCart(); // �޸Ĺ��ﳵ�е���Ʒ����
					shoppingCartMan();
					break;
				case 3:
					System.out.println("��ʾ���ﳵ��������Ʒ��Ϣ");
					shoppingCart.displayAllInCart(); // ��ʾ���ﳵ��������Ʒ��Ϣ
					shoppingCartMan();
					break;
				case 4:
					System.out.println("���㣺");
					shoppingCart.settleAccounts(); // ����
					shoppingCartMan();
					break;
				case 9:
					main(null);
					break;
				}
			} else {
				System.out.println("������û�ж�Ӧ�Ĳ�����");
			}

		} while (i != 9);

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		TestDemo test = new TestDemo();
		test.mainMenu();
		int x;

		try {
			x = sc.nextInt();
			if (x >= 0 && x <= 2) {
				switch (x) {
				case 0:
					break;
				case 1:
					test.goodsMan();
					break;
				case 2:
					test.shoppingCartMan();
					break;
				}

			} else {
				System.out.println("������û�ж�Ӧ�Ĳ�����");
				main(null);
			}

		} catch (InputMismatchException e) {
			System.out.println("����Ĳ��������������¿�ʼ!");
			 main(null);
		} catch (Exception e) {
			System.out.println("�����ˣ�����");
		}

	}
}