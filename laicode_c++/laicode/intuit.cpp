#include <algorithm>
#include <iostream>
#include <vector>
#include <unordered_map>
#include <set>
#include <queue>

using namespace std;

vector<vector<string>> createWorkflowStages(const vector<vector<string>>& precursorSteps) {
    //base case
    if(precursorSteps.empty() || precursorSteps.size()<1) {
        return {};
    }
    vector<vector<string>> result;
    unordered_map<string, int> indegree;  //topo sort, indegree
    unordered_map<string, bool> visited;  //visited marker
    unordered_map<string, vector<string>> graph;  //topo graph
    for (auto edge : precursorSteps) {
        indegree[edge[0]]=0;  //init indegree
        indegree[edge[1]]=0;  //init indegree
    }
    for (auto edge : precursorSteps) {
        graph[edge[0]].push_back(edge[1]);  //add dependent
        indegree[edge[1]]++;  //add indegree
    }
    queue<string> que;
    for (int i=0; i<precursorSteps.size(); i++) {
        if (indegree[precursorSteps[i][0]]==0) {
            que.push(precursorSteps[i][0]);
        }
    }
    //topo sort body, find indegree=0 nodes, remove, decrease dependent indegree
    while (!que.empty()) {
        int size=que.size();
        vector<string> curr;
        for (int i=0; i<size; i++) {
            string temp = que.front(); que.pop();
            if (visited[temp]==false) {
                curr.push_back(temp);
                for (auto it:graph[temp]) {
                    if (--indegree[it]==0) {
                        que.push(it);
                    }
                }
                visited[temp]=true;
            }
        }
        result.push_back(curr);
    }
    return result;
}


// You can add test cases below. Each test case should be an instance of Test
// initialized with:
//
// {
//   // name
//   "my custom test",
//   // input
//   {{"step1", "step2"}},
//   // expected output
//   {{"step1"}, {"step2"}}
// }
//

class Test {
public:
    string name;
    vector<vector<string>> input;
    vector<vector<string>> expectedOutput;
};

// START TEST CASES

const vector<Test> tests = {
    {
        // name
        "build stages",
        // input
        {
            {"clean", "build"},
            {"metadata", "binary"},
            {"build", "link"},
            {"link", "binary"},
            {"clean", "metadata"},
            {"build", "resources"}
        },
        // expected output
        {
            {"clean"},
            {"build", "metadata"},
            {"resources", "link"},
            {"binary"}
        }
    },
    {
        // name
        "making dinner",
        // input
        {
            {"boil", "serve"},
            {"chop", "boil"},
            {"stir", "boil"},
            {"set table", "serve"}
        },
        // expected output
        {
            {"chop", "stir", "set table"},
            {"boil"},
            {"serve"}
        }
    }
};

// END TEST CASES
// DO NOT MODIFY BELOW THIS LINE

bool equalOutputs(const vector<vector<string>>& a, const vector<vector<string>>& b) {
    if (a.size() != b.size()) {
        return false;
    }
    for (size_t i = 0; i < a.size(); i++) {
        auto a1 = a[i];
        auto b1 = b[i];
        sort(a1.begin(), a1.end());
        sort(b1.begin(), b1.end());
        if (a1 != b1) {
            return false;
        }
    }
    return true;
}

int main() {
    int passed = 0;
    for (auto& test : tests) {
        cout << "==> Testing " << test.name << "..." << endl;
        try {
            auto actualOutput = createWorkflowStages(test.input);
            if (equalOutputs(actualOutput, test.expectedOutput)) {
                cout << "PASS" << endl;
                passed++;
            } else {
                cout << "FAIL" << endl;
            }
        } catch (const exception& e) {
            cout << "FAIL" << endl;
            cout << e.what() << endl;
        }
    }
    cout << "==> Passed " << passed << " of " << tests.size() << " tests" << endl;
}
