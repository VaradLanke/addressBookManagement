class Address{
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private long zip;

	Address(){
	}
	Address(String addressLine1,String addressLine2,String city,String state,long zip){
		super();
		this.addressLine1=addressLine1;
		this.addressLine2=addressLine2;
		this.city=city;
		this.state=state;
		this.zip=zip;
	}
	public String getAddressLine1(){
		return this.addressLine1;
	}
	public void setAddressLine1(String addressLine1){
		this.addressLine1=addressLine1;
	}
	public String getAddressLine2(){
		return this.addressLine2;
	}
	public void setAddressLine2(String addressLine2){
		this.addressLine2=addressLine2;
	}
	public String getCity(){
		return this.city;
	}
	public void setCity(String city){
		this.city=city;
	}
	public String getState(){
		return this.state;
	}
	public void setState(String state){
		this.state=state;
	}
	public long getZip(){
		return this.zip;
	}
	public void setZip(long zip){
		this.zip=zip;
	}
	@Override
	public String toString(){
		return this.addressLine1 +" "+ this.addressLine2 +" "+ this.city +","+ this.state +","+ this.zip;
	}

	/*public static void main(String[] args){
		Address newAddr = new Address("F45,Hathway Street","Near SBI Bank Borivali","Mumbai","Maharashtra",400066);
		System.out.println(newAddr.toString());
	}*/
}
