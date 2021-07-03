#include <iostream>
#include <vector>
#include <algorithm>
#include <iomanip>

using namespace std;

double median(vector<int> a) {
    int n = a.size();
    
    double m = a[n / 2];
    
    if (! (n & 1)) { 
        m += a[n / 2 - 1];
        m /= 2;
    }
    
    return m;
}

int main() {
    int n;
    cin >> n;
    
    vector<int> a(n);
    
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    
    for (int i = 0; i < n; i++) {
        
        int f;
        cin >> f;
        
        f--;
        for (int j = 0; j < f; j++) {
            a.push_back(a[i]);
        }
        
    }
    
    sort(a.begin(), a.end());
    
    n = a.size();
    
    vector<int> l;
    vector<int> u;

    if (n & 1) {
        for (int i = 0; i < (n / 2); i++) {
            l.push_back(a[i]);
        }
        
        for (int i = (n / 2) + 1; i < n; i++) {
            u.push_back(a[i]);
        }
    } else {
        for (int i = 0; i < (n / 2); i++) {
            l.push_back(a[i]);
        }
        
        for (int i = (n / 2); i < n; i++) {
            u.push_back(a[i]);
        }
    }
    
    double q1 = median(l);
    double q3 = median(u);
    double ir = q3 - q1;
    
    cout << setprecision(1) << fixed << ir << endl;
    
    return 0;
}