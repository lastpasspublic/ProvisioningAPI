package com.lastpass.provisioning.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author LogMeIn
 */
public class Group {

    @JsonProperty("Guid")
    private String guid;

    @JsonProperty("Name")
    private String name;

    private @JsonProperty("OrganizationalUnit")
    String organizationalUnit;

    @JsonProperty("OrganizationalUnitGuid")
    private String organizationalUnitGuid;

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    public Group(String id, String name, String organizationalUnit, String organizationalUnitGuid) {
        this.guid = id;
        this.name = name;
        this.organizationalUnit = organizationalUnit;
        this.organizationalUnitGuid = organizationalUnitGuid;
    }

    public String getId() {
        return guid;
    }

    public void setId(String id) {
        this.guid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganizationalUnit() {
        return organizationalUnit;
    }

    public void setOrganizationalUnit(String organizationalUnit) {
        this.organizationalUnit = organizationalUnit;
    }

    public String getOrganizationalUnitGuid() {
        return organizationalUnitGuid;
    }

    public void setOrganizationalUnitGuid(String organizationalUnitGuid) {
        this.organizationalUnitGuid = organizationalUnitGuid;
    }

}
