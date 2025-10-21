package ecommerce;

public class DigitalProduct extends Product {

    public static final double DL_FEE = 0.99;

    private double fileSizeMB;
    private String downloadUrl;

    public DigitalProduct(String name, double price, String sku, double fileSizeMB, String downloadUrl) {
        super(name, price, sku);
        this.setFileSizeMB(fileSizeMB);
        this.setDownloadUrl(downloadUrl);
    }

    public double getFileSizeMB() {
        return fileSizeMB;
    }

    public void setFileSizeMB(double fileSizeMB) {
        if (fileSizeMB < 0) {
            System.out.println("Dosya boyutu negatif olamaz");
        }
        this.fileSizeMB = fileSizeMB;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        if (downloadUrl == null) {
            System.out.println("İndirme URL'si boş olamaz.");
        }
        this.downloadUrl = downloadUrl;
    }

    @Override
    public double finalPrice() {
        return super.finalPrice() + DL_FEE;
    }

    @Override
    public String toString() {
        return String.format("Digital [SKU: %s, Name: %s, Size: %.1fMB, Base Price: %.2f]", 
                             getSku(), getName(), this.fileSizeMB, getPrice());
    }
}

