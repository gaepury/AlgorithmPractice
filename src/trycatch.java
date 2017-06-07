
public class trycatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("1");
			throw new Exception();
		} catch (Exception e) {
			System.out.println("2");	
		} finally {
			System.out.println("3");
			// TODO: handle finally clause
		}
	}

}
