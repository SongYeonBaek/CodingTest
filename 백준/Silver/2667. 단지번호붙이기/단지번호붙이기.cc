#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int map[26][26]={0,};
int visited[26][26] = {0,};
int xpos[4] = {-1, 1, 0, 0 }; 
int ypos[4] = {0, 0, 1, -1};
int n;

//집의 개수를 저장할  벡터, 집의 개수를 count할 변수 count  
vector<int> v;
int cnt;

void dfs(int x, int y){
    cnt++;
    visited[x][y] = 1;
    
    for(int i=0; i<4; i++){
        int nxpos = x + xpos[i];
        int nypos = y + ypos[i];
        
        if( nxpos < 1 || nxpos > n || nypos < 1 || nypos > n) continue;
        if(visited[nxpos][nypos]==0 && map[nxpos][nypos]==1) dfs(nxpos, nypos);
    }
    
}

int main()
{
  
   cin >> n;
  //string으로 입력 받고 나눠서 행렬에 저장하기
    string str;
   for(int i=1; i<=n; i++){
       cin >> str;
       for(int j=0; j<n; j++){
           //문자열에서 정수로 변환하려면 48을 빼면 됨
           map[i][j+1] = str[j] - 48 ;
       }
   }
    

    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            if(map[i][j]==1 && visited[i][j]==0) {
                cnt = 0;
                dfs(i, j);
                v.push_back(cnt);
            }
        }
    }
    
    cout << v.size() << endl;
    sort(v.begin(), v.end());
    for(int i = 0; i < v.size(); i++) 
        cout << v[i] <<endl;
    
    return 0;
}