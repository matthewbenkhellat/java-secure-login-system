import java.util.Scanner;



public class SecureLoginSystem {

	static String username;
	static String password;
	static String passwordTest;
	static boolean validity;
	static boolean looper = false;
	static int option;
	static Pair<String> field = new Pair();
	static Pair.Anonymous checker = field.new Anonymous();
	static Pair.LoginLoger loger = field.new LoginLoger();
	
	
	
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		Pair<String> field = new Pair();
		
		
		
		System.out.println("Welcome to SecureLoginSystem");
		
		
		
		while (!looper) {
			System.out.print("Do you want to (1) Register or (2) Login? ");
			
			option = keyboard.nextInt();
			
			if (option == 1) {
				System.out.print("Enter username: ");
				username = keyboard.next();
				
				while (!validity) {
					System.out.print("Enter password: ");
					password = keyboard.next();
					
					
					Pair.PasswordRules  rules = new Pair.PasswordRules();
					
					try {
						rules.isStrongPassword(password);
						
						
						Pair<String> user = new Pair(username, password);
						
						user.addLogIn();
						
						validity = true;
						
						System.out.println("Registration Successful!");
						
					}
					
					catch(InvalidPasswordException e) {
						System.out.println(e.getMessage());
					}
					
				}
				
				
				
				
				
			}
			
			else {
				System.out.print("Enter username: ");
				username = keyboard.next();
				
				System.out.print("Enter password: ");
				password = keyboard.next();
				
				Pair<String> user2 = new Pair(username, password);
				
				System.out.print("Security Check: What is 5+3? ");
				
				int answer = keyboard.nextInt();
				
				
				
				if (checker.securityCheck(answer)) {
					if(user2.existingLogin()) {
						loger.loginStatusAdd(user2, true);
						System.out.println("Login successful");
					}
					else {
						loger.loginStatusAdd(user2, false);
						System.out.println("Login unsuccessful");
					}
				}
				else {
					loger.loginStatusAdd(user2, false);
					System.out.println("Login unsuccessful");
				}
				looper = true;
			}
		}
		
		
		loger.LoginLog();
		
		
		
		

		
		
	}
}
