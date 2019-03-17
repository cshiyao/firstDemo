package arraylist;

import java.util.Arrays;

/**
 *  使用数组 来手动封装一个ArrayList
	(1)添加元素
	(2)删除元素(按照内容删除,按照下标删除)
	(3)插入元素
	(4)查找元素(通过下标查找,通过元素内容查找)
	(5)自动扩容

 *
 */
public class MyArrayList {
//	定义一个字符串数组
	private String [] arr;
//	定义长度
	private int count;
//	判断数组容量是否多余
	private int size = 0;
	
	
	
//	定义数组长度
	public MyArrayList(int count) {
		this.count = count;
		arr = new String[count];
	}
	public MyArrayList() {
		arr = new String[10];
	}
	
	/**
	 * 添加元素
	 * @param str
	 * @return
	 */
	public boolean add(String str) {
		//调用是否扩容函数
		addLength();
		this.arr[size] = str;
		//每添加一个值size+1,也是判断扩容的依据
		size ++;
		
		return true;
	}
	/**
	 * 自动扩容
	 */
	private void addLength() {
		//判断size是否等于数组长度,等于数组长度则自动扩容
		if (size == arr.length) {
			//arr 复制目标函数,  arr.length*2 副本长度
			String [] arr01 = Arrays.copyOf(arr, arr.length*2);
			//将复制函数赋值给原函数
			arr = arr01;
		}
		
	}
	
	
	//获取元素个数
	public int getSize() {
		
		return size;
	}
	
	/**
	 * 通过下标 查找元素
	 * @param index
	 * @return
	 */
	public String get(int index) {
		//判断下标是否在数组范围内
		if (index < 0 ||index >= size) {
			System.out.println("下标越界");
			return null;
		}
		return this.arr[index];
		
	}
	/**
	 * 通过元素查找下标
	 * @param str
	 * @return
	 */
	public int get(String str) {
		//定义下标变量
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			String s = arr[i];
			//判断str是否等于s
			if (str.equals(s)) {
				index = i;
			}
		}
		return index;
	}
	
	
	/**
	 * 按照下标删除元素
	 * [1][3][4][5][6][7][8][9][10][10]
	 */
	public void remove(int index) {
		//判断下标是否合法待补充
		for (int i = index; i < arr.length-1; i++) {
			arr[i] = arr[i+1];
		}
		//删除一个值后，其他数值下标往前移动，最后一个变为null
		arr[arr.length - 1] = null;
		size --;
	}
	/**
	 * 按照内容删除元素[1][2][3][][][]
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
			System.out.println("所要删除的元素不存在");
		}
		
	}
	
	/**
	 * 【1】【9】【2】【3】【4】【】【】
	 * @param index  插入的位置
	 * @param str  所要插入的元素
	 */
	public int insert(int index,String str) {
		int flg = -1;
		//判断下标的合法性
		if (index < 0 || index > size) {
			System.out.println("插入的下标不合法");
		}else{
			
			//下标合法
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
