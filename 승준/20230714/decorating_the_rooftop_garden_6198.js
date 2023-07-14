const fs = require("fs");

const input=fs.readFileSync('/dev/stdin').toString().trim().split('\n').map((line) => line.trim()).map(Number);
// const input = fs
//   .readFileSync("input.txt")
//   .toString()
//   .trim()
//   .split("\n")
//   .map((line) => line.trim())
//   .map(Number);

const [n, ...buildings] = input;

let count = 0
let stack = []
for (b of buildings) {
    while (stack.length > 0 && stack[stack.length-1] <= b ) {
        stack.pop()
    }
    stack.push(b)
    count += stack.length - 1
}

console.log(count)
