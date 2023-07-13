const fs = require("fs");
const stdin = process.platform === "linux" ? fs.readFileSync("/dev/stdin").toString().trim() : fs.readFileSync("input.txt").toString().trim();
const input = stdin.split("\n");
let idx = 0;

let N, K;
let S, X, Y;
let blocks = [];
const queue = [];
const visited = [];

class Block {
  constructor(value, y, x, sec) {
    this.value = value;
    this.y = y;
    this.x = x;
    this.sec = sec;
  }
}

while (!N) {
  const line = input[idx++].split(" ").map(Number);
  N = parseInt(line[0]);
  K = parseInt(line[1]);
}

for (let i = 0; i < N; i++) {
  const line = input[idx++].split(" ").map(Number);
  blocks.push(line);
  visited.push(new Array(N).fill(false));
}

const line = input[idx++].split(" ").map(Number);
S = parseInt(line[0]);
X = parseInt(line[1]);
Y = parseInt(line[2]);

for (let i = 0; i < N; i++) {
  for (let j = 0; j < N; j++) {
    if (blocks[i][j] !== 0) {
      queue.push(new Block(blocks[i][j], i, j, 0));
      visited[i][j] = true;
    }
  }
}

queue.sort();
let result = bfs(blocks, visited, queue, N, S, X, Y);
console.log(parseInt(result));

function bfs(blocks, visited, queue, N, S, X, Y) {
  const dy = [-1, 1, 0, 0];
  const dx = [0, 0, -1, 1];

  while (queue.length > 0) {
    const { value, y, x, sec } = queue.shift();
    if (S === sec) {
      break;
    }

    for (let d = 0; d < 4; d++) {
      const ny = dy[d] + y;
      const nx = dx[d] + x;
      if (
        ny >= 0 &&
        ny < N &&
        nx >= 0 &&
        nx < N &&
        !visited[ny][nx] &&
        blocks[ny][nx] === 0
      ) {
        blocks[ny][nx] = value;
        visited[ny][nx] = true;
        queue.push(new Block(value, ny, nx, sec + 1));
      }
    }
  }

  return blocks[X - 1][Y - 1];
}
