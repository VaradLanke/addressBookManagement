class Person{
        //int id;
        String firstName;
        String lastName;
        Address address;
		String phoneNumber;

	Person(){}
	Person(String firstName,String lastName,Address address,String phoneNumber){
		this.firstName=firstName;
		this.lastName=lastName;
		this.address=address;
		this.phoneNumber=phoneNumber;
	}
	public String getFirstName(){
		return this.firstName;
	}
	public void setFirstName(String firstName){
		this.firstName=firstName;
	}
	public String getLastName(){
		return this.lastName;
	}
	public void setLastName(String lastName){
		this.lastName=lastName;
	}
	public String getAddress(){
		return this.address.toString();
	}
	public void setAddress(String addressLine1,String addressLine2,String city,String state,long zip){
		this.address.setAddressLine1(addressLine1);
		this.address.setAddressLine2(addressLine2);
		this.address.setCity(city);
		this.address.setState(state);
		this.address.setZip(zip);
	}
	public String getPhoneNumber(){
		return this.phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber=phoneNumber;
	}
	@Override
	public String toString(){
		return this.firstName +" "+ this.lastName +"\n"+ this.phoneNumber +"\n"+ this.address.toString() ;
	}

	/*public static void main(String[] args){
		Address newAddr = new Address("F45,Hathway Street","Near SBI Bank Borivali","Mumbai","Maharashtra",400066);
		Person kim = new Person("kim jong","un",newAddr,"9312457120");
		System.out.println(kim.toString());
	}*/
}

