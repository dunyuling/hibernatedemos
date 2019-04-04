package com.rc.singletable;

/**
 * @ClassName Address
 * @Description TODO
 * @Author liux
 * @Date 19-4-5 上午12:11
 * @Version 1.0
 */
public class Address {

    private String postcode;

    private String phone;

    private String address;

    public Address() {
        this.postcode = "100000";
        this.phone = "13012345678";
        this.address = "china";
    }

    public Address(String postcode, String phone, String address) {
        this.postcode = postcode;
        this.phone = phone;
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "postcode='" + postcode + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
