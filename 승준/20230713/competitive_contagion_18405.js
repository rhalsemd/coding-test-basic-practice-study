const fs = require("fs");
const stdin = process.platform === "linux" ? fs.readFileSync("/dev/stdin").toString().trim() : fs.readFileSync("input.txt").toString().trim();

const input = stdin.split("\n");
let idx = 0;

const [N, K] = input[idx++].split(" ").map(Number);
const blocks = [];
for (let i = 0; i < N; i++) {
  blocks.push(input[idx++].split(" ").map(Number));
}

const [S, X, Y] = input[idx++].split(" ").map(Number);
const visited = Array.from(Array(N), () => Array(N).fill(false));

const queue = [];
for (let i = 0; i < N; i++) {
  for (let j = 0; j < N; j++) {
    if (blocks[i][j] !== 0) {
      queue.push([blocks[i][j], i, j, 0]);
      visited[i][j] = true;
    }
  }
}

queue.sort((a, b) => a[0] - b[0]);

const result = bfs(blocks, visited, queue, S, N, X, Y);
console.log(result);

function bfs(blocks, visited, queue, S, N, X, Y) {
  const dy = [-1, 1, 0, 0];
  const dx = [0, 0, -1, 1];

  while (queue.length > 0) {
    const [value, y, x, sec] = queue.shift();

    if (sec === S) {
      break;
    }

    for (let d = 0; d < 4; d++) {
      const ny = dy[d] + y;
      const nx = dx[d] + x;
      if (ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx] && blocks[ny][nx] === 0) {
        blocks[ny][nx] = value;
        visited[ny][nx] = true;
        queue.push([value, ny, nx, sec + 1]);
      }
    }
  }

  return blocks[X - 1][Y - 1];
}
