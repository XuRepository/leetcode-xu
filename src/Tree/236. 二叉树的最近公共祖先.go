package Tree

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

//dfs倒序回溯，使用返回值承接搜索到的值，如果没搜索到，返回值必定为nil
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	//递归出口
	if root == nil {
		return nil
	}
	//如果root为p或者q，可以直接返回不需要继续搜索下面的节点，因为最好情况下公共父节点也就是当前root
	if root.Val == p.Val || root.Val == q.Val {
		return root
	}

	left := lowestCommonAncestor(root.Left, p, q)
	right := lowestCommonAncestor(root.Right, p, q)

	//如果返回的是非nil节点，那一定是p or q or 父节点
	//否则，返回的一定是nil，因为从叶子结点开始，如果非pq，left right 返回的一定是nil，所以叶子结点返回的也是nil
	if left != nil && right != nil {
		//非叶子节点
		return root
	}

	if left != nil {
		return left
	}
	if right != nil {
		return right
	}
	return nil

}

//使用dfs bool判断是否寻找到
var ans *TreeNode

func lowestCommonAncestor1(root, p, q *TreeNode) *TreeNode {
	dfs(root, p, q)
	return ans
}

func dfs(root *TreeNode, p *TreeNode, q *TreeNode) bool {
	if root == nil {
		return false
	}

	left := dfs(root.Left, p, q)
	right := dfs(root.Right, p, q)

	//左右节点都找到 || 左右节点找到一个，当前节点也匹配上一个
	if (left && right) || ((left || right) && (root.Val == p.Val || root.Val == q.Val)) {
		ans = root
	}

	return left || right || root.Val == p.Val || root.Val == q.Val //子节点找到or当前节点是否匹配

}

