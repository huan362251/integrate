package org.example;

import lombok.Data;

import java.io.Serializable;

@Data
public class TestEntity implements Serializable {
    private static final long serialVersionUID = 987L;

    private String name;

}
