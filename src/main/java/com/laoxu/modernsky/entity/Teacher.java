package com.laoxu.modernsky.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Teacher extends AbsSuperObject {
    private String id;
    private String name;
    private String jobNumber;
}
