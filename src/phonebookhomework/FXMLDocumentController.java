package phonebookhomework;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import static phonebookhomework.Contact.PhoneValidity;

public class FXMLDocumentController implements Initializable {
  
  @FXML
  private TextField nameField;
  @FXML
  private TextField phoneField;
  @FXML
  private TextField countField;  
  @FXML
  private TextArea result;
  @FXML
  private TextField pathField;
  
  private PhoneBook phoneBook;
  private String[] person;

  public FXMLDocumentController() {
    this.phoneBook = new PhoneBook();
    this.person = new String[2];
  }
  
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }  

  private void PrintAction(String action, String where, String name, String phone){
    result.setText(action + where + "Name: " + name + "\nPhone: " + phone);
  }
  
  private void SetCountField(int count){
    countField.setText(count + "");
  }
  
  @FXML
  private void AddPairA(ActionEvent event) {
    person[0] = nameField.getText().trim();
    person[1] = phoneField.getText().trim();
    
    if (PhoneValidity(person[1])){ 
      phoneBook.AddPair(person[0], person[1]);
      PrintAction("Added to", " PhoneBook: \n", person[0], person[1]);    
    }else{
      result.setText("Invalid Phone Number!\nPlease correct it, then try again.");
      return;
    }

    SetCountField(phoneBook.getCounter());
    nameField.clear();
    phoneField.clear();
  }
  
  @FXML
  private void ImportFileA(ActionEvent event) {
    int currCnt = phoneBook.getCounter();
    try {
    phoneBook.ImportFromFile(pathField.getText());
    }catch (IOException e){
      
    }
    if (phoneBook.getCounter() > currCnt){
      SetCountField(phoneBook.getCounter());
      result.setText("Added.");      
    }else{
      result.setText("Nothing added.");  
    }

  }

  @FXML
  private void DeleteLastA(ActionEvent event) {
    if (phoneBook.getCounter() > 0){
      PrintAction("Removing", " current last item: \n", 
              phoneBook.getPhoneBook().get(0).getName(), 
              phoneBook.getPhoneBook().get(0).getPhone());
      phoneBook.DeleteAt(0);
      SetCountField(phoneBook.getCounter());     
    }else{
      result.setText("There are no contacts to remove.");
    }
  }

  @FXML
  private void DeleteNameA(ActionEvent event) {
    if (phoneBook.getCounter() > 0){ 
      int currCnt = phoneBook.getCounter();
      phoneBook.DeleteByName(nameField.getText());
      if (currCnt > phoneBook.getCounter()){
        result.setText("Done.");
        SetCountField(phoneBook.getCounter());
      }else{
        result.setText("Name not found.");
      }
    }else{
      result.setText("There are no contacts to remove.");
    }
  }
  
  @FXML
  private void DeleteAll(ActionEvent event) {
    if (phoneBook.getCounter() > 0){
      phoneBook.DeleteAll();
      SetCountField(phoneBook.getCounter());
      result.setText("All contacts removed.");
    }else{
      result.setText("There are no contacts to remove.");
    }
  }

  @FXML
  private void PrintLastA(ActionEvent event) {
    if (phoneBook.getCounter() > 0){
      PrintAction("Last contact added: ", "\n", 
              phoneBook.ReturnContact(0).getName(),
              phoneBook.ReturnContact(0).getPhone());
    }else{
      result.setText("There are no contacts to print.");
    }
  }

  @FXML
  private void PrintAllA(ActionEvent event) {
    if (phoneBook.getCounter() > 0){
      result.setText(phoneBook.ReturnAllContacts());
    }else{
      result.setText("There are no contacts to print.");
    } 
  }




  
  
  
}
