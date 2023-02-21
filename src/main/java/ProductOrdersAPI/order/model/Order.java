package ProductOrdersAPI.order.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order {
	
	@Id
	@Column(name = "id", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "customer_id")
	private Integer customerId;
	@Column(name = "ordered_at")
	private Date orderedAt = new Date();
    @Column(name = "total_amount")
    private Float totalAmount;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer setCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Date getOrderedAt() {
		return orderedAt;
	}
	public void setOrderedAt(Date orderedAt) {
		this.orderedAt = orderedAt;
	}
	public Float getTotalAmount() {
		return totalAmount;
	}
	public void getTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
	}
    
    

}
