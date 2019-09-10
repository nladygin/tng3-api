package tng3.api.entity;


import tng3.api.Utils;

public interface Entity {

    String salt = new Utils().generateSalt();

    String asJsonString();
}
