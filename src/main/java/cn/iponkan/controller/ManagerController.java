package cn.iponkan.controller;

import cn.iponkan.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ManagerController extends BaseController{

    @Autowired
    private ManagerService managerService;

    @RequestMapping(value = "/index")
    @ResponseBody
    public String index() {
        return managerService.getJson(1);
    }

}
