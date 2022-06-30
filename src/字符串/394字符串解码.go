package main

import "strconv"

func main() {
	res := decodeString("10[leetcode]")
	println(res)
}

//应该是递归操作，因为[]内部也可能是编码string
func decodeString(s string) string {
	//s如果以数字开头，那就首先计算第一段，然后计算第二段，直到结尾
	//s如果以字母开头，那就寻找数字，找到数字之后分段计算
	var res string
	i := 0
	for i < len(s) {
		if s[i] >= 'a' && s[i] <= 'z' {
			res += string(s[i])
			i++
			continue
		} else if s[i] >= '0' && s[i] <= '9' {
			numStart := i

			//找到数字,继续找，看是不是多位的数字
			for i < len(s) && (s[i] >= '0' && s[i] <= '9') {
				i++
			}
			//此时i指向的是数字后面的 一位  也就是【
			num64, _ := strconv.ParseInt(s[numStart:i], 10, 32)
			num := int(num64)
			println("发现数字：", num)
			start := i + 1 //括号内的起始点
			//寻找右侧括号
			left := 1
			i = i + 1
			for i < len(s) && left > 0 {
				if s[i] == '[' {
					left++
				}
				if s[i] == ']' {
					left--
				}
				i++
			}
			sub := s[start : i-1] //括号内字符串
			println("括号内字符串", sub)
			str := decodeString(sub)
			println("处理后字符串", str)

			for j := 0; j < num; j++ {
				res += str
			}
		}

	}
	return res
}

////计算括号内的内容
//func recruition(s string) string {
//	var res string
//	for i := 0; i < len(s); {
//		if s[0] >= 'a' && s[0] <= 'z' {
//			res += string(s[i])
//			i++
//			continue
//		} else {
//			//找到数字
//			num := int(s[i] - '0')
//			start := i + 2 //括号内的起始点
//			//寻找右侧括号
//			left := 1
//			i = i + 2
//			for i < len(s) && left > 0 {
//				if s[i] == '[' {
//					left++
//				}
//				if s[i] == ']' {
//					left--
//				}
//			}
//			sub := s[start:i] //括号内字符串
//			str := recruition(sub)
//
//			for j := 0; j < num; j++ {
//				res += str
//			}
//		}
//	}
//}
