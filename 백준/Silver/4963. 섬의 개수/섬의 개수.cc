#include <iostream>
using namespace std;

int map[51][51]={0,};
int visited[51][51] = {0,};
int xpos[8] = {-1, 1, 0, 0, -1, -1, 1, 1}; 
int ypos[8] = {0, 0, 1, -1, 1, -1, 1, -1};
int w, h;
int cnt;

void dfs(int y, int x){
    visited[y][x] = 1;
    
    for(int i=0; i<8; i++){
        int nxpos = x + xpos[i];
        int nypos = y + ypos[i];
        
        if( nxpos < 1 || nxpos > w || nypos < 1 || nypos > h) continue;
        if(visited[nypos][nxpos]==0 && map[nypos][nxpos]==1) dfs(nypos, nxpos);
    }
    
}

int main()
{
    while(1){
        cin >> w >> h;
        //0 0이 나오면 테스트 케이스 끝끝
        if(w==0 && h==0) break;
        
        for(int i=1; i<=h; i++){
            for(int j=1; j<=w; j++) {
                cin >> map[i][j];
            }
        }
        
        cnt=0;
        for(int i=1; i<=h; i++){
            for(int j=1; j<=w; j++){
                if(map[i][j] == 1 && visited[i][j] == 0) {
                    cnt++;
                    dfs(i,j);
                }
            }
        }
        
        cout << cnt << "\n";
        
        //0으로 다시 초기화화
        for(int i=1; i<=h; i++){
            for(int j=1; j<=w; j++) {
                map[i][j]=0;
                visited[i][j]=0;
            }
        }
    }
    
    return 0;
}