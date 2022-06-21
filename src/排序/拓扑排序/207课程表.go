package main

func canFinish(numCourses int, prerequisites [][]int) bool {
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
		return true
	} else {
		return false
	}
}
