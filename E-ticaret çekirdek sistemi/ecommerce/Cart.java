package ecommerce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {
    private final List<Product> items;
    private String appliedCoupon;

    public Cart() {
        this.items = new ArrayList<>();
        this.appliedCoupon = null;
    }

    public void add(Product p) {
        if (p == null) {
            System.out.println("Sepete olmayan bişe eklenemez.");
        }
        this.items.add(p);
    }

    public void add(Product p, int qty) {
        if (p == null) {
            System.out.println("Sepete olmayan bişe eklenemez");
        }
        if (qty < 1) {
            System.out.println("en az bir adet bişe olmali");
        }
        for (int i = 0; i < qty; i++) {
            this.items.add(p);
        }
    }

    public void remove(Product p) {
        this.items.remove(p);
    }

    public List<Product> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    public double subtotal() {
        double subtotal = 0.0;
        for (Product p : this.items) {
            subtotal += p.getPrice();
        }
        return subtotal;
    }

    public double total() {
        double total = 0.0;
        for (Product p : this.items) {
            total += p.finalPrice();
        }

        if (this.appliedCoupon != null) {
            if (this.appliedCoupon.equals("SAVE10")) {
                total *= 0.90;
            } else if (this.appliedCoupon.equals("BELES")) {
                total -= 100.0;
            }
        }
        return Math.max(0, total);

    }
    public void applyCoupon(String code) {
            if (code.equals("SAVE10") || code.equals("BELES")) {
                this.appliedCoupon = code;
                System.out.println("'" + code + "' kupon uygulandi");
            } else {
                System.err.println("böle bi kod yok");
            }
    }

    @Override
        public String toString() {
            int urunSayisi = this.items.size();
            double toplamTutar = this.total();
            
            return "Sepet [Ürün Sayisi: " + urunSayisi + ", Toplam Tutar: " + toplamTutar + " TL]";
        }
}

