package BOJ.q14621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * BOJ Q14621 나만 못하는 연애
 * 그래프, 최소비용, prim
 */
public class Main {
	static int V, E, distance; //정점의 수, 간선의 수, 최소거리
	static Vortex[] vortexs; //정점의 배열
	static ArrayList<Edge>[] adjList; //인접리스트 배열
	static boolean[] visited; //방문여부체크 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		vortexs = new Vortex[V + 1];
		adjList = new ArrayList[V + 1];
		visited = new boolean[V + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= V; i++) {
			vortexs[i] = new Vortex(i, st.nextToken().charAt(0)); //정점의 특징 저장
			adjList[i] = new ArrayList<>(); //인접리스트 생성
		}

		for (int i = 0; i < E; i++) { //인접리스트에 간선정보 넣기, 양방향그래프이므로 from에서 to에서 둘다 넣기
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from].add(new Edge(to, weight));
			adjList[to].add(new Edge(from, weight));
		}
		
		if(prim(1)) //모든 정점을 탐색했으면 최소거리 출력
			System.out.println(distance);
		else //모든 정점을 탐색하지 못했으면 -1 출력
			System.out.println(-1);
	}

	/**
	 * 간선 정보를 저장하는 클래스
	 */
	static class Edge implements Comparable<Edge> {
		int to, weight;

		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		//우선순위 큐를 사용하기 위해 weight 기준으로 오름차순 정렬
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	/**
	 * 정점의 정보를 저장하는 배열
	 */
	static class Vortex {
		int id;
		char ch;

		public Vortex(int id, char ch) {
			super();
			this.id = id;
			this.ch = ch;
		}
	}

	/**
	 * prim 알고리즘을 통해 최소거리를 구하는 메서드, 모든 정점 탐색 시 true 반환, 모든 정점을 탐색하지 못하면 false 반환
	 * @param start 처음 시작 정점
	 * @return
	 */
	static boolean prim(int start) {
		PriorityQueue<Edge> pQueue = new PriorityQueue<>();
		pQueue.offer(new Edge(start, 0)); //시작은 임의의 정점
		int cnt = 0; //방문 정점 수
		boolean isCheck = false; //모든 정점을 방문했는지 체크하는 boolean 변수
		while(!pQueue.isEmpty()) { //큐가 비어있을 때까지 수행
			Edge now = pQueue.poll();
			if(visited[now.to]) //이미 방문한 정점이면 넘기기
				continue;
			visited[now.to] = true; //방문 체크
			distance += now.weight; //거리 더해주기
			for(int i = 0; i<adjList[now.to].size(); i++) { //해당 정점에서 연결된 다음 정점 찾기
				Edge next = adjList[now.to].get(i); 
				if(vortexs[now.to].ch != vortexs[next.to].ch && !visited[next.to]) { //다음 정점이 방문하지 않은 상태고, 현재 정점이 남초일때 여초, 여초일때 남초가 아닐때
					pQueue.add(next); //큐에 저장
				}
			}
			if(++cnt == V) { //모든 정점을 방문 했을 때 메서드 종료
				isCheck = true; 
				break;
			}
		}
		return isCheck;
	}
}
