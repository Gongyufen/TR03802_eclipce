package tr03802_web;
import java.util.ArrayList;
import java.util.List;

/**
 * 仓库
 * @author LiZanhong
 *
 */
public class Store {
	public static List<Product> products;
	static {
		products = new ArrayList<>();
		products.add(new Product(1, "波司登羽绒服", 2000, 110));
		products.add(new Product(2, "立白小麻雀", 12, 50));
		products.add(new Product(3, "华为Mate60 Pro", 6999, 100));
		products.add(new Product(4, "iPhone15 Max", 2000, 110));
		products.add(new Product(5, "特斯拉ModelY", 390000, 10));
		products.add(new Product(6, "雷鸟电视机85", 5999, 110));
	}
}