package data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class InternalDataManager {

	private static InternalDataManager instance;
	private String userName;
	private String userId;
	
	public static InternalDataManager getInstance() {
		if (instance == null) {
			instance = new InternalDataManager();
		}
		return instance;
	}
	
	private InternalDataManager() {
		this.userName = "defaultUser";
		this.userId   = "defaultId";

		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("config/properties");
			prop.load(input);

			this.userName = prop.getProperty("userName");
			this.userId = prop.getProperty("userId");
			
			System.out.println(userName);
			System.out.println(userId);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

	public String getUserName() {
		return userName;
	}

	public String getUserId() {
		return userId;
	}

}
