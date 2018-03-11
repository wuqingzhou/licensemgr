package com.teligen.licensemgr.controller;

import com.teligen.licensemgr.entity.TbLicense;
import com.teligen.licensemgr.service.TbLicenseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tk.mybatis.mapper.entity.Condition;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/license")
public class LicenseController {
    private final static Logger logger = LoggerFactory.getLogger(LicenseController.class);
    @Autowired
    private TbLicenseService tbLicenseService;

    /**
     * 列表展示
     */
    @RequestMapping("/list")
    public String index(ModelMap model, Map map) {
        String province = (String) map.get("province");
        String city = (String) map.get("city");
        String clusterName = (String) map.get("clusterName");

        Condition condition = new Condition(TbLicense.class);
        condition.setOrderByClause("create_time desc");
        if(!StringUtils.isEmpty(province)){
            condition.or().andEqualTo("province", province);
        }
        if(!StringUtils.isEmpty(city)){
            condition.or().andEqualTo("city", city);
        }
        if(!StringUtils.isEmpty(clusterName)){
            condition.or().andLike("clusterName", clusterName);
        }

        List<TbLicense> licenseList = tbLicenseService.selectByCondition(condition);
        model.addAttribute("licenseList", licenseList);
        return "/license/list";
    }

    /**
     * 跳转到添加页面
     */
    @RequestMapping("/gotoAdd")
    public String gotoAdd(ModelMap model) {
        return "/license/add";
    }

    /**
     * 添加操作
     */
    @RequestMapping("/add")
    public String add(RedirectAttributes model, TbLicense tbLicense) {
        tbLicenseService.insertSelective(tbLicense);
        model.addFlashAttribute("operation", "add");
        return "redirect:/license/list";
    }

    /**
     * 删除操作
     */
    @RequestMapping("/delete")
    public String delete(RedirectAttributes model, Integer id) {
        tbLicenseService.deleteByPrimaryKey(id);
        model.addFlashAttribute("operation", "delete");
        return "redirect:/license/list";
    }

    /**
     * 跳转到更新页面
     */
    @RequestMapping("/gotoUpdate")
    public String gotoUpdate(ModelMap model, Integer id) {
        TbLicense tbLicense = tbLicenseService.selectByPrimaryKey(id);
        model.addAttribute("license", tbLicense);
        return "/license/edit";
    }

    /**
     * 更新操作
     */
    @RequestMapping("/update")
    public String update(RedirectAttributes model, TbLicense tbLicense) {
        tbLicenseService.updateByPrimaryKeySelective(tbLicense);
        model.addFlashAttribute("operation", "update");
        return "redirect:/license/list";
    }
}
