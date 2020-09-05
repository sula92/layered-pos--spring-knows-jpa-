package lk.ijse.dep.pos.jpa.business.custom.impl;

import lk.ijse.dep.pos.jpa.business.custom.CustomerBO;
import lk.ijse.dep.pos.jpa.dao.custom.CustomerDAO;
import lk.ijse.dep.pos.jpa.entity.Customer;
import lk.ijse.dep.pos.jpa.util.CustomerTM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class CustomerBOImpl implements CustomerBO {

    // Field Injection
    @Autowired
    private CustomerDAO customerDAO;

    @Transactional(readOnly = true)
    public List<CustomerTM> getAllCustomers() throws Exception {

        List<Customer> allCustomers = null;

            allCustomers = customerDAO.findAll();


        List<CustomerTM> customers = new ArrayList<>();
        for (Customer customer : allCustomers) {
            customers.add(new CustomerTM(customer.getId(), customer.getName(), customer.getAddress()));
        }
        return customers;
    }

    public void saveCustomer(String id, String name, String address) throws Exception {


            customerDAO.save(new Customer(id, name, address));

    }

    public void deleteCustomer(String customerId) throws Exception {

            customerDAO.delete(customerId);

    }

    public void updateCustomer(String name, String address, String customerId) throws Exception {

            customerDAO.update(new Customer(customerId, name, address));

    }

    @Transactional(readOnly = true)
    public String getNewCustomerId() throws Exception {


        String lastCustomerId = null;


        if (lastCustomerId == null) {
            return "C001";
        } else {
            int maxId = Integer.parseInt(lastCustomerId.replace("C", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "C00" + maxId;
            } else if (maxId < 100) {
                id = "C0" + maxId;
            } else {
                id = "C" + maxId;
            }
            return id;
        }
    }

}
