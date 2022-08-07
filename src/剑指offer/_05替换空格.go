package 剑指offer

func replaceSpace(s string) string {
	count := 0
	for _, char := range s {
		if char == ' ' {
			count++

		}
	}
	chars := make([]byte, len(s)+2*count)
	i := len(s) + 2*count
	for j := len(s) - 1; j >= 0; j-- {
		if s[i] == ' ' {
			chars[i] = '0'
			chars[i-1] = '2'
			chars[i-2] = '%'
			i = i - 3
		} else {
			chars[i] = s[j]
			i--
		}
	}
	return string(chars)
}
