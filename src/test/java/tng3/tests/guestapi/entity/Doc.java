package tng3.tests.guestapi.entity;

import tng3.base.Entity;
import tng3.common.entity.Outlet;

import java.util.List;


public class Doc implements Entity {

    public String date;
    public Outlet outlet;
    public Double total;
    public Double discount;
    public String image;
    public long id;
    public List<DocAccount> accounts;

}
