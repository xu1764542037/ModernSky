package com.laoxu.modernsky.entity;


import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserAndActor {
    private User  user_id;
    private Actor actor_id;
}
