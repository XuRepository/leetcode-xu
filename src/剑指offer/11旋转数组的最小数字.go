package 剑指offer

func minArray(numbers []int) int {
	//查找问题，使用二分
	l := 0
	r := len(numbers) - 1
	for l < r {
		mid := (l + r) >> 1
		//首先判断下mid落在的左半侧 还是 右半侧
		//如果mid比右侧大 说明mid落在的左侧
		//如果mid比右侧小 说明mid落在了右侧
		//如果相等，无法判断。
		//此时情况是：
		//1，正确的最小值可以肯定在l-r这一段区间内！
		//2，mid和r值相同
		//因此，无论r的值是不是最小值，都有一个mid在l-r中间可以替代r，所以可以放心的将r-1来缩小搜索范围！
		if numbers[mid] > numbers[r] {
			l = mid + 1
		} else if numbers[mid] < numbers[r] {
			r = mid - 1
		} else {
			r--
		}
	}
	return numbers[l]

}
