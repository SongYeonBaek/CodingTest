#include <iostream>
#include <vector>
using namespace std;

vector<int> v[101];
int visited[101]={0,};
int count = 0; 

void dfs(int n){
    count++;
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
        v[b].push_back(a);
    }
    
    dfs(1);
    
    cout << count-1 << "\n";
    return 0;
}