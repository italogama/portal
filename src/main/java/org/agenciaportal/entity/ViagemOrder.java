package org.agenciaportal.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ViagemOrder",
uniqueConstraints = { @UniqueConstraint(columnNames = "Order_Num") })
public class ViagemOrder implements Serializable{

	private static final long serialVersionUID = 4376321196779705670L;
	private Integer id;
    private Date orderDate;
    private Date goDate;
    private Date backDate;
    private int orderNum;
    private double amount;
    private int quantity;
    private Viagens product;
    private Account account;
  
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID", length = 50)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "Order_Date", nullable = false)
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    
    @Column(name = "Go_Date", nullable = false)
    public Date getGoDate() {
		return goDate;
	}
	public void setGoDate(Date goDate) {
		this.goDate = goDate;
	}
	
	@Column(name = "Back_Date", nullable = false)
	public Date getBackDate() {
		return backDate;
	}
	public void setBackDate(Date backDate) {
		this.backDate = backDate;
	}
	@Column(name = "Order_Num", nullable = false)
    public int getOrderNum() {
        return orderNum;
    }
    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
    @Column(name = "Amount", nullable = false)
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    @Column(name = "Quantity", nullable = false)
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_ID", nullable = false, //
    foreignKey = @ForeignKey(name = "ORDER_DETAIL_ORDER_FK") )
	public Viagens getProduct() {
		return product;
	}
	public void setProduct(Viagens product) {
		this.product = product;
	}
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID", nullable = false, //
    foreignKey = @ForeignKey(name = "ACCOUNT_DETAIL_ORDER_FK") )
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
}
