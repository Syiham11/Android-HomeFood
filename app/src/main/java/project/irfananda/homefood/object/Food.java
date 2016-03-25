package project.irfananda.homefood.object;

/**
 * Created by irfananda on 22/03/16.
 */
public class Food {

    private int img;
    private String name;
    private long price;
    private boolean ordered;
    private String seller;
    private String time;
    private int notif;
    private int quantity;

    public Food(int img, String name, long price, boolean ordered, String seller) {
        this.img = img;
        this.name = name;
        this.ordered = ordered;
        this.price = price;
        this.seller = seller;
    }

    public Food(int img, String name, long price, int notif, String seller, String time, int quantity) {
        this.img = img;
        this.name = name;
        this.notif = notif;
        this.price = price;
        this.seller = seller;
        this.time = time;
        this.quantity = quantity;
    }

    public Food(int img, String name, long price, int quantity, String seller) {
        this.img = img;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.seller = seller;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getNotif() {
        return notif;
    }

    public void setNotif(int notif) {
        this.notif = notif;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
