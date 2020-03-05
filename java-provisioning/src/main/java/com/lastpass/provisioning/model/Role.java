package com.lastpass.provisioning.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author LogMeIn
 */
public class Role {

    @JsonProperty("Id")
    private String id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Order")
    private Integer order;

    @JsonProperty("Enable")
    private Boolean enable;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Role(String id, String name, Integer order, Boolean enable) {
        this.id = id;
        this.name = name;
        this.order = order;
        this.enable = enable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

}
