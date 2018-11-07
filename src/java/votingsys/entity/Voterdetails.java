/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votingsys.entity;

/**
 *
 * @author aSad
 */
public class Voterdetails {
    
    private int id;
    private String name;
    private String gender;
    private String dofb;
    private String address;
    private int mobile;
    private String email;
    private String pass;

    public Voterdetails() {
    }

    public Voterdetails(String name, String gender, String dofb, String address, int mobile, String email, String pass) {
        this.name = name;
        this.gender = gender;
        this.dofb = dofb;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDofb() {
        return dofb;
    }

    public void setDofb(String dofb) {
        this.dofb = dofb;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
