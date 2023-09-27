#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

vector<pair<int, string>> v;

bool cmp(pair<int, string> a, pair<int, string> b){
    int asize = a.first;
    int bsize = b.first;
    int asum = 0;
    int bsum = 0;
    
    //1. 길이가 짧은 것이 먼저 오도록 sort
    if(a.first!= b.first) {
        return a.first < b.first;
    }
    
    //2.길이가 같으면, 숫자의 합이 적은 순서대로 sort
    for(int i=0; i<a.first; i++){
        // 문자열 a에 포함된 정수 합 계산
        if(a.second[i] >= 48 && a.second[i] <= 57){
            asum += int(a.second[i]) - '0';
        }
        
        //문자열 b에 포함된 정수 합 계산
        if(b.second[i] >= 48 && b.second[i] <= 57){
            bsum += int(b.second[i]) - '0';
        }
    }
    
    if(asum != bsum){
        return asum < bsum;
    }
    
    return a.second < b.second;
}


int main()
{
    int n;
    cin >> n;

    string s;
    for(int i=0; i<n; i++){
        cin >> s;
        v.push_back({s.length(),s});
    }
    
    sort(v.begin(), v.end(), cmp);
    
    
    for(int i=0; i<n; i++){
        cout <<v[i].second << "\n";
    }
    
    return 0;
}
