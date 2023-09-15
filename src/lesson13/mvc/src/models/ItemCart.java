package models;

public class ItemCart {

    private int goodId;
    private int userId;
    private int count;
    private String title;
    private int price;

    public ItemCart(int goodId, int userId, int count, String title, int price) {
        this.goodId = goodId;
        this.userId = userId;
        this.count = count;
        this.title = title;
        this.price = price;
    }

    public int getGoodId() {
        return goodId;
    }

    public int getUserId() {
        return userId;
    }

    public int getCount() {
        return count;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }


}
