package practice_sd;

public class MyProduct {
	
	private int mpid;
	private String mproductName;
	private MyProductInventory  myProductInventory;
	
	public int getMpid() {
		return mpid;
	}
	public void setMpid(int mpid) {
		this.mpid = mpid;
	}
	public String getMproductName() {
		return mproductName;
	}
	public void setMproductName(String mproductName) {
		this.mproductName = mproductName;
	}
	
	
	public MyProductInventory getMyProductInventory() {
		return myProductInventory;
	}
	public void setMyProductInventory(MyProductInventory myProductInventory) {
		this.myProductInventory = myProductInventory;
	}
	public void  productInfo() {
		System.out.println(myProductInventory.toString());
		
	}

}
