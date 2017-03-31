package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class backjoon1260my2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N, M, V;// N:정점의개수, M:간선의개수, V:시작점
		boolean[] v_node;
		int a,b; // 간선이 연결하는 두 정점;
		try {
			N = s.nextInt();
			M = s.nextInt();
			V = s.nextInt();

			if (N < 1 || N > 1000 || M < 1 || M > 10000){
				new Exception();
			} else {
				v_node = new boolean[N + 1];
				ArrayList<Integer>[] graph =new ArrayList[N+1];
				
				for (int i = 1; i <= graph.length-1; i++) {
					graph[i]=new ArrayList<Integer>();
				}

				for (int i = 0; i < M; i++) {
					a = s.nextInt();
					b = s.nextInt();
					graph[a].add(b);
					graph[b].add(a);
				}
				
				for (int i = 1; i <= graph.length-1; i++) {
					Collections.sort(graph[i]);
				}
				
				// System.out.print("DFS:");
				dfs(v_node, graph, V);
				System.out.println();

				Arrays.fill(v_node, false); // 초기화

				// System.out.printf("BFS:");
				bfs(v_node, graph, V);
			}
		} catch (Exception e) {
			System.out.println("error");
			// TODO: handle exception
		}

	}
	// DFS로 돌리는 함수

	// DFS란 깊이우선탐색, 재귀 함수 사용
	public static void dfs(boolean[] v_node, ArrayList<Integer>[] group, int x) {
		// 우선 start점의 방문여부를 true로 수정
		v_node[x] = true;
		System.out.print(x + " ");
		
		// 반복문으로 start점에 연결되어 있는 모든 점을 확인
		for(int i : group[x]){
			if(v_node[i]==false){
				// 재귀 함수로 다시 dfs 호출
				dfs(v_node,group,i);
			}
		}
	}
	
	// BFS로 돌리는 함수
	// BFS란 너비 우선 탐색으로 Queue를 사용함
	// Queue는 FIFO 구조
	public static void bfs(boolean[] v_node, ArrayList<Integer>[] group, int start) {
		Queue<Integer> q = new LinkedList();
		
		// 시작점의 방문 여부를 true로 변경
		v_node[start] = true;
		// q에 시작점을 입력
		q.add(start);

		while (!q.isEmpty()) { // queue가 비어있을 때까지 계속 반복

			int x = q.remove();// 큐에서 하나 빼서 x를 저장
			System.out.print(x + " ");
			
			// 반복문으로 start에 연결된 점을 모두 확인
			for(int i : group[x]){
				if(v_node[i]==false){
					v_node[i]=true;
					q.add(i);
				}
			}
		}
	}
}
