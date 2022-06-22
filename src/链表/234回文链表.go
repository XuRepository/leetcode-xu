package 链表

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
type ListNode struct {
	Val  int
	Next *ListNode
}

//On  O1：翻转后半个链表，然后双指针判断！
func isPalindrome(head *ListNode) bool {
	if head == nil {
		return true
	}

	//1找前半部分的最后一个节点，快慢指针
	firstEnd := findMid(head)
	//2,翻转后半部分链表
	secondStart := reverse(firstEnd)

	var p1, p2 = head, secondStart
	for p1 != firstEnd.Next {
		if p1.Val == p2.Val {
			p1 = p1.Next
			p2 = p2.Next
		} else {
			return false
		}
	}
	return true
}

func findMid(head *ListNode) *ListNode {
	slow := head
	fast := head
	for fast.Next != nil && fast.Next.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}
	return slow
}

func reverse(head *ListNode) *ListNode {
	pre := head
	cur := head.Next
	for cur != nil {
		temp := cur.Next
		cur.Next = pre
		pre = cur
		cur = temp
	}
	return pre
}

//暴力
func isPalindrome1(head *ListNode) bool {
	var temp []int
	cur := head
	for cur != nil {
		temp = append(temp, cur.Val)
		cur = cur.Next
	}

	left, right := 0, len(temp)-1
	for left < right {
		if temp[left] == temp[right] {
			left++
			right--
		} else {
			return false
		}
	}
	return true
}
