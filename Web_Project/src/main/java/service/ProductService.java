package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import model.Product;

public class ProductService {

	public ArrayList<Product> sortProductListBy(ArrayList<Product> list, String sortBy) {

		if (list == null || list.isEmpty()) {
			return list;
		}

		switch (sortBy) {
		case "price_asc":
			Collections.sort(list, new Comparator<Product>() {
				@Override
				public int compare(Product o1, Product o2) {
					return Double.compare(o1.getPrice(), o2.getPrice());
				}
			});
			break;

		case "price_desc":
			Collections.sort(list, new Comparator<Product>() {
				@Override
				public int compare(Product o1, Product o2) {
					return Double.compare(o2.getPrice(), o1.getPrice());
				}
			});
			break;

		case "newest":
			Collections.sort(list, new Comparator<Product>() {
				@Override
				public int compare(Product o1, Product o2) {
					return Double.compare(o2.getId(), o1.getId());
				}
			});
			break;
			
		case "name_asc":
            Collections.sort(list, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return o1.getTitle().compareToIgnoreCase(o2.getTitle());
                }
            });
            break;

        case "name_desc":
            Collections.sort(list, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return o2.getTitle().compareToIgnoreCase(o1.getTitle());
                }
            });
            break;

		default:
			break;
		}
		return list;
	}
}
