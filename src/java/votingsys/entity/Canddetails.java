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
public class Canddetails {
    private int cid;
    private String cname;
    private String cgender;
    private String cdofb;
    private String caddress;
    private int cmobile;
    private String cemail;
    private String cpass;
    private int count;

    public Canddetails() {
    }

    public Canddetails(String cname, String cgender, String cdofb, String caddress, int cmobile, String cemail, String cpass) {
        this.cname = cname;
        this.cgender = cgender;
        this.cdofb = cdofb;
        this.caddress = caddress;
        this.cmobile = cmobile;
        this.cemail = cemail;
        this.cpass = cpass;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCgender() {
        return cgender;
    }

    public void setCgender(String cgender) {
        this.cgender = cgender;
    }

    public String getCdofb() {
        return cdofb;
    }

    public void setCdofb(String cdofb) {
        this.cdofb = cdofb;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public int getCmobile() {
        return cmobile;
    }

    public void setCmobile(int cmobile) {
        this.cmobile = cmobile;
    }

    public String getCemail() {
        return cemail;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
    }

    public String getCpass() {
        return cpass;
    }

    public void setCpass(String cpass) {
        this.cpass = cpass;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    
    
}
