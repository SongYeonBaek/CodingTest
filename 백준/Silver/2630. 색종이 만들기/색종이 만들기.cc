#include <iostream>

using namespace std;

int arr[128][128];
int white =0; 
int blue = 0;

void slice(int start_col, int start_row, int size){
    int f = arr[start_col][start_row];
    
    for(int i=start_col; i<start_col+size; i++){
        for(int j=start_row; j<start_row+size; j++){
            if(f != arr[i][j] ) {
                slice(start_col, start_row, size/2);
                slice(start_col, start_row+size/2, size/2);
                slice(start_col+size/2, start_row, size/2);
                slice(start_col+size/2, start_row+size/2, size/2);
                return;
            }
            
        }
    }
    
    if(f == 0) {
        white++;
        return;
    }
    
    else if( f == 1) {
        blue++;
        return;
    }
}

int main()
{
    int n;
    cin >> n;
    
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            cin >> arr[i][j];
        }
    }
    
    slice(0, 0, n);
    
    cout << white << "\n";
    cout << blue << "\n";
    
    return 0;
}