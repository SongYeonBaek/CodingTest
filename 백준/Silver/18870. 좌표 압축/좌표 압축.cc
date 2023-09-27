#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    int n, m;
    cin >> n;

    vector<int> v, r;
    for(int i=0; i<n; i++){
        cin >> m;
        v.push_back(m);
        r.push_back(m);
    }
    
    sort(v.begin(), v.end());
    v.erase(unique(v.begin(), v.end()), v.end());
    
    for(int i=0; i<n; i++){
        cout << lower_bound(v.begin(), v.end(), r[i]) - v.begin() << " ";
    }
    
    return 0;
}
