package com.rc.hql;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Order
 * @Description 单信息持久化类
 * @Author liux
 * @Date 19-4-7 下午4:14
 * @Version 1.0
 */
public class Order implements Serializable {

    private Long id;//主键

    private Customer customer;//客户

    private Date tradeDate;//交易日期

    private String status;//订单状态

    private Double amount;// 订单金额

    private Set<OrderItem> orderItems = new HashSet<>(); //订单明细

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", tradeDate=" + tradeDate +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                ", orderItems=" + orderItems +
                '}';
    }
}
