package tng3.common.entity;

import tng3.base.Entity;

import java.util.Map;

public class Offer implements Entity {

    public int id;
    public String folder;
    public int folderId;
    public String folderImage;
    public String name;
    public String description;
    public int duration;
    public float price;
    public boolean pakkage;
    public String type;
    public int primaryOutletId;
    public String image;
    public String offerClass;;
    public Map<String, Integer> comboItems;

}
