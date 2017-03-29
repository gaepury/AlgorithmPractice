
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class backjoon1260 {

	static int n, m, start; // n은 정점 m은 간선 start는 시작 정점

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		boolean exception = false;

		try {

			do {

				n = sc.nextInt(); // 정점의 개수를 입력받음

				m = sc.nextInt(); // 간선의 개수를 입력받음

				start = sc.nextInt(); // 시작 정점을 입력받음

				// 범위에 대한 예외 처리

				if (n < 1 || m < 1 || start < 1) {

					System.out.println("1보다 큰 수로 다시 입력해주세요");

					exception = true;

				} else if (n > 1000 || m > 10000 || start > n) {

					System.out.println("정점의 개수는 1000이하 간선의 개수는 10000이하 입니다. 다시 입력해주세요.");

					exception = true;

				} else {

					exception = false;

				}

			} while (exception == true);

			ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[n + 1];

			// 일반 배열과 동일하지만 ArrayList의 장점은 데이터만큼만 메모리를 사용하기 때문에 메모리의 손실이 없다.

			// 정점의 개수보다 한개 더 추가 -> 배열은 0부터 n-1까지인데 편의상 1을 더해서 n까지 이용하기 위함

			// 입력받을 때 편리하게

			for (int i = 1; i <= n; i++) {

				graph[i] = new ArrayList<Integer>();

			} // 2차원 배열로 생성

			for (int i = 0; i < m; i++) {

				int u = sc.nextInt();

				int v = sc.nextInt();

				graph[u].add(v); // u에 연결된 점으로 v 추가

				graph[v].add(u); // v에 연결된 점으로 u 추가

			}

			for (int i = 1; i <= n; i++) {

				Collections.sort(graph[i]);

				// 각 정점마다 연결 된 정점을 크기 순으로 순서대로 정렬함

				// sort는 기본 오름차순

			}

			// 각 정점을 방문했는지 확인하기 위한 배열

			boolean[] c = new boolean[n + 1];

			System.out.print("DFS : ");

			dfs(graph, c, start);

			System.out.println();

			// c 배열을 false로 초기화

			Arrays.fill(c, false);

			System.out.print("BFS : ");

			bfs(graph, c, start);

			System.out.println();

		} catch (Exception e) {

			System.out.println("자연수가 아닌 수를 입력했습니다. 다시 실행해주세요.");

		}

	}

	// DFS로 돌리는 함수

	// DFS란 깊이우선탐색, 재귀 함수 사용

	public static void dfs(ArrayList<Integer>[] a, boolean[] c, int x) {

		if (c[x]) {
			return;
		}
		// 우선 x점의 방문여부를 true로 수정
		c[x] = true;
		// x 출력
		System.out.print(x + " ");

		// 반복문으로 점 x에 연결되어 있는 모든 점을 확인

		for (int y : a[x]) {

			// 방문여부가 false이면

			if (c[y] == false) {

				// 재귀 함수로 다시 dfs 호출

				dfs(a, c, y);

			}

		}

	}

	// BFS로 돌리는 함수

	// BFS란 너비 우선 탐색으로 Queue를 사용함

	// Queue는 FIFO 구조

	public static void bfs(ArrayList<Integer>[] a, boolean[] c, int start) {

		// 자바에서 기본적으로 제공하는 Queue를 사용

		Queue<Integer> q = new LinkedList<Integer>();

		// q에 시작점을 입력

		q.add(start);

		// 시작점의 방문 여부를 true로 변경

		c[start] = true;

		while (!q.isEmpty()) { // queue가 비어있을 때까지 계속 반복

			int x = q.remove(); // queue에서 하나를 뺴서 x에 저장

			System.out.print(x + " "); // x 출력

			for (int y : a[x]) { // 반복문으로 x에 연결된 점을 모두 확인

				if (c[y] == false) { // 방문여부가 false 라면

					c[y] = true; // 방문여부를 true로 바꾸고

					q.add(y); // q에 입력

				}

			}

		}

	}

}
