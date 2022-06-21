package main

//手写heap操作，数组保存
//go切片是指针传递！
func findKthLargest1(nums []int, k int) int {
	createHeap(nums, len(nums))
	heapSize := len(nums)
	//弹出k个元素
	for i := 0; i < k-1; i++ {
		swap(nums, 0, len(nums)-1-i) //堆顶元素弹出到最后
		heapSize--
		heapify(nums, 0, heapSize)
	}

	return nums[0]
}

func createHeap(nums []int, heapSize int) {
	//当前的heap的保存方式是数组，保存的是一个数组形式的满2茶树
	//所以从heapSize/2， 也就是最后一个非叶子结点
	for i := heapSize / 2; i >= 0; i-- {
		heapify(nums, i, heapSize)
	}
}

// root : 当前非叶子节点的数组下标
func heapify(nums []int, root int, heapSize int) {
	l := 2*root + 1        //左子树
	r := 2*root + 2        //右子树
	var largest int = root //记录当前root和它左右子树的最大值

	if l < heapSize && nums[l] > nums[largest] {
		largest = l
	}
	if r < heapSize && nums[r] > nums[largest] {
		largest = r
	}

	if largest != root {
		//对当前的root和它的子树进行过调整！
		swap(nums, largest, root)
		//调整后的largest位置的值为背调整下来的root位置的值，对这个节点进行再一次的调整
		heapify(nums, largest, heapSize)
	}

}

func swap(nums []int, largest int, root int) {
	temp := nums[largest]
	nums[largest] = nums[root]
	nums[root] = temp
}

func main() {
	nums := []int{1, 2, 4, 3, 0}
	fastSort(nums)
	for _, num := range nums {
		println(num)
	}
}
