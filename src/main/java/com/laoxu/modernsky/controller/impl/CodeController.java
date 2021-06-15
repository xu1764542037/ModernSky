package com.laoxu.modernsky.controller.impl;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value ="/code",method = RequestMethod.POST)
public class CodeController {

    @RequestMapping(value = "/getCode", method = RequestMethod.POST)
    public String getCode() {
        int oneNumber = (int)(Math.random()*10);
        int twoNumber = (int)(Math.random()*10);
        int threeNumber = (int)(Math.random()*10);
        int fourNumber = (int)(Math.random()*10);

        String code = ""+oneNumber+""+twoNumber+""+threeNumber+""+fourNumber+"";

//        codeService.sendCode(code);
        return code;
    }
}
