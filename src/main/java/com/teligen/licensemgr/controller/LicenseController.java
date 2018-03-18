package com.teligen.licensemgr.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.teligen.licensemgr.entity.TbConfig;
import com.teligen.licensemgr.entity.TbLicense;
import com.teligen.licensemgr.service.TbConfigService;
import com.teligen.licensemgr.service.TbLicenseService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.util.calendar.BaseCalendar;
import tk.mybatis.mapper.entity.Condition;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/license")
public class LicenseController {
    private final static Logger logger = LoggerFactory.getLogger(LicenseController.class);
    @Autowired
    private TbLicenseService tbLicenseService;
    @Autowired
    private TbConfigService tbConfigService;

    /**
     * 列表展示
     */
    @RequestMapping("/list")
    public String list(ModelMap model, TbLicense tbLicenseVo) throws ParseException {
        /**
         * 前端传过来的查询条件：
         *  过期状态    cusStatus
         *  省份  province
         *  城市  city
         *  集群名称    clusterName
         *  license生成时间范围  createTimeStr
         *  license过期时间范围  expireTimeStr
         */
        TbConfig tbConfig = tbConfigService.getWarnDay();
        int warnDay = 3;
        if (null != tbConfig) {
            warnDay = Integer.valueOf(tbConfig.getCodeValue());
        }

        Condition condition = new Condition(TbLicense.class);
        condition.setOrderByClause("create_time desc");
        if (!StringUtils.isEmpty(tbLicenseVo.getCusStatus())) {
            condition.or().andLessThanOrEqualTo("expireTime", DateUtils.addDays(new Date(), warnDay));
        }
        if (!StringUtils.isEmpty(tbLicenseVo.getProvince())) {
            condition.or().andEqualTo("province", tbLicenseVo.getProvince());
        }
        if (!StringUtils.isEmpty(tbLicenseVo.getCity())) {
            condition.or().andEqualTo("city", tbLicenseVo.getCity());
        }
        if (!StringUtils.isEmpty(tbLicenseVo.getClusterName())) {
            condition.or().andLike("clusterName", tbLicenseVo.getClusterName());
        }
        if (!StringUtils.isEmpty(tbLicenseVo.getCreateTimeStr())) {
            String createTimeStartStr = tbLicenseVo.getCreateTimeStr().split(" - ")[0];
            String createTimeEndStr = tbLicenseVo.getCreateTimeStr().split(" - ")[1];

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date createTimeStart = simpleDateFormat.parse(createTimeStartStr);
            Date createTimeEnd = simpleDateFormat.parse(createTimeEndStr);

            condition.or().andBetween("createTime", createTimeStart, createTimeEnd);
        }

        if (!StringUtils.isEmpty(tbLicenseVo.getExpireTimeStr())) {
            String expireTimeStartStr = tbLicenseVo.getExpireTimeStr().split(" - ")[0];
            String expireTimeEndStr = tbLicenseVo.getExpireTimeStr().split(" - ")[1];

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date expireTimeStart = simpleDateFormat.parse(expireTimeStartStr);
            Date expireTimeEnd = simpleDateFormat.parse(expireTimeEndStr);

            condition.or().andBetween("expireTime", expireTimeStart, expireTimeEnd);
        }

        PageHelper.startPage(tbLicenseVo.getPageNum(), tbLicenseVo.getPageSize());
        List<TbLicense> licenseList = tbLicenseService.selectByCondition(condition);
        PageInfo<TbLicense> pageInfo = new PageInfo<TbLicense>(licenseList);

        model.addAttribute("licenseList", licenseList);
        model.addAttribute("tbLicenseVo", tbLicenseVo);
        model.addAttribute("warnDay", warnDay);
        model.addAttribute("pageInfo", pageInfo);
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
