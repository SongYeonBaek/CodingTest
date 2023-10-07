#include <iostream>

using namespace std;

int main()
{
    int t, m;
    long long n[101] = {1, 1, 1, 2 , 2 ,};
    
    for(int i=5; i<101; i++){
        n[i] = n[i-1] + n[i-5];
    }
    
    cin >> t;
    
    for(int i=0; i<t; i++){
        cin >> m;
         cout << n[m-1] << "\n";
    }
    
    
    
    return 0;
}
