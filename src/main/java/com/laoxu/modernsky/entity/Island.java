package com.laoxu.modernsky.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Island extends AbsSuperObject {
    private String id;
    private String name;
    private String people;
    private String title;
}
