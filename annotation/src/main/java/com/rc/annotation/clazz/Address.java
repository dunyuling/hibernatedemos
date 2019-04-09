package com.rc.annotation.clazz;

import javax.persistence.Embeddable;

/**
 * @ClassName Address
 * @Description 地址类，作为嵌入属性类使用
 * @Author liux
 * @Date 19-4-9 上午10:32
 * @Version 1.0
 */
@Embeddable
public class Address {

    private String postcode;//邮编

    private String address;//地址

    private String phone;//电话

    public Address() {
    }

    public Address(String postcode, String address, String phone) {
        this.postcode = postcode;
        this.address = address;
        this.phone = phone;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Address{" +
                "postcode='" + postcode + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
