package com.laoxu.modernsky.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Student extends AbsSuperObject {
    private String id;
    private String name;
    private String number;
    private String className;
    private String year;
    private String branch;
    private String major;
}
