#include <iostream>
#include <string>
using namespace std;

int main() {
	string s,result = "";

	getline(cin, s);

	for (int i = 0; i < s.length(); i++) {
		if (s[i] == 'U' && result.empty()) {
			result += 'U';
		}
		else if (s[i] == 'C' && result == "U") {
			result += 'C';
		}
		else if (s[i] == 'P' && result == "UC") {
			result += 'P';
		}
		else if (s[i] == 'C' && result == "UCP") {
			result += 'C';
		}
	}
	if (result == "UCPC") {
		cout << "I love UCPC" << '\n';
	}
	else {
		cout << "I hate UCPC" << '\n';
	}
	return 0;
}