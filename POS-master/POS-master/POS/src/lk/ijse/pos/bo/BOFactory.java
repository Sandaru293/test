package lk.ijse.pos.bo;

import lk.ijse.pos.bo.impl.CustomerBOImpl;
import lk.ijse.pos.bo.impl.ItemBOImpl;
import lk.ijse.pos.bo.impl.PurchaseOrderBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){}

    public static BOFactory getInstance(){
        if (boFactory == null){
            boFactory= new BOFactory();
        }
        return boFactory;
    }
    public enum BOType{
        CUSTOMER,ITEM,PURCHASEORDER;
    }

    public SuperBO getBO(BOType boType){
        switch (boType){
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case PURCHASEORDER:
                return new PurchaseOrderBOImpl();
            default:
                return null;
        }
    }
}
