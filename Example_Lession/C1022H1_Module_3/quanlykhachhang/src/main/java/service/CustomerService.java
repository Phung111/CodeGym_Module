import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Customer;

public class CustomerService {
    private List<Customer> customers;
    customers = new ArrayList<>();

    //Customer(Long id, String name, Date createdAt, String address, String image) {

        customers.add(new Customer(1L, "Quang Dang", new Date(), "28 NTP", null));
        customers.add(new Customer(2L, "Huu Nghia", new Date(), "28 NTP", null));
        customers.add(new Customer(3L, "Thanh Nhan", new Date(), "28 NTP", null));
        customers.add(new Customer(4L, "Bich Thuy", new Date(), "28 NTP", null));
}
