package models;

public class Good {

    private long id;
    private String title;
    private double price;
    private String info;
    private String photo;

    public Good(long id, String title, double price, String info, String photo) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.info = info;
        this.photo = photo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", info='" + info + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
