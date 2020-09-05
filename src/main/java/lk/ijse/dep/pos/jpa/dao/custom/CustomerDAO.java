package lk.ijse.dep.pos.jpa.dao.custom;

import lk.ijse.dep.pos.jpa.dao.CrudDAO;
import lk.ijse.dep.pos.jpa.entity.Customer;

public interface CustomerDAO extends CrudDAO<Customer,String> {

    String getLastCustomerId() throws Exception;

}
