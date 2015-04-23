package example_1_sample;

public class DinerMenu {
	static fina int MAX_ITEMS = 6;
	
	int numberOfItems = 0;
	MenuItem[] menuItems;
	
	
	public DinerMenu() {
		menuItems = new MenuItem[MAX_ITEMS];
		
		addItem("채식주의자용 BLT", "통밀 위에 베이컨 ...메뉴", true, 2.99);
		addItem("BLT", "통밀 위에 베이컨 ....메뉴", false, 2.99);
		addItem("오늘의 스프", "오늘의 스프....메뉴", false, 3.99);
	}
	
	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		if (numberOfItems >= MAX_ITEMS) {
			System.err.println("죄송합니다");
		}
	}
}
