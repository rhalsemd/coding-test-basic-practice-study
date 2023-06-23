const readline = require("readline");
let v, w;
const graph = [];
const input = [];

readline
  .createInterface(process.stdin, process.stdout)
  .on("line", (line) => {
    input.push(line);
  })
  .on("close", () => {
    v = parseInt(input[0]);
    w = parseInt(input[1]);

    const visited = new Array(v + 1).fill(false);

    for (let j = 0; j < v + 1; j++) {
      graph.push(new Array());
    }

    for (let i = 2; i < input.length; i++) {
      const [a, b] = input[i].split(" ").map(Number);
      graph[a].push(b);
      graph[b].push(a);
    }

    const queue = [];
    queue.push(1);
    visited[1] = true;
    let count = 0;

    while (queue.length > 0) {
      const node = queue.shift();

      for (const next of graph[node]) {
        if (!visited[next]) {
          count++;
          queue.push(next);
          visited[next] = true;
        }
      }
    }

    console.log(count);
    process.exit();
  });
