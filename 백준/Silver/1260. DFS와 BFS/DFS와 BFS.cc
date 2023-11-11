#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

int n, m, v;
int map[1001][1001] = { 0, }; //인접 행렬 그래프
int visited[1001]; //정점 방문 여부
queue<int> q; 
    
void DFS(int v){
    //현재 노드 방문 
    visited[v] = 1;
    cout << v << " ";
    
    //현재 노드와 인접한 노드를 큐에 넣음
    for(int i=1; i<=n; i++ ){
        if(map[v][i] == 1 && visited[i] == 0){
            DFS(i);
        }
    }
}

void BFS(int v) {
	visited[v] = 1;
	q.push(v);

	while (!q.empty()) {
		v = q.front();
		q.pop();
		cout << v << " ";
		for (int i = 1; i <= n; i++) {
			if (map[v][i]  && !visited[i]) {
				q.push(i);
				visited[i] = 1;
			}
		}
	}
}

int main()
{
    ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	
    cin >> n >> m >> v;
    
    for(int i = 1; i <= n; i++) {
        visited[i] = 0;
    }
    
    //인접 행렬 그려주기
    int a, b;
    for(int i=0; i<m; i++){
        cin >> a >> b;
        map[a][b] = 1;
        map[b][a] = 1;
        
    }
    
    DFS(v);
    cout << "\n"; 
    
    for(int i = 0; i <= n; i++) {
        visited[i] = 0;
    }
    

    BFS(v);
    
    return 0;
}