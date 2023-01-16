package fileReadAndWrite;

public class Product implements IModel<Product>{
    private long id;
    private String name;
    private long price;

    public Product() {
    }

    public Product(long id, String name, long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public Product parseData(String line) {
        String [] items = line.split(",");
        long idProduct = Long.parseLong(items[0]);
        String name = items[1];
        long price = Long.parseLong(items[2]);
        Product p = new Product(idProduct, name, price);

        return p;
    }
}
