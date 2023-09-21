#include <iostream>
#include <cmath>
#include <string>

using namespace std;

void hanoi(int n, int start, int mid, int end){
    if(n == 1) {
        cout << start << " " << end << "\n";
        return;
    }
    hanoi(n-1, start, end, mid);
    cout << start << " " << end << "\n";
    hanoi(n-1, mid, start, end);
    
}

int main()
{
    int n;
    cin >> n;
    
    string a = to_string(pow(2, n));
	
	int x = a.find('.');				//pow 함수 결과가 실수형이기에 소수점 찾기
	a = a.substr(0, x);				//소수점 앞자리만 나오게하기
	a[a.length() - 1] -= 1;	        
    
    cout << a << "\n";
    
    if(n <= 20) hanoi(n, 1, 2 , 3);
    return 0;
}
