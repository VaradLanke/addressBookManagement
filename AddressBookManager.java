import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;

class AddressBookManager {
	static Scanner userScanner = new Scanner(System.in);
	File file= null;
	FileOutputStream outputStream = null;
	ObjectOutputStream objOutStrm = null;
	FileInputStream inputStream = null;
	ObjectInputStream objInStrm = null;
	AddressBook currentAddressBook = null;

	public void newAddressBook(String addressBookName) throws IOException {
		currentAddressBook = new AddressBook(addressBookName);
		file = new File("./ObjectFiles/" + addressBookName);
		System.out.println(addressBookName + " : New File Created Successfully");
	}

	public void openAddressBook(String addressBookName) throws IOException,ClassNotFoundException {
		currentAddressBook = new AddressBook(addressBookName);
		file = new File("./ObjectFiles/" + addressBookName);
		inputStream = new FileInputStream(addressBookName);
		objInStrm = new ObjectInputStream(inputStream);
		boolean count = true;
		while(count) {
			if (inputStream.available() != 0) {
				Person per = (Person) objInStrm.readObject();
    			currentAddressBook.AddPerson(per);
    		} else {
      			count = false;
    		}
		}
		System.out.println(addressBookName + " : File Opened Successfully");
	}
	public void closeAddressBook(String addressBookName) throws IOException{
		file = new File("./ObjectFiles/" + addressBookName);
		if(file.canWrite() && file != null){
			outputStream = null;
			objOutStrm = null;
			inputStream = null;
			objInStrm = null;
			file = null;
			currentAddressBook = null;
		}
		System.out.println(addressBookName + " : File Closed Successfully");
	}
	public void saveAddressBook(String addressBookName) throws IOException {
		if(this.file != null && currentAddressBook != null){
			outputStream = new FileOutputStream (file);
			objOutStrm = new ObjectOutputStream(outputStream);
			for (Person per : currentAddressBook.getPersonList()) {
				objOutStrm.writeObject(per);
			}
			System.out.println(addressBookName + ": File Saved Successfully");
		}
	}

	public static int menu(){
		System.out.println("=========Menu========");
		System.out.println("1.Create New AddressBook");
		System.out.println("2.Open AddressBook");
		System.out.println("3.Save AddressBook");
		System.out.println("4.Close AddressBook");
		System.out.println("9.Exit");
		System.out.println("=====================");
		System.out.println();
		System.out.println("Enter your choice::");
		int choice = userScanner.nextInt();
		return choice;
	}
	public static void main(String[] args){
		try{
			AddressBookManager myManager = new AddressBookManager();
			String inputAddressBookName = null;
			//myManager.newAddressBook("yellowPages");
			//myManager.openAddressBook("yellowPages");
			//myManager.saveAddressBook("yellowPages");
			//myManager.closeAddressBook("yellowPages");
			while(true){
				int option = menu();
				switch(option){
					case 1:
							System.out.println("Enter FileName : ");
							inputAddressBookName = userScanner.next(); //yellowPages					
							myManager.newAddressBook(inputAddressBookName);
					break;
					case 2:
							System.out.println("Enter FileName : ");
							inputAddressBookName = userScanner.next(); //yellowPages
							myManager.openAddressBook(inputAddressBookName);
					break;
					case 3:
							myManager.saveAddressBook(inputAddressBookName);
					break;
					case 4:
							myManager.closeAddressBook(inputAddressBookName);
					break;
					case 9: System.out.println("Exited");
							System.exit(0);
					break;
					default: System.out.println("Invalid Option! Try Again...");
				}
			}
		}/*catch(IOException ex){
			ex.printStackTrace();
		}*/catch(Exception e){
			e.printStackTrace();
		}
	}
}
