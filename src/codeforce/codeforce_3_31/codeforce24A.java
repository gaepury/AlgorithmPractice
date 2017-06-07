package codeforce.codeforce_3_31;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//3.28 A. Ring road
public class codeforce24A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		
		int n;
		
		try {
			n=s.nextInt();
			int a,b,c;
			//방문노드여부
			
			if(n<3 || n>100){
				throw new Exception();
			}else{
				//방문한 노드인지
				boolean[] v_node=new boolean[n+1];
				//graph
				ArrayList[] graph=new ArrayList[n+1];
				for(int i=1;i<=graph.length-1;i++){
					graph[i]=new ArrayList();
				}
				
				
				for(int i=1;i<=n;i++){
					a=s.nextInt();
					b=s.nextInt();
					c=s.nextInt();
					graph[a].add(b);
					graph[b].add(a);
				}
			
				
				dfs(v_node,graph,1);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void dfs(boolean[] v_node, ArrayList<Integer>[] graph,int x){
		v_node[x]=true;
		
		System.out.println(x+",");
		
		for(int i : graph[x]){
			if(v_node[i]==false){
				dfs(v_node,graph,i);
			}
		}
	}

}
