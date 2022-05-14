package cdac.Hibernatedemo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="empTable10")
public class Employee {
	@Id
	@Column(name="t_eid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	@Column(name="t_empname", length =120)
	private String ename;
	
    @ColumnDefault("1234")
  
	private String epassword;
	
	public Employee() {
		
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEpassword() {
		return epassword;
	}
	public void setEpassword(String epassword) {
		this.epassword = epassword;
	}

}
