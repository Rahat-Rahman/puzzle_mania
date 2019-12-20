package EntityLayer;

public class User {
 private int Id;
 private String Name;
 private String DOB;
 private String Password;
 
public int getId() {
	return Id;
}
public void setId(int Id) {
	this.Id = Id;
}
public String getDOB() {
	return DOB;
}
public void setDOB(String dOB) {
	DOB = dOB;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	this.Name = name;
}
 
}
