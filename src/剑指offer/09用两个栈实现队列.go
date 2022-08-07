package 剑指offer

type CQueue struct {
	stackIn, stackOut []int
}

func Constructor() CQueue {
	queue := CQueue{
		stackIn:  make([]int, 0),
		stackOut: make([]int, 0),
	}
	return queue
}

func (this *CQueue) AppendTail(value int) {
	this.stackIn = append(this.stackIn, value)
}

func (this *CQueue) DeleteHead() int {
	if len(this.stackOut) == 0 {
		if len(this.stackIn) == 0 {
			return -1
		} else {
			l := len(this.stackIn)
			for i := l - 1; i >= 0; i-- {
				this.stackOut = append(this.stackOut, this.stackIn[i])
			}
			this.stackIn = make([]int, 0)
		}
	}
	len := len(this.stackOut)
	var res int
	if len > 0 {
		//go切片不提供删除元素的选项，可以使用切片截取来实现
		res = this.stackOut[len-1]
		this.stackOut = this.stackOut[0 : len-1]
	} else {
		res = -1
	}
	return res
}

/**
 * Your CQueue object will be instantiated and called as such:
 * obj := Constructor();
 * obj.AppendTail(value);
 * param_2 := obj.DeleteHead();
 */
