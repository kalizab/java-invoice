package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	private Map<Product, Integer> products = new HashMap<>();


	public void addProduct(Product product) {
		this.addProduct(product, 1);
	}

	public void addProduct(Product product, Integer quantity) {
		if (quantity == null || quantity <= 0) {
			throw new IllegalArgumentException("Product quantity cannot be null, zero or smaller then 0");
		}
		this.products.put(product, quantity);
	}

	public BigDecimal getSubtotal() {
		BigDecimal subtotalValue = new BigDecimal(0);
		for (Product product : this.products.keySet()) {
			Integer quantity = this.products.get(product);
			subtotalValue = subtotalValue.add(product.getPrice().multiply(new BigDecimal(quantity)));
		}
		return subtotalValue;
	}

	public BigDecimal getTax() {
		
		return getTotal().subtract(getSubtotal());
	}

	public BigDecimal getTotal() {
		BigDecimal totalValue = new BigDecimal(0);
		for (Product product : this.products.keySet()) {
			Integer quantity = this.products.get(product);
			totalValue = totalValue.add(product.getPriceWithTax().multiply(new BigDecimal(quantity)));
		}
		return totalValue;
	}
}
