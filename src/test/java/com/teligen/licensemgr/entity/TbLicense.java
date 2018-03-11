package com.teligen.licensemgr.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_license")
public class TbLicense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "license_id")
    private String licenseId;

    private String province;

    private String city;

    @Column(name = "cluster_name")
    private String clusterName;

    @Column(name = "cluster_num")
    private Integer clusterNum;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "active_day")
    private Integer activeDay;

    @Column(name = "expire_time")
    private Date expireTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return license_id
     */
    public String getLicenseId() {
        return licenseId;
    }

    /**
     * @param licenseId
     */
    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    /**
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return cluster_name
     */
    public String getClusterName() {
        return clusterName;
    }

    /**
     * @param clusterName
     */
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    /**
     * @return cluster_num
     */
    public Integer getClusterNum() {
        return clusterNum;
    }

    /**
     * @param clusterNum
     */
    public void setClusterNum(Integer clusterNum) {
        this.clusterNum = clusterNum;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return active_day
     */
    public Integer getActiveDay() {
        return activeDay;
    }

    /**
     * @param activeDay
     */
    public void setActiveDay(Integer activeDay) {
        this.activeDay = activeDay;
    }

    /**
     * @return expire_time
     */
    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * @param expireTime
     */
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }
}