package arraylist;

public class Test {
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		for (int i = 0; i < 4; i++) {
			list.add(i+"");
		}
		
//		System.out.println(list.getSize());
//		System.out.println(list.get(99));
//		System.out.println(list.get(100));
//		list.remove("20");
//		System.out.println(list.get("20"));
		
		
		list.insert(2, "*");
		list.remove(1);
		for (int i = 0; i < list.getSize(); i++) {
			System.out.println(list.get(i));
		}

	}
}
