const readline = require("readline");

input = [];
let n;
let graph;
let number = 1;
const dx = [-1, 1, 0, 0];
const dy = [0, 0, -1, 1];
let count;
let queue;

const bfs = (number, sy, sx) => {
  queue = [];
  queue.push([sy, sx]);
  graph[sy][sx] = number;
  count = 1;

  while (queue.length > 0) {
    const [y, x] = queue.shift();

    for (let d = 0; d < 4; d++) {
      const ny = y + dy[d];
      const nx = x + dx[d];
      if (0 <= ny && ny < n && 0 <= nx && nx < n && graph[ny][nx] === 1) {
        queue.push([ny, nx]);
        graph[ny][nx] = number;
        count++;
      }
    }
  }

  return count;
};

readline
  .createInterface(process.stdin, process.stdout)
  .on("line", (line) => {
    input.push(line);
  })
  .on("close", () => {
    n = parseInt(input[0]);
    graph = new Array(n);

    for (let i = 1; i < n + 1; i++) {
      graph[i - 1] = input[i].split("").map(Number);
    }

    const countArr = [];
    let islandCount = 0;

    for (let i = 0; i < n; i++) {
      for (let j = 0; j < n; j++) {
        if (graph[i][j] === 1) {
          number++;
          count = bfs(number, i, j);
          countArr.push(count);
          islandCount++;
        }
      }
    }

    console.log(number - 1);
    countArr.sort((a, b) => a - b);
    for (let i = 0; i < islandCount; i++) {
      console.log(countArr[i]);
    }

    process.exit();
  });
