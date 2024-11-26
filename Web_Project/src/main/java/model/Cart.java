package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private List<Item> items;

	public Cart() {
		items = new ArrayList<Item>();
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item getItemById(int id) {
		for (Item item : items) {
			if (item.getProduct().getId() == id) {
				return item;
			}
		}
		return null;
	}

	public int getQuantityById(int id) {
		return getItemById(id).getQuantity();
	}

	// Thêm vào cart
	public void addItem(Item t) {
		if (getItemById(t.getProduct().getId()) != null) {
			Item m = getItemById(t.getProduct().getId());
			// Nếu có rùi thì chỉ cần set lại số lượng
			m.setQuantity(m.getQuantity() + t.getQuantity());
		} else {
			// chưa có thì chỉ cần thêm vô
			items.add(t);
		}

	}

	public void removeItem(int id) {
		if (getItemById(id) != null) {
			items.remove(getItemById(id));
		}
	}

	public double geTotalMoney() {
		double t = 0;
		for (Item item : items) {
			t += (item.getQuantity() * item.getPrice());
		}
		return t;
	}

//	public static void main(String[] args) {
//		Item t = new Item(new Product(1, "vong1"), 1, 20);
//		Cart c = new Cart();
//		c.addItem(t);
//		c.addItem(t);
//		c.addItem(t);
//		for (Item i : c.getItems()) {
//			System.out.println(i.toString());
//		}
//	}

}
