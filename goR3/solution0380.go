package main

import "math/rand"

type RandomizedSet struct {
	//map用来存数组下标
    m map[int]int
	list []int
}


func Constructor() RandomizedSet {
	m := make(map[int]int)
	list := make([]int, 0)
    return RandomizedSet{m: m, list: list}
}


func (this *RandomizedSet) Insert(val int) bool {
	_, ok := this.m[val]
	//如果已存在，返回false
	if ok {
		return false
	}
    this.list = append(this.list, val)
	this.m[val] = len(this.list) - 1
	return true
}

//将最后一个值移到val对应的位置，并删除最后一个值
func (this *RandomizedSet) Remove(val int) bool {
    _, ok := this.m[val]
	if !ok {
		return false
	}
	index := this.m[val]
	lastIndex := len(this.list) - 1
	lastValue := this.list[lastIndex]
	//修改list的值
	this.list[index] = lastValue
	this.list = this.list[0:lastIndex]
	//修改map的值
	this.m[lastValue] = index
	delete(this.m, val)

	return true
}


func (this *RandomizedSet) GetRandom() int {
    random := rand.Intn(len(this.list))

	return this.list[random]
}


/**
 * Your RandomizedSet object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Insert(val);
 * param_2 := obj.Remove(val);
 * param_3 := obj.GetRandom();
 */