#include<iostream>
#include<algorithm>
#include<queue>
using namespace std;

int mini = 10000; // 임의의 큰수
long long A, B, cnt;

void dfs(long long a, int cnt)
{
	if (a > B) return;

	if (a == B)
	{
		mini = min(mini, cnt);
	}
	dfs(a * 2, cnt + 1);
	dfs(a * 10 + 1, cnt + 1);

}

int main()
{
	cin >> A >> B;

	dfs(A, 1);
	
	if (mini == 10000) cout << -1;
	else cout << mini;
}