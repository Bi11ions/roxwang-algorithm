package test

import (
	"fmt"
	"runtime"
	"testing"
)

func TestHttp(t *testing.T) {
	intArr := []int{1, 2, 3}

	for _, s := range intArr {
		fmt.Printf("value:%d \n", s)
	}
}

func TestSwitch(t *testing.T) {
	fmt.Print("Go runs on")
	switch os := runtime.GOOS; os {
	case "darwin":
		fmt.Println("OS X")
	case "linux":
		fmt.Println("Linux")
	default:
		fmt.Printf("%s. \n", os)

	}
}

func add(i, j int) int {
	return i + j
}
