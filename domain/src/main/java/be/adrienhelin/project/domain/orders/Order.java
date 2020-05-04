package be.adrienhelin.project.domain.orders;

import be.adrienhelin.project.domain.customers.Customer;
import be.adrienhelin.project.domain.items.ItemGroup;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "eurder")
public class Order {

    @Id
    @Column(name = "eurder_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "eurder_id")
    private List<ItemGroup> itemGroup;

    public Order() {
    }

    public Order(OrderBuilder orderBuilder) {
        this.id = orderBuilder.getOrderId();
        this.customerId = orderBuilder.getCustomerId();
        this.itemGroup = orderBuilder.getItemGroup();
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public Integer getId() {
        return id;
    }

    public List<ItemGroup> getItemGroup() {
        return itemGroup;
    }

    public static class OrderBuilder {

        private Integer orderId;
        private Customer customerId;
        private List<ItemGroup> itemGroup;

        protected OrderBuilder() {
        }

        public static OrderBuilder orderBuilder() {
            return new OrderBuilder();
        }

        public Order build() {
            return new Order(this);
        }

        public OrderBuilder withCustomerId(Customer customerId) {
            this.customerId = customerId;
            return this;
        }

        public OrderBuilder withOrderId(Integer orderId) {
            this.orderId = orderId;
            return this;
        }

        public OrderBuilder withItemGroup(List<ItemGroup> itemGroup) {
            this.itemGroup = itemGroup;
            return this;
        }

        public Customer getCustomerId() {
            return customerId;
        }

        public Integer getOrderId() {
            return orderId;
        }

        public List<ItemGroup> getItemGroup() {
            return itemGroup;
        }
    }
}
