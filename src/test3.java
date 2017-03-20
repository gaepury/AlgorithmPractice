
public class test3 {
	public static void main(String[] args) {
		int[][] grid1 = new int[][]{{3,4,5},{2,3,4},{1,2,3}};
		int[][] grid2 = new int[][]{{2,1,1,0,1},{1,2,0,3,0},{0,1,5,1,2},{0,0,1,3,1},{1,2,0,1,1}};
		int k=2;
		
		
		int maxsum=0;
		for(int i=0;i<k;i++){
			for(int j=0;j<k;j++){
				maxsum+=grid2[i][j];
			}
		}
		for(int i=k;i<k+k;i++){
			for(int j=0;j<k;j++){
				maxsum+=grid2[i][j];
			}
		}
		
		for (int i = 0; i < grid2.length/2+1; i++) {
			for(int j=0;j<grid2[0].length/2+1;j++){
				int sum=0;
				int temp;
				temp= calwidth(grid2,k,i,j);
				if(temp==-1)
					continue;
				else{
					sum+=temp;
					System.out.println(sum+"a");
				}
				sum += remaincalwidth(grid2,k,i,j);
				if(maxsum<sum){
					maxsum=sum;
				}
			}
		}
		
		System.out.println(maxsum);
		
		
		
		
		
	}
	//정사각형 넓이 
	public static int calwidth(int[][] grid,int k,int row,int col){
		int sum=0;
		if(row+k-1>grid.length-1 || col+k-1>grid[0].length-1){
			return -1;
		}else{
			for (int i = row; i < row+k; i++) {
				for(int j= col ; j <col+k; j++){
					sum+=grid[i][j];
				}
			}
			return sum;
		}
				
	}
	public static int remaincalwidth(int[][] grid,int k,int row,int col){
		int maxnum=-1;
		for(int i=0;i<grid.length/2+1;i++){
			for(int j=0;j<grid[0].length/2+1;j++){
				int temp;
				if(j+k<col+1){
					temp=calwidth(grid,k,i,j);
				}else if(j>col+k-1){
					temp=calwidth(grid,k,i,j);
				}else if(i+k<row+1){
					temp=calwidth(grid,k,i,j);
				}else if(i>row+k-1){
					temp=calwidth(grid,k,i,j);
				}else{
					temp=-1;
				}
				
				if(temp==-1){
					continue;
				}
				if(maxnum<temp){
					maxnum=temp;
				}
			}
		}
		System.out.println(maxnum+"b");
		return maxnum;
	}
}
