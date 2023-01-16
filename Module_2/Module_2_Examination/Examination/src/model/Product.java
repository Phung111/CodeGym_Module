package model;

public class Product implements IModel<Product>, ISearch<Product> {
    private long id;
    private String name;
    private long price;
    private long amount;
    private String description;

    public Product() {
    }

    public Product(long id, String name, long price, long amount, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.description = description;
    }

    public long getId() {
        return id;
    }



    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void update(Product objNew) {
        this.id = objNew.getId();
        this.name = objNew.getName();
        this.price = objNew.getPrice();
        this.amount = objNew.getAmount();
        this.description = objNew.getDescription();
    }
    @Override
    public Product parseData(String line) {
        String[] items = line.split(",");
        long id = Long.parseLong(items[0]);
        String name = items[1];
        long price = Long.parseLong(items[2]);
        long amount = Long.parseLong(items[3]);
        String description = items[4];

        Product product = new Product(id, name, price, amount, description);
        return product;
    }
    @Override
    public String toString(){
    //1,Dien Thoai,1000000,10,none
        return String.format("%s,%s,%s,%s,%s", this.id, this.name, this.price, this.amount, this.description);
    }
}
