#include <iostream>
#include <vector>
using namespace std;

vector<int> v[1001];
int visited[1001]={0,};
int count = 0;

void dfs(int n){
    visited[n] = 1;
    for(int i=0; i<v[n].size(); i++) {
        int x = v[n][i];
        if(visited[x] == 0) dfs(x);
    }
}

int main()
{
    int n, m;
    cin >> n >> m;
    
    int a, b;
    for(int i=0; i<m; i++){
        cin >> a >> b;
        v[a].push_back(b);
        //인접한 노드 두 쪽 모두 해줘야함! (무방향 그래프)
        v[b].push_back(a);
    }
    
    for(int i=1; i<=n; i++){
        if(visited[i] == 0){
            dfs(i);
            count++;
        }
    }
    cout << count << "\n";
    return 0;
}
