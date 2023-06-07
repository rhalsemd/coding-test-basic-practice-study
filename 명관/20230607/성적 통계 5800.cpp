#include <iostream>
#include <algorithm>
using namespace std;
int k, n, c;
int cmp(const int &a, const int &b)
{
    return a > b;
}
int main() {
    cin >> k;
    while (k--)
    {
        int lg = 0;
        cin >> n;
        int *a = new int[n];
        for (int i = 0; i < n; i++)
            cin >> a[i];
        sort(a,a+n,cmp);
        for (int i = 0; i < n - 1; i++)
            if (lg < a[i] - a[i+1])
                lg = a[i] - a[i+1];
        cout << "Class " << ++c<<'\n';
        cout << "Max " << a[0] << ", Min " << a[n-1] << ", Largest gap " << lg <<'\n';
    }
}