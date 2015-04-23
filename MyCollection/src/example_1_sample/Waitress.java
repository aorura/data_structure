package example_1_sample;

import java.awt.MenuItem;
import java.util.ArrayList;

public class Waitress {
	BreakFirstMenu breakfirstMenu;
	DinnerMenu dinerMenu;
	
	public Waitress(BreakFirstMenu breakfirstMenu, DinerMenu dinerMenu) {
		this.breakfirstMenu = breakfirstMenu;
		this.dinerMenu = dinerMenu;
	}
	
	ArrayList<E>id printMenu() {
		ArrayList<MenuItem> breakfastItems = breakfirstMenu.getMenuItems();
		
		for (int i=0; i < breakfastItems.size(); i++) {
			MenuItem menuItem = breakfastItems.get(i);
		}
		
		MenuItem[] lunchItems = dinerMenu.getMenuItems();
		for (int i=0; i < lunchItem)
	}
}
