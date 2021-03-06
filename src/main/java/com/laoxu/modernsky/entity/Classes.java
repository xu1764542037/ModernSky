package com.laoxu.modernsky.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Classes extends AbsSuperObject {
    private int id;
    private String branch;
    private String major;
    private String className;
    private int year;
}
