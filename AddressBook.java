import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
class AddressBook{
	private String AddressBookName;
	List<Person> personList = new ArrayList<Person>();

	AddressBook(){}
	AddressBook(String AddressBookName){
		this.AddressBookName=AddressBookName;
	}
	public void AddPerson(){
		Scanner bookSc = new Scanner(System.in);
		System.out.print("FirstName : ");
		String fname = bookSc.next();

		System.out.print("LastName : ");
		String lname = bookSc.next();

		System.out.print("Address Line1 : ");	
		String addressline1 = bookSc.nextLine();

		System.out.print("Address Line2 : ");	
		String addressline2 = bookSc.nextLine();

		System.out.print("City : ");	
		String city = bookSc.next();

		System.out.print("State : ");	
		String state = bookSc.next();

		System.out.print("zip : ");	
		long zip = bookSc.nextLong();

		System.out.print("PhoneNumber : ");
		String phnum = bookSc.next();
		bookSc.close();

		Address newAddr = new Address(addressline1,addressline2,city,state,zip);
		Person newPer = new Person(fname,lname,newAddr,phnum);
		System.out.println(newPer.toString());
		personList.add(newPer);
	}
	
	public void EditPerson(){}
	public void DeletePerson(){}
	public void SortByFirstName(){}
	public void SortByLastName(){}
	public void SortByZipCode(){}

	public static void main(String[] args){
		AddressBook yellowPages = new AddressBook("yellowPages");
		yellowPages.AddPerson();
	}
}





