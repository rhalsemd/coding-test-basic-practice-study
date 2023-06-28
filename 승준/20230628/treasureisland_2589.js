const readline = require("readline");

function bfs(sy, sx, arr, row, col) {
  const dy = [-1, 1, 0, 0];
  const dx = [0, 0, -1, 1];

  const queue = [];
  queue.push([sy, sx]);

  const distance = Array.from({ length: row }, () => Array(col).fill(-1));
  const visited = Array.from({ length: row }, () => Array(col).fill(false));

  visited[sy][sx] = true;
  distance[sy][sx] = 0;
  let max_distance = 0;

  while (queue.length > 0) {
    const [y, x] = queue.shift();

    for (let d = 0; d < 4; d++) {
      const ny = y + dy[d];
      const nx = x + dx[d];

      if (
        0 <= ny &&
        ny < row &&
        0 <= nx &&
        nx < col &&
        !visited[ny][nx] &&
        arr[ny][nx] === 1
      ) {
        visited[ny][nx] = true;
        queue.push([ny, nx]);
        distance[ny][nx] = distance[y][x] + 1;
        if (distance[ny][nx] > max_distance) {
          max_distance = distance[ny][nx];
        }
      }
    }
  }

  return max_distance;
}

function solve() {
  const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
  });

  let row, col;
  let arr = [];

  rl.on("line", (line) => {
    if (!row) {
      [row, col] = line.trim().split(" ").map(Number);
    } else {
      arr.push(
        line
          .trim()
          .split("")
          .map((ch) => (ch === "L" ? 1 : 0))
      );
    }
  }).on("close", () => {
    let max_dist = 0;

    for (let i = 0; i < row; i++) {
      for (let j = 0; j < col; j++) {
        if (arr[i][j] === 1) {
          const dist = bfs(i, j, arr, row, col);
          if (max_dist < dist) {
            max_dist = dist;
          }
        }
      }
    }

    console.log(max_dist);
  });
}

solve();
