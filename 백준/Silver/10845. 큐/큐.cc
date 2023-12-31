#include <iostream>
#include <queue>
#include <string>

using namespace std;

int main()
{
    int n, m; 
    cin >> n;
    
    string s, t;
    queue<int> q;
    
    for(int i=0; i<n; i++){
        cin >> s;
        
        if(s == "push"){
            cin >> m;
            q.push(m);
        }
        
        else if(s == "pop"){
            if(!q.empty()){
                m = q.front();
                cout << m << "\n";
                q.pop();
            }
            else cout << "-1\n";
        }
        
        else if(s == "size"){
            cout << q.size() << "\n";
        }
        
        else if(s == "empty"){
            if(q.empty()) cout << "1\n";
            else cout << "0\n";
        }
        
        else if(s == "front"){
            if(q.empty()) cout << "-1\n";
            else cout << q.front() << "\n";
        }
        
        else if(s == "back"){
            if(q.empty()) cout << "-1\n";
            else cout << q.back() << "\n";
        }
    }
    
    return 0;
}
