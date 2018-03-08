package in.ac.iiitvadodara.cerebro.Models;

/**
 * Created by dipansh on 9/3/18.
 */

public class Dev {
    private String name;
    private String phone;
    private String role;
    private String img;

    public Dev() {
    }

    public Dev(String name, String phone, String role, String img) {
        this.name = name;
        this.phone = phone;
        this.role = role;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
