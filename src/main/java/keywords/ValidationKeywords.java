package keywords;

import static org.testng.Assert.assertEquals;

public class ValidationKeywords extends GenericKeywords{

	public void verifyTitle(String expTitle) {
		assertEquals(getTitle(), expTitle);
		
	}
}
