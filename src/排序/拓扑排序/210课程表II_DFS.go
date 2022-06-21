package main

//拓扑排序，如果找到一条环，说明有环产生，不存在top排序。如果没有，dfs，并且在回溯的时候加入stack，最终stack就是可用的顺序
func findOrder1(numCourses int, prerequisites [][]int) []int {

	var edge [][]int
	var stack []int //结果栈
	var visited []int
	var circle bool
	var dfs func(i int)

	//边
	edge = make([][]int, numCourses)  //第一个坐标是：当前下标课程；第二个下标：当前下标课程是哪些课程的前置课程，是的话置为1
	visited = make([]int, numCourses) //三种状态：0-未访问，1-正在访问，2-已访问

	dfs = func(i int) {
		visited[i] = 1
		for _, course := range edge[i] {
			if visited[course] == 0 {
				dfs(course)
				if circle {
					return
				}
			} else if visited[course] == 1 {
				circle = true //形成环
				return
			}
		}
		visited[i] = 2
		stack = append(stack, i)
	}

	//构造edge！
	for _, e := range prerequisites {
		edge[e[1]] = append(edge[e[1]], e[0])
	}

	//dfs
	for i := 0; i < numCourses && !circle; i++ {
		if visited[i] == 0 { //未访问
			dfs(i)
		}
	}
	if circle {
		return []int{}
	}

	for i := 0; i < len(stack)/2; i++ {
		stack[i], stack[len(stack)-i-1] = stack[len(stack)-i-1], stack[i]
	}
	return stack
}

func main() {
	course := make([][]int, 0, 4)
	course = append(course, []int{1, 0})
	course = append(course, []int{2, 0})
	course = append(course, []int{3, 1})
	course = append(course, []int{3, 2})
	findOrder(4, course)

}
