package lk.ijse.dep.pos.jpa.dao.custom;

import lk.ijse.dep.pos.jpa.dao.CrudDAO;
import lk.ijse.dep.pos.jpa.entity.Order;

public interface OrderDAO extends CrudDAO<Order, String> {

    String getLastOrderId() throws Exception;

}
