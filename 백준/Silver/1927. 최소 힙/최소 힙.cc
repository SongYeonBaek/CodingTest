#include <iostream>
#include <queue>
using namespace std;

int main()
{
    cin.tie(NULL);
    cin.sync_with_stdio(false);
    
    int n, m;
    cin >> n;
    
    priority_queue<int, vector<int>, greater<int>> pq;
    for(int i=0; i<n; i++){
        cin >> m;
        
        if(m == 0){
            if(pq.empty()) cout << 0 <<"\n";
            else {
                cout <<pq.top() <<"\n";
                pq.pop();
            }
        }
        else {
            pq.push(m);
        }
    }
    return 0;
}
