package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
	private final String name;

	private final BigDecimal price;

	private final BigDecimal taxPercent;
	public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);


	protected Product(String name, BigDecimal price, BigDecimal tax) {
		
	    if (name == null || name.isEmpty()) {
	        throw new IllegalArgumentException("Product name cannot be null!");
        }
	    if (price == null || price.compareTo(new BigDecimal(0)) <0)  {
			throw new IllegalArgumentException("Product price cannot be 0");
		}
		
		this.name = name;
		this.price = price;
		this.taxPercent = tax;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public BigDecimal getTaxPercent() {
		return taxPercent;
	}

	public BigDecimal getPriceWithTax() {
		
	    return price.multiply(taxPercent).add(price);
	}
}
