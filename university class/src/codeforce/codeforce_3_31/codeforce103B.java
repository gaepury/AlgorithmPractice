package codeforce.codeforce_3_31;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//3.28 B. Cthulhu
public class codeforce103B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int n,m;
		int a,b;
		try {
			n=s.nextInt();
			m=s.nextInt();
			if(n<1 || n>100 || m<0 || m>(((n)*(n-1))/2)){
				throw new Exception();
			}else{
				//graph
				ArrayList<Integer>[] graph=new ArrayList[n+1];
				//规巩畴靛咯何
				boolean[] v_node = new boolean[n+1];
				for(int i=1;i<=graph.length-1;i++){
					graph[i]=new ArrayList();
				}
				//graph 积己
				for(int j=0;j<m;j++){
					a=s.nextInt();
					b=s.nextInt();
					graph[a].add(b);
					graph[b].add(a);
				}
				for(int i=1;i<=n;i++){
					Collections.sort(graph[i]);
				}
				
				String result="";
				
				if(m!=n){
					result="NO";
				}else{
					dfs(v_node,graph,1);
					for(int i=1;i<=m;i++){
						if(v_node[i]==false){
							result="NO";
						}
					}
					result = result!="NO"? "FHTAGN!" : result;
				}
				System.out.println(result);
				
			}
		} catch (Exception e) {
			System.out.println("error");
			// TODO: handle exception
		}
	}

	public static void dfs(boolean[] v_node, ArrayList<Integer>[] graph, int x){
		v_node[x]=true;
		
		for(int i : graph[x]){
			if(v_node[i]==false){
				dfs(v_node,graph,i);
			}
		}
	}

}
