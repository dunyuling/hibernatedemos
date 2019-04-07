package com.rc.hql;

import java.io.Serializable;

/**
 * @ClassName OrderItem
 * @Description 订单明细信息持久化类
 * @Author liux
 * @Date 19-4-7 下午4:16
 * @Version 1.0
 */
public class OrderItem implements Serializable {

    private Long id; //主键
    private Order order; //订单
    private Commodity commodity; //订单商品
    private Double discount; //折扣
    private Double actPrice; //价格
    private Double amount; //数量

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getActPrice() {
        return actPrice;
    }

    public void setActPrice(Double actPrice) {
        this.actPrice = actPrice;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", order=" + order +
                ", commodity=" + commodity +
                ", discount=" + discount +
                ", actPrice=" + actPrice +
                ", amount=" + amount +
                '}';
    }
}
