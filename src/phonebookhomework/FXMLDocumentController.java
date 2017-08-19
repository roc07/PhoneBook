package phonebookhomework;

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
import static phonebookhomework.PhoneBook.PhoneValidity;

public class FXMLDocumentController implements Initializable {
  
  @FXML
  private TextField nameField;
  @FXML
  private TextField phoneField;
  @FXML
  private TextField countField;  
  @FXML
  private TextArea result;
  
  private LinkedList<PhoneBook> phoneBook;
  private String[] item;
  private int count;

  public FXMLDocumentController() {
    this.phoneBook = new LinkedList();
    this.item = new String[2];
    count = 0;
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
    item[0] = nameField.getText().trim();
    item[1] = phoneField.getText().trim();
    if (PhoneValidity(item[1])){ 
      PrintAction("Added to", " PhoneBook: \n", item[0], item[1]);    
    }else{
      result.setText("Invalid Phone Number!\nPlease correct it, then try again.");
      return;
    }
    phoneBook.add(0, new PhoneBook(item[0], item[1]));
    SetCountField(++count);
    nameField.clear();
    phoneField.clear();
  }
  
  @FXML
  private void ImportFileA(ActionEvent event) {
  }

  @FXML
  private void DeleteLastA(ActionEvent event) {
    if (!phoneBook.isEmpty()){
      PrintAction("Removing", " current last item: \n", 
              phoneBook.get(0).getName(), phoneBook.get(0).getPhone());
      SetCountField(--count);
      phoneBook.remove(0);
    }else{
      result.setText("There are no items to remove.");
    }
  }

  @FXML
  private void DeleteNameA(ActionEvent event) {
    
  }
  
  @FXML
  private void DeleteAll(ActionEvent event) {
    if (!phoneBook.isEmpty()){
      phoneBook.removeAll(phoneBook);
      SetCountField(0);
    }
  }

  @FXML
  private void PrintLastA(ActionEvent event) {
  }

  @FXML
  private void PrintAllA(ActionEvent event) {
  }




  
  
  
}
