import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
class AddressBook{
	private String addressBookName;
	List<Person> personList = new ArrayList<Person>();
	Scanner bookSc = new Scanner(System.in);

	AddressBook(){
		this.personList.add(new Person("varad","lanke",new Address("Mangalwar peth","near Janata Bank","Satara","MH",400001),"8956421357"));
		this.personList.add(new Person("bharat","Jadhav",new Address("Somwar peth","near Union Bank","Koregaon","GJ",400002),"7845122356"));
		this.personList.add(new Person("Anupan","Kale",new Address("Budhwar peth","near BOI Bank","Bhopal","RJ",400003),"9890401257"));
		this.personList.add(new Person("Shiva","patil",new Address("Guruwar peth","near SBI Bank","pandharpur","KL",400004),"9641235201"));
		this.personList.add(new Person("Martin","Hajare",new Address("Shukrawar peth","near Deutch Bank","Jejuri","PC",400005),"8756301247"));
		this.personList.add(new Person("Jecob","Swami",new Address("Shaniwar peth","near Manata Bank","Thane","UP",400006),"9475668421"));
	}
	AddressBook(String addressBookName){
		this();
		this.addressBookName=addressBookName;
	}
	public void AddPerson(){
		System.out.print("FirstName : ");
		String fname = bookSc.next();

		System.out.print("LastName : ");
		String lname = bookSc.next();

		System.out.print("Address Line1 : ");	
		String addressline1 = bookSc.next();

		System.out.print("Address Line2 : ");	
		String addressline2 = bookSc.next();

		System.out.print("City : ");	
		String city = bookSc.next();

		System.out.print("State : ");	
		String state = bookSc.next();

		System.out.print("zip : ");	
		long zip = bookSc.nextLong();

		System.out.print("PhoneNumber : ");
		String phnum = bookSc.next();

		Address newAddr = new Address(addressline1,addressline2,city,state,zip);
		Person newPer = new Person(fname,lname,newAddr,phnum);
		System.out.println(newPer.toString());
		personList.add(newPer);
	}
	
	public void editPerson(){

		System.out.print("FName of Person to Edit : ");	
		String fName = bookSc.next();
		Person editPer = this.getPersonFromList(fName);

		if(editPer!=null){

		System.out.print("New Address Line1 : ");	
		String addressline1 = bookSc.next();

		System.out.print("New Address Line2 : ");	
		String addressline2 = bookSc.next();

		System.out.print("New City : ");	
		String city = bookSc.next();

		System.out.print("New State : ");	
		String state = bookSc.next();

		System.out.print("New zip : ");	
		long zip = bookSc.nextLong();

		System.out.print("New PhoneNumber : ");
		String phnum = bookSc.next();

		editPer.setAddress(addressline1,addressline2,city,state,zip);
		editPer.setPhoneNumber(phnum);
		System.out.println("Updated Successfully!!");
		return;
		}
		System.out.println("Error : Person You are looking does not exist in Address Book!!");
	}

	public void deletePerson(){
		System.out.print("FName of Person to Delete : ");	
		String fName = bookSc.next();
		Person editPer = this.getPersonFromList(fName);
		if(editPer!=null){
			this.personList.remove(editPer);
			System.out.println("Deleted Successfully!");
			return;
		}
		System.out.println("Error : Person You are looking does not exist in Address Book!!");
	}
	public void sortByFirstName(){}
	public void sortByLastName(){}
	public void sortByZipCode(){}
	public Person getPersonFromList(String name){
		for (Person per : this.personList) {
			if(name.equalsIgnoreCase(per.getFirstName())){
				return per;
			}
		}
		return null;
	}
	public void printAddressBookList(){
		for (Person per : this.personList) {
			System.out.println(per.toString());
		}
	}

	public static void main(String[] args){
		AddressBook yellowPages = new AddressBook("yellowPages");
		//yellowPages.AddPerson();
		//yellowPages.editPerson();
		//yellowPages.deletePerson();	
		yellowPages.printAddressBookList();
	}
}





