package 动态规划

func productExceptSelf(nums []int) []int {

	length := len(nums)

	L := make([]int, length)

	L[0] = 1
	for i := 1; i < length; i++ {
		L[i] = nums[i-1] * L[i-1]
	}

	R := 1
	for i := length - 1; i >= 0; i-- {
		L[i] = R * L[i]
		R = R * nums[i]
	}

	return L
}

// On  On
func productExceptSelf1(nums []int) []int {

	length := len(nums)

	L := make([]int, length)
	R := make([]int, length)

	L[0] = 1
	R[length-1] = 1

	for i := 1; i < length; i++ {
		L[i] = nums[i-1] * L[i-1]
	}
	for i := length - 2; i >= 0; i-- {
		R[i] = nums[i+1] * R[i+1]
	}

	for i := 0; i < length; i++ {
		R[i] = R[i] * L[i]
	}

	return R
}
