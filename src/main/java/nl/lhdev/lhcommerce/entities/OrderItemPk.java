package nl.lhdev.lhcommerce.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//classe auxiliar para criar o id de OrdemItem 
@Embeddable
public class OrderItemPk {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    
    public OrderItemPk() {
    }

    // nao criou constuctor completo
    /* 
        public OrderItemPk(Order order, Product product) {
          this.order = order;
          this.product = product;
        }
    */

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    

    


    
}
