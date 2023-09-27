#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int main()
{
    int n;
    vector<int> v;
    for(int i=0; i<5; i++){
        cin >> n;
        v.push_back(n);
    }
        
    
    for(int j=0; j<4; j++){
        while(v[j]!= j+1) {
            for(int i=j; i<4; i++){
                if(v[i] > v[i+1]) {
                    n = v[i];
                    v[i] = v[i+1];
                    v[i+1] = n;
                
                    for(int p=0; p<5; p++){
                        cout << v[p] << " ";
                    }
                    cout << "\n";
                }
            }
        }
    }
    
    return 0;
}
