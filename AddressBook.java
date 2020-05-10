import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Comparable;
import java.util.Collections;
import java.util.Comparator;
import java.io.Serializable;

class AddressBook implements Serializable{
	private static final long serialVersionUID = 1L;
	private String addressBookName;
	List<Person> personList = new ArrayList<Person>();
	Scanner bookSc = new Scanner(System.in);

	AddressBook(){
		this.AddPerson(new Person("varad","lanke",new Address("Mangalwar peth","near Janata Bank","Satara","MH",400001),"8956421357"));
		this.AddPerson(new Person("bharat","Jadhav",new Address("Somwar peth","near Union Bank","Koregaon","GJ",400002),"7845122356"));
		this.AddPerson(new Person("Anupan","Kale",new Address("Budhwar peth","near BOI Bank","Bhopal","RJ",400003),"9890401257"));
		this.AddPerson(new Person("Shiva","patil",new Address("Guruwar peth","near SBI Bank","pandharpur","KL",400004),"9641235201"));
		this.AddPerson(new Person("Martin","Hajare",new Address("Shukrawar peth","near Deutch Bank","Jejuri","PC",400005),"8756301247"));
		this.AddPerson(new Person("Jecob","Swami",new Address("Shaniwar peth","near Manata Bank","Thane","UP",400006),"9475668421"));
		
	}
	AddressBook(String addressBookName){
		this();
		this.addressBookName=addressBookName;
	}
	public List<Person> getPersonList(){
		return this.personList;
	}
	public void AddPerson(Person newPer){
		if(newPer==null){
			newPer = new Person();
			newPer.setAddress(new Address());

			System.out.print("FirstName : ");
			newPer.setFirstName(bookSc.next());

			System.out.print("LastName : ");
			newPer.setLastName(bookSc.next());

			System.out.print("Address Line1 : ");
			newPer.getAddress().setAddressLine1(bookSc.next());

			System.out.print("Address Line2 : ");	
			newPer.getAddress().setAddressLine2(bookSc.next());

			System.out.print("City : ");	
			newPer.getAddress().setCity(bookSc.next());

			System.out.print("State : ");	
			newPer.getAddress().setState(bookSc.next());

			System.out.print("zip : ");	
			newPer.getAddress().setZip(bookSc.nextLong());

			System.out.print("PhoneNumber : ");
			newPer.setPhoneNumber(bookSc.next());
		}
		System.out.println(newPer.toString());
		personList.add(newPer);
	}
	
	public void editPerson(Person editPer){

		System.out.print("FName of Person to Edit : ");	
		String fName = bookSc.next();
		editPer = this.getPersonFromList(fName);

		if(editPer!=null){

			System.out.print("New Address Line1 : ");	
			editPer.getAddress().setAddressLine1(bookSc.next());

			System.out.print("New Address Line2 : ");	
			editPer.getAddress().setAddressLine2(bookSc.next());

			System.out.print("New City : ");	
			editPer.getAddress().setCity(bookSc.next());

			System.out.print("New State : ");	
			editPer.getAddress().setState(bookSc.next());

			System.out.print("New zip : ");	
			editPer.getAddress().setZip(bookSc.nextLong());

			System.out.print("New PhoneNumber : ");
			editPer.setPhoneNumber(bookSc.next());

			System.out.println("Updated Successfully!!");
			return;
		}
		System.out.println("Error : Person You are looking does not exist in Address Book!!");
	}

	public void deletePerson(Person editPer){
		System.out.print("FName of Person to Delete : ");	
		String fName = bookSc.next();
		editPer = this.getPersonFromList(fName);
		if(editPer!=null){
			this.personList.remove(editPer);
			System.out.println("Deleted Successfully!");
			return;
		}
		System.out.println("Error : Person You are looking does not exist in Address Book!!");
	}

	public void sortByFirstName(){
		personList.sort(Comparator.comparing(e -> e.getFirstName().toLowerCase()));
	}

	public void sortByLastName(){
		personList.sort(Comparator.comparing(e -> e.getLastName().toLowerCase()));
	}

	public void sortByZipCode(){
		Collections.sort(personList);
	}

	public Person getPersonFromList(String name){
		for (Person per : this.personList) {
			if(name.equalsIgnoreCase(per.getFirstName())){
				return per;
			}
		}
		return null;
	}

	public void printAddressBookList(){
		System.out.println("------------------------------------------");
		for (Person per : this.personList) {
			System.out.println(per.toString());
		}
	}

	/*public static void main(String[] args){
		//AddressBook yellowPages = new AddressBook("yellowPages");
		//CRUD
		//yellowPages.AddPerson(null);
		//yellowPages.editPerson(null);
		//yellowPages.deletePerson(null);	
		//yellowPages.printAddressBookList();

		//Sorting
		//yellowPages.sortByFirstName();
		//yellowPages.sortByLastName();
		//yellowPages.sortByZipCode();
		//yellowPages.printAddressBookList();
	}*/
}





