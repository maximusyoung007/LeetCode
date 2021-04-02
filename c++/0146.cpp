#include<map>
using namespace std;

struct DoubleLinkedNode {
    int key, value;
    DoubleLinkedNode* pre;
    DoubleLinkedNode* next;
    DoubleLinkedNode(){}
    DoubleLinkedNode(int key, int value): key(key), value(value), pre(nullptr), next(nullptr){}
};

class LRUCache {
private:
    map<int, DoubleLinkedNode*> myMap;
    DoubleLinkedNode* head;
    DoubleLinkedNode* tail;
    int size;
    int capacity;
public:
    LRUCache(int capacity): capacity(capacity), size(0) {
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head->next = tail;
        tail->pre = head;
    }

    int get(int key) {
        if (myMap.count(key) == 0) {
            return -1;
        }
        int value = myMap[key]->value;
        put(key, value);
        return value;
    }

    void put(int key, int value) {
        if (myMap.count(key) == 0) {
            //如果节点不存在，新建节点并存进hash表中，若内存超出，则删除最后一个链表最后一个节点并将map中的节点也删除
            DoubleLinkedNode* node = new DoubleLinkedNode(key, value);
            addToHead(node);
            myMap[key] = node;
            size++;
            if (size > capacity) {
                DoubleLinkedNode* node = removeLast();
                myMap.erase(node->key);
                delete node;
                --size;
            }
        } else {
            DoubleLinkedNode *node = myMap[key];
            node->value = value;
            //存在，删除原节点，将新节点放在表头
            deleteNode(node);
            addToHead(node);
        }
    }

    void deleteNode(DoubleLinkedNode* node) {
        node->pre->next = node->next;
        node->next->pre = node->pre;
    }

    void addToHead(DoubleLinkedNode* node) {
        if (head->next != nullptr) {
            head->next->pre = node;
            node->pre = head;
            node->next = head->next;
        }
        head->next = node;
    }

    DoubleLinkedNode* removeLast() {
        DoubleLinkedNode* node = tail->pre;
        node->pre->next = tail;
        node->next->pre = node->pre;
        return node;
    }
};