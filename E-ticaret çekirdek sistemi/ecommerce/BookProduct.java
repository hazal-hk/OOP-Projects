package ecommerce;

public class BookProduct extends Product {
    public static final double BOOK_VAT_RATE = 0.10;

    private String author;
    private int pageCount;

    public BookProduct(String name, double price, String sku, String author, int pageCount) {
        super(name, price, sku);
        this.setAuthor(author);
        this.setPageCount(pageCount);
    }

    public BookProduct(String name, double price, String author) {
        super(name, price);
        this.setAuthor(author);
        this.pageCount = 1;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author==null) {
            System.out.println("bi yazani yok mu bu kitabin");
        }
        this.author = author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        if (pageCount < 1) {
            System.out.println("var olmayan bir kitap mi bu neden sayfasi yok");
        }
        this.pageCount = pageCount;
    }

    @Override
    public double finalPrice() {
        return this.getPrice() * (1+BOOK_VAT_RATE);
    }

    @Override
    public String toString() {
        return String.format("Book [SKU: %s, Name: %s, Author: %s, Base Price: %.2f]", 
                             getSku(), getName(), this.author, getPrice());
    }
}

