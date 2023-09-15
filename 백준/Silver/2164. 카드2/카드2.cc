#include <iostream>
#include <queue>

using namespace std;

int main()
{
    int n, m; 
    cin >> n;
    
    queue<int> q;
    for(int i=1; i<=n; i++){
        q.push(i);
    }
    
    while(q.size() > 1){
        q.pop();
        m  = q.front();
        q.pop();
        q.push(m);
    }

    cout << q.front() << "\n";
    return 0;
}