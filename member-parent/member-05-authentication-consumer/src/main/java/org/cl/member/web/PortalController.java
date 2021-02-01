package org.cl.member.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description:
 * @Author: CL
 * @Date: 2021/1/26 12:27
 * @Version: 1.0
 */
@Controller
public class PortalController {


    @GetMapping(value="/")
    public String showProtalPage(){
        // TODO 加载数据的逻辑
        return "portal";
    }
}
