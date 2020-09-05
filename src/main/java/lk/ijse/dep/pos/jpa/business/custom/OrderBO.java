package lk.ijse.dep.pos.jpa.business.custom;

import lk.ijse.dep.pos.jpa.business.SuperBO;
import lk.ijse.dep.pos.jpa.util.OrderDetailTM;
import lk.ijse.dep.pos.jpa.util.OrderTM;

import java.util.List;

public interface OrderBO extends SuperBO {

    public String getNewOrderId() throws Exception;

    public void placeOrder(OrderTM order, List<OrderDetailTM> orderDetails)throws Exception;
}
