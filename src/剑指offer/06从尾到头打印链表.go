package 剑指offer

type ListNode struct {
	Val  int
	Next *ListNode
}

//倒序打印  recursion/迭代 都行
func reversePrint1(head *ListNode) []int {
	res := make([]int, 0)
	recursion(head, res)
	return res
}

func recursion(head *ListNode, res []int) {
	if head == nil {
		return
	}
	recursion(head.Next, res)
	res = append(res, head.Val)
	return
}

func reversePrint(head *ListNode) []int {
	res := make([]int, 0)
	for head != nil {
		res = append(res, head.Val)
		head = head.Next
	}
	for i := 0; i < len(res)/2; i++ {
		temp := res[i]
		res[i] = res[len(res)-1-i]
		res[len(res)-1-i] = temp
	}
	return res
}
