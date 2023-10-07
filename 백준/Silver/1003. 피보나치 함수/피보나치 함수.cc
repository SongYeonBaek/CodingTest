#include <iostream>
#include <vector>
using namespace std;


int main() {
    int T, m;
    vector<pair<int, int>> v;
    
    cin >> T;
    
    v.push_back({1,0});
    v.push_back({0,1});
    
    int a, b;
    for(int i=2; i<=40; i++){
        a = v[i-1].first + v[i-2].first;
        b = v[i-1].second + v[i-2].second;
        v.push_back({a,b});
    }
    
    for(int i=0; i<T; i++){
        cin >> m;
        cout << v[m].first << " " << v[m].second << "\n";
    }

}