package phonebookhomework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import static phonebookhomework.Contact.PhoneValidity;

public class PhoneBook extends IOException{
  private LinkedList<Contact> phoneBook; 
  private Contact defaultCont;
  private int counter;
  private BufferedReader item;
  private FileReader file;

  public PhoneBook() {
    this.phoneBook = new LinkedList<Contact>();
    defaultCont = new Contact("", "");
    counter = 0;
    item = null;
    file = null;
  }

  public int getCounter() {
    return counter;
  }

  public Contact getDefualt() {
    return defaultCont;
  }
  
  public LinkedList<Contact> getPhoneBook() {
    return phoneBook;
  } 
  
  public boolean FindContact(String name, int i){
    if (phoneBook.get(i).getName().equals(name)){
      return true;
    }else{
      return false;
    }
  }
  
  public PhoneBook AddPair(String name, String phone) {
    phoneBook.add(0, new Contact(name, phone));    
    counter++;   
    return this;
  }
  
  public PhoneBook DeleteAt(int i){
    phoneBook.remove(i);
    counter--;
    return this;
  }
  
  public PhoneBook DeleteByName(String name){
    for (int i = 0; i < counter; i++){
      if (FindContact(name, i)){
        DeleteAt(i);
      }
    }
    return this;
  }
  
  public PhoneBook DeleteAll(){
    phoneBook.removeAll(phoneBook);
    counter = 0;
    return this;
  }

  public Contact ReturnContact(int i){
    return phoneBook.get(i);
  }
  
  public String ReturnAllContacts(){
    StringBuilder all = new StringBuilder();
    all.append("Printing all contacts: ");
    all.append("\n");
    for (int i = 0; i < counter; i++){
      all.append("Name: ").append(phoneBook.get(i).getName());
      all.append("\n");
      all.append("Phone: ").append(phoneBook.get(i).getPhone());
      all.append("\n");      
    }
    return all.toString();
  }
  
  public PhoneBook ImportFromFile(String path) throws IOException{
    try{
      file = new FileReader(path);
      item = new BufferedReader(file);
      String sCurrentLine;
      
	while ((sCurrentLine = item.readLine()) != null) {
        String[] split = sCurrentLine.split(" ");
          if (split.length == 2){    
            if (PhoneValidity(split[1])){ 
              AddPair(split[0], split[1]);
            }            
          }
	}   
    }catch (IOException e){
      
    }
    finally{
      if (file != null){
        file.close();
      }
    } 
    return this;    
  }
}
