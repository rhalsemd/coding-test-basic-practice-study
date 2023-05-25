#include <iostream>
#include <sstream>
#include <string>
#include <vector>
using namespace std;

int main() {

    string subjectScore;
    double sum = 0;
    double totalScore = 0;
    
    for (int i = 0; i < 20; i++) {
        getline(cin, subjectScore); 
        istringstream ss(subjectScore); 

        vector<string> results; 
        
        string word;
        while (getline(ss, word, ' ')) {
            results.push_back(word);
        }
        double score = stod(results[1]);	
        totalScore += score;	
        string scoreEvaluation = results[2];
        if (scoreEvaluation == "P") {
            totalScore -= score; 
            continue;
        }
        else if (scoreEvaluation == "A+") {
            sum += (score * 4.5);
        }
        else if (scoreEvaluation == "A0") {
            sum += (score * 4.0);
        }
        else if (scoreEvaluation == "B+") {
            sum += (score * 3.5);
        }
        else if (scoreEvaluation == "B0") {
            sum += (score * 3.0);
        }
        else if (scoreEvaluation == "C+") {
            sum += (score * 2.5);
        }
        else if (scoreEvaluation == "C0") {
            sum += (score * 2.0);
        }
        else if (scoreEvaluation == "D+") {
            sum += (score * 1.5);
        }
        else if (scoreEvaluation == "D0") {
            sum += (score * 1.0);
        }
        else if (scoreEvaluation == "F") {
            sum += (score * 0.0);
        }
        
    }
    cout << fixed;
    cout.precision(6);
    cout << sum / totalScore;
    
    return 0;

}