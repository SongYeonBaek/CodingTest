#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    int n;
    cin >> n;
    
    int tri[n][n];
    
    //삼각형 입력 받기
    for(int i=0; i<n; i++){
        for(int j = 0; j<=i; j++){
            cin >> tri[i][j];
        }
    }
    
    //풀이: 가장 아랫줄부터 시작해서 삼각형을 수정해나감
    for(int i=n-1; i>0 ; i--){
        for(int j=0; j<i; j++){
            tri[i-1][j] += max(tri[i][j], tri[i][j+1]);
        }
    }
    
    cout <<  tri[0][0] <<"\n";
    
    return 0;
}