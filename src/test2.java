import java.util.HashSet;
import java.util.Iterator;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=2;
		int[][] land1= new int[][]{{1,2},{2,3}};
		int[][] land2= new int[][]{{4,4,3},{3,2,2},{2,1,0}};
		int P=5;
		int Q=3;
		int result;
		HashSet hs=new HashSet();
		
		
		for(int i=0;i<land2.length;i++){
			for(int j=0;j<land2[0].length;j++){
				hs.add(land2[i][j]);
			}
		}
		Iterator it=hs.iterator();
		
		long minsum=Long.MAX_VALUE;
		while(it.hasNext()){
			int h=(int)it.next();
			int sum=0;
			System.out.println(h);
			
			for(int i=0;i<land2.length;i++){
				for(int j=0;j<land2[0].length;j++){
					if(h>land2[i][j]){
						sum+= (h-land2[i][j])*P;
					}else {
						sum+= (land2[i][j]-h)*Q;
					}
				}
			}
			System.out.println(sum);
			if(minsum>sum){
				minsum=sum;
			}
			
		}
		
		System.out.println(minsum);
	}

}
