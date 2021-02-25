#include"tree.h"
#include <queue>
using namespace std;

 class Solution0116 {
 public:
     Node* connect(Node* root) {
         if (root == nullptr) {
             return root;
         }
        queue<Node*> q;
        if (root != nullptr) {
            q.push(root);
        }
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node* t = q.front();
                q.pop();
                if (i < size - 1) {
                    t->next = q.front();
                }
                if (t->left != nullptr) {
                    q.push(t->left);
                }
                if (t->right != nullptr) {
                    q.push(t->right);
                }
            }
        }
        return root;
     }
};