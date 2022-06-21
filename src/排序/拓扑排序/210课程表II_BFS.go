package main

//拓扑排序，BFS,
//1，计算每个节点的入度，入度为0的首先加入队列。队列出队，代表学习完成，然后队列相关的边的节点的全部入度-1，如果入度为0，入队列。
//最终判断是否所有元素都出队即可
func findOrder(numCourses int, prerequisites [][]int) []int {
	var edge [][]int
	var inDegree []int
	var res []int

	//边
	edge = make([][]int, numCourses)   //第一个坐标是：当前下标课程；第二个下标：当前下标课程是哪些课程的前置课程，是的话置为1
	inDegree = make([]int, numCourses) //节点的入度，为0表示可以学，为k表示还有k门前置课程呢

	//构造edge！
	for _, e := range prerequisites {
		edge[e[1]] = append(edge[e[1]], e[0])
		inDegree[e[0]]++
	}

	queue := []int{} //队列

	for i, indeg := range inDegree {
		if indeg == 0 {
			queue = append(queue, i)
		}
	}

	for len(queue) > 0 {
		curNode := queue[0]
		res = append(res, curNode)
		queue = queue[1:] //模拟队列入队出队
		for _, cour := range edge[curNode] {
			inDegree[cour]--
			if inDegree[cour] == 0 {
				queue = append(queue, cour)
			}
		}
	}

	if len(res) == numCourses {
		return res
	} else {
		return []int{}
	}

}

func main() {
	course := make([][]int, 0, 4)
	course = append(course, []int{1, 0})
	course = append(course, []int{2, 0})
	course = append(course, []int{3, 1})
	course = append(course, []int{3, 2})
	findOrder(4, course)

}
