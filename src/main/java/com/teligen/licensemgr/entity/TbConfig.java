package com.teligen.licensemgr.entity;

import com.teligen.licensemgr.base.entity.BaseEntity;

import javax.persistence.*;

@Table(name = "tb_config")
public class TbConfig extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code_key")
    private String codeKey;

    @Column(name = "code_value")
    private String codeValue;

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
     * @return code_key
     */
    public String getCodeKey() {
        return codeKey;
    }

    /**
     * @param codeKey
     */
    public void setCodeKey(String codeKey) {
        this.codeKey = codeKey;
    }

    /**
     * @return code_value
     */
    public String getCodeValue() {
        return codeValue;
    }

    /**
     * @param codeValue
     */
    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }
}