#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

bool cmp(pair<int, string> age, pair<int, string> name)
{
	return age.first < name.first;
}

int main()
{
    int n, m;
    string s;
    vector<pair<int, string>> v;
    
    cin >> n;
    
    for(int i=0; i<n; i++){
        cin >> m >> s;
        v.push_back({m, s});
    }
   
    stable_sort(v.begin(), v.end(), cmp);
    
    for(int i=0; i<n; i++){
        cout << v[i].first << " " <<v[i].second<<"\n";
    }
    
    return 0;
}
