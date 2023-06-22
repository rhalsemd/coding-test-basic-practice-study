const readline = require("readline");
let n, m;
const maze = [];
let dist;
const input = [];

readline
  .createInterface(process.stdin, process.stdout)
  .on("line", (line) => {
    input.push(line);
  })
  .on("close", () => {
    const [nmLine, ...mazeLines] = input;
    [n, m] = nmLine.split(" ").map(Number);
    dist = new Array(n).fill(null).map(() => new Array(m).fill(-1));
    for (let i = 0; i < n; i++) {
      maze.push(mazeLines[i].split("").map(Number));
    }
    const result = solveMaze(n, m, maze, dist);
    console.log(result);
    process.exit();
  });

const dx = [-1, 1, 0, 0];
const dy = [0, 0, -1, 1];

function solveMaze(n, m, maze, dist) {
  const queue = [];
  queue.push([0, 0]);
  dist[0][0] = 1;

  while (queue.length > 0) {
    const [y, x] = queue.shift();

    for (let i = 0; i < 4; i++) {
      const ny = dy[i] + y;
      const nx = dx[i] + x;

      if (
        ny >= 0 &&
        ny < n &&
        nx >= 0 &&
        nx < m &&
        dist[ny][nx] === -1 &&
        maze[ny][nx] === 1
      ) {
        queue.push([ny, nx]);
        dist[ny][nx] = dist[y][x] + 1;
      }
    }
  }

  return dist[n - 1][m - 1];
}
