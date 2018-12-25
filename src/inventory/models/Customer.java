/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.models;

/**
 *
 * @author Sithara
 */
public class Customer {
    private String name;
    private String nic;
    private String gender;
    private String address;
    private String dob;
    private String tel;
    private String email;
    private String loyaltyCard;

    public Customer(String name, String nic, String gender, String address, String dob, String tel, String email, String loyaltyCard) {
        this.name = name;
        this.nic = nic;
        this.gender = gender;
        this.address = address;
        this.dob = dob;
        this.tel = tel;
        this.email = email;
        this.loyaltyCard = loyaltyCard;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoyaltyCard() {
        return loyaltyCard;
    }

    public void setLoyaltyCard(String loyaltyCard) {
        this.loyaltyCard = loyaltyCard;
    }
    
    
    
}
