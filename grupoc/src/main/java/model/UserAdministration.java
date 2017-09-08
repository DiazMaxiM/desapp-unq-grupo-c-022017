package model;

import java.util.ArrayList;
import java.util.List;

import exception.InvalidRegisterException;
import validation.UserValidation;

public class UserAdministration {
     List<User> users;
     UserValidation validator = new UserValidation();
     
     public UserAdministration(){
    	 this.users = new ArrayList<>();
     }
     
     public void registerUser(User user) throws InvalidRegisterException{
    	 if(validator.isNewUser(user,users)){
    		 this.users.add(user);
    	 } 	 
     }
     
     public List<User>getUsers(){
    	 return this.users;
     }
}
