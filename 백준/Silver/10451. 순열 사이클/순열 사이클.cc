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
    
    int T;
    cin >> T;
    
    int n;

    while(T--){
        int count = 0;
        cin >> n;
        
        //각각의 테스트 케이스에 대해 순열을 저장
        int a;
        for(int i=1; i<=n; i++){
            cin >> a;
            v[i].push_back(a);
        }
        
        for(int i=1; i<=n; i++){
            if(visited[i] == 0){
                dfs(i);
                count++;
            }
        }
        
        cout << count << "\n";
        
        //벡터, visited 배열 초기화 
        for(int i=1; i<=n; i++){
            v[i].clear();
            visited[i] = 0;
        }
    }
    
    return 0;
}
