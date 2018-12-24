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
public class User implements Serializable{
    private Integer id;
    private String email;
    private Integer age;
    private String username;
    private String pass;

    public User() {
    }

    public User(String email, Integer age, String username, String pass) {
        this.email = email;
        this.age = age;
        this.username = username;
        this.pass = pass;
    }

    public User(Integer id, String email, Integer age, String username, String pass) {
        this.id = id;
        this.email = email;
        this.age = age;
        this.username = username;
        this.pass = pass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
    
}
