package arraylist;

import java.util.Arrays;

/**
 *  ʹ������ ���ֶ���װһ��ArrayList
	(1)���Ԫ��
	(2)ɾ��Ԫ��(��������ɾ��,�����±�ɾ��)
	(3)����Ԫ��
	(4)����Ԫ��(ͨ���±����,ͨ��Ԫ�����ݲ���)
	(5)�Զ�����

 *
 */
public class MyArrayList {
//	����һ���ַ�������
	private String [] arr;
//	���峤��
	private int count;
//	�ж����������Ƿ����
	private int size = 0;
	
	
	
//	�������鳤��
	public MyArrayList(int count) {
		this.count = count;
		arr = new String[count];
	}
	public MyArrayList() {
		arr = new String[10];
	}
	
	/**
	 * ���Ԫ��
	 * @param str
	 * @return
	 */
	public boolean add(String str) {
		//�����Ƿ����ݺ���
		addLength();
		this.arr[size] = str;
		//ÿ���һ��ֵsize+1,Ҳ���ж����ݵ�����
		size ++;
		
		return true;
	}
	/**
	 * �Զ�����
	 */
	private void addLength() {
		//�ж�size�Ƿ�������鳤��,�������鳤�����Զ�����
		if (size == arr.length) {
			//arr ����Ŀ�꺯��,  arr.length*2 ��������
			String [] arr01 = Arrays.copyOf(arr, arr.length*2);
			//�����ƺ�����ֵ��ԭ����
			arr = arr01;
		}
		
	}
	
	
	//��ȡԪ�ظ���
	public int getSize() {
		
		return size;
	}
	
	/**
	 * ͨ���±� ����Ԫ��
	 * @param index
	 * @return
	 */
	public String get(int index) {
		//�ж��±��Ƿ������鷶Χ��
		if (index < 0 ||index >= size) {
			System.out.println("�±�Խ��");
			return null;
		}
		return this.arr[index];
		
	}
	/**
	 * ͨ��Ԫ�ز����±�
	 * @param str
	 * @return
	 */
	public int get(String str) {
		//�����±����
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			String s = arr[i];
			//�ж�str�Ƿ����s
			if (str.equals(s)) {
				index = i;
			}
		}
		return index;
	}
	
	
	/**
	 * �����±�ɾ��Ԫ��
	 * [1][3][4][5][6][7][8][9][10][10]
	 */
	public void remove(int index) {
		//�ж��±��Ƿ�Ϸ�������
		for (int i = index; i < arr.length-1; i++) {
			arr[i] = arr[i+1];
		}
		//ɾ��һ��ֵ��������ֵ�±���ǰ�ƶ������һ����Ϊnull
		arr[arr.length - 1] = null;
		size --;
	}
	/**
	 * ��������ɾ��Ԫ��[1][2][3][][][]
	 */
	public void remove(String str) {
		int index = -1;
		for (int i = 0; i < size; i++) {
			String s = arr[i];
			if (s.equals(str)) {
				index = i;
			}
		}
		if (index >= 0) {
			remove(index);
		}else {
			System.out.println("��Ҫɾ����Ԫ�ز�����");
		}
		
	}
	
	/**
	 * ��1����9����2����3����4����������
	 * @param index  �����λ��
	 * @param str  ��Ҫ�����Ԫ��
	 */
	public int insert(int index,String str) {
		int flg = -1;
		//�ж��±�ĺϷ���
		if (index < 0 || index > size) {
			System.out.println("������±겻�Ϸ�");
		}else{
			
			//�±�Ϸ�
			addLength();
			for (int i = size; i > index; i--) {
				arr[i] = arr[i-1];
			}
			arr[index] = str;
			flg = 1;
		}
		size ++;	
		return flg;
	}
	
}
