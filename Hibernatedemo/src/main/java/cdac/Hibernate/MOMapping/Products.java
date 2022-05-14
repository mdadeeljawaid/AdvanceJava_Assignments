package cdac.Hibernate.MOMapping;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	private String productName;
	private int price;
	@ManyToOne(targetEntity = Company.class, cascade = CascadeType.ALL)
	private Company pcompany;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Company getPcompany() {
		return pcompany;
	}
	public void setPcompany(Company pcompany) {
		this.pcompany = pcompany;
	}
	
	
}
