/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voting.system;

import java.io.Serializable;

/**
 *
 * @author pro
 */
public class Election implements Serializable{
    private Integer id;
    private String name;
    private String type;
    private String detail;
    private Boolean status;
    private String result;

    public Election() {
    }

    public Election(String name, String type, String detail, Boolean status, String result) {
        this.name = name;
        this.type = type;
        this.detail = detail;
        this.status = status;
        this.result = result;
    }

    public Election(Integer id, String name, String type, String detail, Boolean status, String result) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.detail = detail;
        this.status = status;
        this.result = result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
    
    
    
}
