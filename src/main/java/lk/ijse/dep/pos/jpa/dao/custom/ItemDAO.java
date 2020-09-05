package lk.ijse.dep.pos.jpa.dao.custom;

import lk.ijse.dep.pos.jpa.dao.CrudDAO;
import lk.ijse.dep.pos.jpa.entity.Item;

public interface ItemDAO extends CrudDAO<Item, String> {

    String getLastItemCode() throws Exception;

}
