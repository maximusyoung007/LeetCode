#include<vector>
#include<map>
using namespace std;

class Node {
public:
    int val;
    Node* next;
    Node* random;

    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};

class Solution0138 {
    map<Node*, Node*> m;
public:
    Node* copyRandomList(Node* head) {
        if (head == nullptr) {
            return head;
        }
        if (m.count(head) != 0) {
           return m[head];
        }
        Node* newNode = new Node(head->val);
        m[head] = newNode;
        newNode->next = copyRandomList(head->next);
        newNode->random = copyRandomList(head->random);
        return newNode;
    }
};