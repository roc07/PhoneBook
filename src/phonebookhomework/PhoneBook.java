package phonebookhomework;

public class PhoneBook {
  private String name;
  private String phone; 
  
  public PhoneBook() {
  }
  
  public PhoneBook(String name, String phone) {
    this.setName(name);
    this.setPhone(phone);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
  
  private long PhoneParse(String phone){
    long item;
    
    try{
      item = Long.parseLong(phone);
      return item;
    }catch(NumberFormatException e){
      return 0l;
    }   
  }
  
  private boolean CheckDigits(String first, String second, String third){
    if (Integer.parseInt(first) >= 87 && Integer.parseInt(first) <= 89){
      if (Integer.parseInt(second) >= 2 && Integer.parseInt(second) <= 9){
        for (int i = 0; i < third.length(); i++){
          if (third.charAt(i) < '0' && third.charAt(i) > '9'){
            return false;
          }
        }
        return true;
      }else{
        return false;
      }
    }else{
      return false;
    }
  }
  
  public boolean PhoneValidity(String phone){
    int len = phone.length();
    String first;
    String second;
    String third;
    
    if (PhoneParse(phone) == 0l){
      return false;
    }
    
    switch (len) {
      case 10:
        if (phone.substring(0,1).equals("0")){
          first = phone.substring(1,3);
          second = phone.substring(3,4);
          third = phone.substring(4);
          
          return CheckDigits(first, second, third);
        }else{
          return false;
        }
      case 13:
        if (phone.substring(0,4).equals("+359")){
          first = phone.substring(4,6);
          second = phone.substring(6,7);
          third = phone.substring(7);
          
          return CheckDigits(first, second, third);
        }else{
          return false;
        }
      case 14:
        if (phone.substring(0,5).equals("00359")){
          first = phone.substring(5,7);
          second = phone.substring(7,8);
          third = phone.substring(8);
          
          return CheckDigits(first, second, third);
        }else{
          return false;
        }
      default:
        return false;
    }
  }
}


