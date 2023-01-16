package fileReadAndWrite;

public class Customer implements IModel<Customer> {
    private long id;
    private String name;

    public Customer() {
    }

    public Customer(long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return String.format("%s,%s", this.id, this.name);
    }


    @Override
    public Customer parseData(String line) {
        String[] items = line.split(",");
        long id = Long.parseLong(items[0]);
        Customer customer = new Customer(id, items[1]);
        return customer;
    }
}
