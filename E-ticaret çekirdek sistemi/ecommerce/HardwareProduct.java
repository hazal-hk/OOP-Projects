package ecommerce;

public class HardwareProduct extends Product {
    public static final double TAX_FEE = 15.50;

    private String brand;
    private String manufacturer;

    public HardwareProduct(String name, double price, String sku, String brand, String manufacturer){
        super(name, price, sku);
        this.setBrand(brand);
        this.setManufacturer(manufacturer);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand==null) {
            System.out.println("Marka adi boş olamaz");
        }
        this.brand = brand;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        if (manufacturer==null) {
            System.out.println("Üretici adi boş olamaz");
        }
        this.manufacturer = manufacturer;
    }

    @Override
    public double finalPrice() {
        return super.finalPrice() + TAX_FEE;
    }

    @Override
    public String toString() {
        return String.format("Hardware [SKU: %s, Name: %s, Manufacturer: %s, Base Price: %.2f]", 
                                getSku(), getName(), this.manufacturer, getPrice());
    }

}

