#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int main()
{
    string s;
    vector<int> v;
    cin >> s;
  
    
    for(int i=0; i<s.length(); i++){
        v.push_back(s[i]-'0');
    }
    
    sort(v.rbegin(), v.rend());
    
    for(int i=0; i<v.size(); i++){
        cout << v[i];
    }
    
    return 0;
}
