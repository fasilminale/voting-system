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
public class Competitor implements Serializable{
    private Integer id;
    private String name;
    private Integer age;
    private String job;
    private String detail;
    private Integer count;
    private Integer electionId;

    public Competitor() {
    }

    public Competitor(String name, Integer age, String job, String detail, Integer count, Integer electionId) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.detail = detail;
        this.count = count;
        this.electionId = electionId;
    }

    public Competitor(Integer id, String name, Integer age, String job, String detail, Integer count, Integer electionId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.job = job;
        this.detail = detail;
        this.count = count;
        this.electionId = electionId;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getElectionId() {
        return electionId;
    }

    public void setElectionId(Integer electionId) {
        this.electionId = electionId;
    }
    
    




    
    
}
