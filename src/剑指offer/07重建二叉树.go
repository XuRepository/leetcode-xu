package 剑指offer

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func buildTree(preorder []int, inorder []int) *TreeNode {
	//1，递归出口
	if len(inorder) == 0 {
		return nil
	}

	//2，根据前序的first定位到中序的root，分割
	root := preorder[0]
	var i int
	for i = 0; i < len(inorder); i++ {
		if inorder[i] == root {
			break
		}
	}
	node := &TreeNode{
		Val:   preorder[0],
		Left:  nil,
		Right: nil,
	}
	//1,切割left right
	var leftIn []int
	var leftPre []int
	if i > 0 { //还存在左子树
		leftIn = inorder[0:i]
		leftPre = preorder[1 : len(leftIn)+1]
	}

	var rightIn []int
	var rightPre []int
	if i < len(inorder)-1 { //如果还存在右子树
		rightIn = inorder[i+1:]
		rightPre = preorder[1+len(leftIn):]
	}

	node.Left = buildTree(leftPre, leftIn)
	node.Right = buildTree(rightPre, rightIn)

	return node
}

func main() {

}
