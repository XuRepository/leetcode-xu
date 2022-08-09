package 位运算

//On  O1
func findDuplicate1(nums []int) int {
	//把数组视为一个链表，重复的数字视为链表产生了环！那样我们的任务变成了在链表中找到环的入口
	//下标i --> nums[i]  这样的一个图
	//快慢指针
	fast, slow := 0, 0
	for {
		slow = nums[slow]       //走一步
		fast = nums[nums[fast]] //走两步

		if slow == fast {
			break
		}
	}
	slow = 0
	for slow != fast {
		slow = nums[slow]
		fast = nums[fast]
	}
	return slow
}

//数学法：cnt[i]表示小于=i的数字的数量，target是重复值。
//1~target-1,cnt[i]<=i;i属于target~n,cnt[i]>i,因为n-1个数字 target重复啦
//使用二分法搜索每个区间的mid，看cnt[mid]是否>mid
func findDuplicate(nums []int) int {
	n := len(nums)
	l, r := 1, n-1 //数字大小范围在1-(n-1)
	ans := -1
	for l <= r {
		mid := l + (r-l)>>1
		cnt := 0
		for i := 0; i < n; i++ {
			if nums[i] <= mid {
				cnt++
			}
		}

		//如果mid是target，那cnt mid > mid
		if cnt > mid {
			//说明target在mid or mid的左侧！
			r = mid - 1
			ans = mid
		} else {
			//说明target在 mid的右侧！
			l = mid + 1
		}
	}
	return ans

}

//位运算，考虑到第 ii 位，我们记 \textit{nums}nums 数组中二进制展开后第 ii 位为 11 的数有 xx 个，
//数字 [1,n][1,n] 这 nn 个数二进制展开后第 ii 位为 11 的数有 yy 个，
//那么重复的数第 ii 位为 11 当且仅当 x>y  x>y。
func findDuplicate2(nums []int) int {
	bitmax := 31
	ans := 0
	n := len(nums)
	// 确定二进制下最高位是多少
	for (n-1)>>bitmax == 0 {
		bitmax-- //代表 如果n-1的bitmax位==0，则需要统计的bitmax位数可以--，减小空间消耗
	}

	for bit := 0; bit <= bitmax; bit++ {
		x, y := 0, 0
		for i := 0; i < n; i++ {
			if i & (1 << bit) {
				x++
			}
			if nums[i] & (1 << bit) {
				y++
			}
		}
		if x > y {
			ans += 1 << bit
		}
	}
	return ans
}
