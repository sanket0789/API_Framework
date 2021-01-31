package POJO_Class;

public class Get_Place_API {

	//String & List return type variables.
	
	//Return type is class name because its nested Json.
	private location location ;
	private String accuracy ;
	private String name ;
	private String phone_number ;
	private String address ;
	
	//Type is list because the Json type is Array
	private String types ;
	private String website ;
	private String Language ;
	
	//Getters and Setters
	public POJO_Class.location getLocation() {
		return location;
	}
	public void setLocation(POJO_Class.location location) {
		this.location = location;
	}
	public String getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	
	
}
