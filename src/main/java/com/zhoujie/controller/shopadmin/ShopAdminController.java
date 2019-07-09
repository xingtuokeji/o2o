package com.zhoujie.controller.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shopadmin")
public class ShopAdminController {

    @RequestMapping("/shopoperation")
    public String shopOperation(){
        return "shop/shopoperation";
    }
}
