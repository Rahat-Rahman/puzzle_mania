package HelperLayer;

public class ValidationHelper {

	public static boolean IsIntValid(String data)
	{
		try{
			Integer.parseInt(data);
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	
	
}
