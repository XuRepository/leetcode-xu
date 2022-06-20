package main

import (
	"math/rand"
	"time"
)

//go切片是指针传递！
func findKthLargest(nums []int, k int) int {
	//递归出口
	rand.Seed(time.Now().UnixNano())
	return quickSelect(nums, 0, len(nums)-1, len(nums)-k)
}

func quickSelect(nums []int, left int, right int, k int) int {
	var index int = partition(nums, left, right) //进行快速排序一轮，找到k位置的！
	//快速选择
	if index == k {
		return nums[index]
	} else if index > k {
		return quickSelect(nums, left, index-1, k)
	} else {
		return quickSelect(nums, index+1, right, k)
	}
}

func partition(nums []int, left int, right int) int {
	if left == right {
		return left
	}

	i := rand.Int()%(right-left+1) + left
	nums[i], nums[left] = nums[left], nums[i]

	temp := nums[left]
	for left < right {
		for left < right && nums[right] >= temp {
			right--
		}
		if left < right {
			nums[left] = nums[right]
			left++
		}

		for left < right && nums[left] < temp {
			left++
		}
		if left < right {
			nums[right] = nums[left]
			right--
		}
	}
	//一趟排序结束了，中间left与right相遇的地方填入temp，此时左侧小于temp，右侧大于等于temp
	nums[left] = temp
	return left
}

func fastSort(nums []int) {
	//递归出口
	if len(nums) <= 1 {
		return
	}

	left, right := 0, len(nums)-1
	temp := nums[left]
	for left < right {
		for left < right && nums[right] >= temp {
			right--
		}
		if left < right {
			nums[left] = nums[right]
			left++
		}

		for left < right && nums[left] < temp {
			left++
		}
		if left < right {
			nums[right] = nums[left]
			right--
		}
	}
	//一趟排序结束了，中间left与right相遇的地方填入temp，此时左侧小于temp，右侧大于等于temp
	nums[left] = temp

	fastSort(nums[0:left])
	fastSort(nums[left+1:])
}

func main() {
	nums := []int{1, 2, 4, 3, 0}
	fastSort(nums)
	for _, num := range nums {
		println(num)
	}
}
