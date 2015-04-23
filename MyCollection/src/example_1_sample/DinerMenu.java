package example_1_sample;

public class DinerMenu {
	static fina int MAX_ITEMS = 6;
	
	int numberOfItems = 0;
	MenuItem[] menuItems;
	
	
	public DinerMenu() {
		menuItems = new MenuItem[MAX_ITEMS];
		
		addItem("ä�������ڿ� BLT", "��� ���� ������ ...�޴�", true, 2.99);
		addItem("BLT", "��� ���� ������ ....�޴�", false, 2.99);
		addItem("������ ����", "������ ����....�޴�", false, 3.99);
	}
	
	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		if (numberOfItems >= MAX_ITEMS) {
			System.err.println("�˼��մϴ�");
		}
	}
}
