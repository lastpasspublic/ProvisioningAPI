package com.lastpass.provisioning.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author LogMeIn
 */
public class Pagination {

    @JsonProperty("Size")
    Integer size;

    @JsonProperty("OffSet")
    Integer offSet;

    public Pagination() {
    }

    public Pagination(Integer size, Integer offSet) {
        this.size = size;
        this.offSet = offSet;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getOffSet() {
        return offSet;
    }

    public void setOffSet(Integer offSet) {
        this.offSet = offSet;
    }

}
