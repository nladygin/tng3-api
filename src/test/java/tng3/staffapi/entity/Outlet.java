package tng3.staffapi.entity;

import tng3.base.Entity;

import java.util.HashMap;
import java.util.List;

public class Outlet implements Entity {

    public int id;
    public String name;
    public HashMap<String, Float> coord;
    public String phone;
    public String email;
    public String twitter;
    public String vk;
    public String facebook;
    public String instagram;
    public String description;
    public String workHours;
    public List<String> images;
    public String logo;

}
