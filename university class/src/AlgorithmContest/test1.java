package AlgorithmContest;

import java.util.ArrayList;
import java.util.Arrays;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int gamenum = 6;
		int teamnum = 12;
		
		ArrayList<Integer>[] graph = new ArrayList[teamnum];
		
		int[] check = new int[teamnum];
	
		int[][] a=new int[12][6];
		
		for (int i = 0; i < teamnum; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		int team1;
		int team2;
		boolean checked;
		
		for (int i = 0; i < gamenum; i++) {
			int count=0;
			Arrays.fill(check, 0);
			
			while(true){
				if(count==12)
					break;

				team1 = (int)(Math.random() * 12);
				while (true) {
					team2 = (int) (Math.random() * 12);
					if(team1!=team2)
						break;
				}
				if(insert_team(check, team1, team2) && isfight_team(graph,team1,team2)){
					graph[team1].add(team2);
					graph[team2].add(team1);
					count=count+2;
				}
			}
			System.out.println(graph[0].get(i));
		}
		System.out.println("a");
		
		
	}

	public static boolean insert_team(int[] check, int team1, int team2) {
		if (check[team1] == 0 && check[team2]==0) {
			check[team1]++;
			check[team2]++;
			return true;
		}else{
			return false;
		}

	}
	public static boolean isfight_team(ArrayList<Integer>[] graph,int team1,int team2){
		
		if(graph[team1].contains(team2)){
			return false;
		}else{
			return true;
		}
	}
}
