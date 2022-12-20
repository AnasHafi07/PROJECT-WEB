import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil



public class randomUsername{
	@Keyword(keywordObject='SignUp')
	public String generateRandomUsername(int StrLength) {
		
		String s1 = "abcdABC12345";
		
		Random rand = new Random();
		
		StringBuilder sb = new StringBuilder();
		
		for(int j =1 ; j <= StrLength ; j++){
			sb.append(s1.charAt(rand.nextInt(s1.length())));
		}
		return sb;
	}
	
	@Keyword
	public void print(String username) {
		
	System.out.println(username + " is registered!");
	
	KeywordUtil.logInfo(username+ " is registered! ");
	
	}
}
