package com.smartapps.loginwithspring.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test")
public class UserApiController {
    @GetMapping("/test")
    public String testEndpoint(){
        return "testEndpoint";
    }

}
