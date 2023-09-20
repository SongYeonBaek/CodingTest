#include <iostream>

using namespace std;

int main()
{
    int n, f1, f2, f=0;
    cin >> n;
    
    f1 = 0; 
    f2 = 1;
    
    if(n == 1) {
        cout << 1 <<"\n";
        return 0;
    }
    
    while (n>1){
        f = f1 + f2;
        f1 = f2;
        f2 = f;
        n--;
    }
    
    cout << f << "\n";
    return 0;
}
