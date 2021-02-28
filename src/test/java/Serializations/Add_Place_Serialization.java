package Serializations;

import java.util.List;

public class Add_Place_Serialization {

		//String & List return type variables.
		
		//Return type is class name because its nested Json.
		private Location_Serialize location ;
		private int accuracy ;
		private String name ;
		private String phone_number ;
		private String address ;
		
		//return type is list because the Json type is Array
		private List<String> types ;
		
		private String website ;
		private String Language ;
		
		//Getters and Setters
		public Location_Serialize getLocation() {
			return location;
		}
		public void setLocation(Location_Serialize location) {
			this.location = location;
		}
		public int getAccuracy() {
			return accuracy;
		}
		public void setAccuracy(int accuracy) {
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
		public List<String> getTypes() {
			return types;
		}
		public void setTypes(List<String> types) {
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
