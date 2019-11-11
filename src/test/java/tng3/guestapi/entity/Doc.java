package tng3.guestapi.entity;

import tng3.base.Entity;
import tng3.entity.Outlet;

import java.util.List;


public class Doc implements Entity {

    public String date;
    public Outlet outlet;
    public Double total;
    public Double discount;
    public String image;
    public int id;
    public List<DocAccount> accounts;

}
