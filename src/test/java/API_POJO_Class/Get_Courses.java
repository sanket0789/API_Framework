package API_POJO_Class;

public class Get_Courses {

	//For normal Json the return type will be String
	//private String dashboard ;
	
	//Here the dashboard is nested json, Hence the return type is class name.
	private Dashboard_POJO dashboard ;
	private String courses ;
	
	public Dashboard_POJO getDashboard() {
		return dashboard;
	}
	public void setDashboard(Dashboard_POJO dashboard) {
		this.dashboard = dashboard;
	}
	public String getCourses() {
		return courses;
	}
	public void setCourses(String courses) {
		this.courses = courses;
	}
	
	
	
	
}
