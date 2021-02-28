package Serializations;

public class Location_Serialize {

	//Variable to store values from Json.
		private double lat;
		private double lng;
		
		//Getters & Setters
		public double getLatitude() {
			return lat;
		}
		public void setLatitude(double latitude) {
			this.lat = latitude;
		}
		public double getLongitude() {
			return lng;
		}
		public void setLongitude(double longitude) {
			this.lng = longitude;
		}
		
}
