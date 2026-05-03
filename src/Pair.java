import java.util.ArrayList;
import java.util.List;

public class Pair<T> {

	private static List<Pair<String>> logins = new ArrayList<>();
	
	private String login;
	private String password;
	private static boolean exists = false;
	
	
	public Pair() {
		
	}
	
	public Pair(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void addLogIn() {
		logins.add((Pair<String>) this);
	}
	
	public boolean existingLogin() {
		
		
		for(int i = 0; i < logins.size();i++) {
			if(login.equals(logins.get(i).getLogin()) && password.equals(logins.get(i).getPassword()))
				exists = true;
			
		}
		if(exists)
			return true;
		else
			return false;
			
	}
	
	
	
	
	static class PasswordRules {
		public boolean isStrongPassword(String password) throws InvalidPasswordException{
			
			boolean capsCheck = false;
			boolean lowerCheck = false;
			boolean numCheck = false;
			
			
			if(password.length()>= 8) {
				for(int i = 0; i < password.length(); i++) {
					if (Character.isUpperCase(password.charAt(i)))
						capsCheck = true;
					else if (Character.isLowerCase(password.charAt(i)))
						lowerCheck = true;
					else if (Character.isDigit(password.charAt(i)))
						numCheck = true;
				}
			}
			
			if (capsCheck && lowerCheck && numCheck)
				return true;
			else {
				throw new InvalidPasswordException();
				
			}
			
		}
	}
	
	class LoginLoger {
		
		private List<String> loginResults = new ArrayList<>();
		
		public void loginStatusAdd(Pair<String> user,boolean status){
			if (status)
				loginResults.add("User: "+user.getLogin()+" - SUCCESS");
			else
				loginResults.add("User: "+user.getLogin()+" - FAILED");
		}
		
		public void LoginLog() {
			System.out.println("Login Log:\n");
			
			for(int i = 0; i < loginResults.size();i++) {
				System.out.println(loginResults.get(i));
			}
			
		}
	}
	
	
	class Anonymous {
		
		public boolean securityCheck(int answer) {
			return (answer == 8);
		}
		
	}
}
