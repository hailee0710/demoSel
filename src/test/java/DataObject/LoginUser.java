package DataObject;

import Utilities.DataProvider;

public class LoginUser {
	
	private DataProvider dataProvider;
	
	public String getEmail() throws Throwable{
		dataProvider = new DataProvider();
		return dataProvider.getData("\\Data\\Login_user_data.txt", 0, 0);
		
	}
	
	public String getPassword() throws Throwable{
		return dataProvider.getData("\\Data\\Login_user_data.txt", 0, 1);
	}

}
