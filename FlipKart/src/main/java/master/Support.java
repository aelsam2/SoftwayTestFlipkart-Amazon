package master;

public class Support {

	public int SpecialCharstringToNum(String str) {
		str = str.replaceAll("[₹,]", ""); 
		int num = Integer.parseInt(str);
	   return num;
	}

}
