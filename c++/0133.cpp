#include"graph.h"
#include<vector>
#include<map>
using namespace std;

class Solution0133 {
public:
    map<Node*, Node*> visited;
    Node* cloneGraph(Node* node) {
        if (node == nullptr) {
            return nullptr;
        }
        if (visited.count(node) != 0) {
            return visited[node];
        }
        Node* newNode = new Node(node->val);
        visited[node] = newNode;

        for (Node* neighbor : node->neighbors) {
            newNode->neighbors.push_back(cloneGraph(neighbor));
        }
        return newNode;
    }
};