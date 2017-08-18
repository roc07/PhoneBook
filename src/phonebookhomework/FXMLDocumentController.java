package phonebookhomework;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {
  
  @FXML
  private TextField nameField;
  @FXML
  private TextField phoneField;
  @FXML
  private TextArea result;
  
  private Stack<PhoneBook> phoneBook;
  private String[] item;

  public FXMLDocumentController(Stack<PhoneBook> phoneBook) {
    this.phoneBook = new Stack<>();
    this.item = new String[2];
  }
  
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }  

  @FXML
  private void AddPairA(ActionEvent event) {
    item[0] = nameField.getText();
    item[1] = phoneField.getText();
    //PhoneValidity(item[1]);
  }

  @FXML
  private void DeleteLastA(ActionEvent event) {
  }

  @FXML
  private void DeleteNameA(ActionEvent event) {
  }

  @FXML
  private void PrintLastA(ActionEvent event) {
  }

  @FXML
  private void PrintAllA(ActionEvent event) {
  }
  
}
