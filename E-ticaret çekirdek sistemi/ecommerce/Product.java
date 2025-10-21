package ecommerce;

public class Product {
    private String name;
    private double price;
    private String sku;


    public static final double VAT_RATE = 0.20;

    private static int productCount = 0;

    public Product(String name, double price, String sku) {
        this.setName(name);
        this.setPrice(price);
        this.setSku(sku);
        productCount++;
    }

    public Product(String name, double price) {
        this.setName(name);
        this.setPrice(price);
        productCount++;

        this.sku = "Sku" + productCount;
    }

    public double finalPrice() {
        return this.price * (1 + VAT_RATE);
    }

    public void applyDiscount(int percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Böyle indirim mi olur be");
            return;
        }
        double discountTotal = 1.0 - (percent / 100.0);
        this.setPrice(this.price * discountTotal);
    }

    public void applyDiscount(double amount) {
        if (amount < 0 || amount > this.price) {
            System.out.println("böyle indirim olmaz kardesim");
            return;
        }
        this.setPrice(this.price - amount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name==null) {
            System.out.println("ismi olmayan ürün mü olur");
        }
        this.name=name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Bir de sana para mi vercem");
        }
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        if(sku==null) {
            System.out.println("Sku boş olamaz");
        }
        this.sku = sku;
    }

    public static int getProductCount() {
        return productCount;
    }

    @Override
    public String toString() {
        return String.format("Product [SKU: %s, Name: %s, Base Price: %.2f]", this.sku, this.name, this.price);
    }
}


