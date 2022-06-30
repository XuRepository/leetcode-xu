package 动态规划

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

//动态规划,树形DP
func rob(root *TreeNode) int {
	res := dpTree(root)
	return max(res[0], res[1])
}

//树形DP
//返回值:res[0] 该节点偷，能偷的最大值,1为该节点不偷，能偷盗的最大值
func dpTree(root *TreeNode) []int {
	//递归出口
	if root == nil {
		return []int{0, 0}
	}

	left := dpTree(root.Left)
	right := dpTree(root.Right)

	var res []int
	res = append(res, root.Val+left[1]+right[1])                     //偷当前节点，孩子不偷
	res = append(res, max(left[0], left[1])+max(right[0], right[1])) //不偷当前节点，那左右节点各自取最大值

	return res
}

func max(a int, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
