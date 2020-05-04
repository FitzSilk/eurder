package be.adrienhelin.project.domain.orders;

import be.adrienhelin.project.domain.items.ItemGroup;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "customer_id")
    private Integer customerId;

    @OneToMany
    @JoinColumn(name = "item_id")
    private List<ItemGroup> itemGroup;

    public Order() {
    }

    public Order(OrderBuilder orderBuilder) {
        this.id = orderBuilder.getOrderId();
        this.customerId = orderBuilder.getCustomerId();
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Integer getId() {
        return id;
    }

    public List<ItemGroup> getItemGroup() {
        return itemGroup;
    }

    public static class OrderBuilder {

        private Integer customerId;
        private Integer orderId;
        private List<ItemGroup> orderList;

        protected OrderBuilder() {
        }

        public static OrderBuilder orderBuilder() {
            return new OrderBuilder();
        }

        public Order build() {
            return new Order(this);
        }

        public OrderBuilder withCustomerId(Integer customerId) {
            this.customerId = customerId;
            return this;
        }

        public OrderBuilder withOrderId(Integer orderId) {
            this.orderId = orderId;
            return this;
        }

        public OrderBuilder withOrderList(List<ItemGroup> orderList) {
            this.orderList = orderList;
            return this;
        }

        public Integer getCustomerId() {
            return customerId;
        }

        public Integer getOrderId() {
            return orderId;
        }

        public List<ItemGroup> getOrderList() {
            return orderList;
        }
    }
}
