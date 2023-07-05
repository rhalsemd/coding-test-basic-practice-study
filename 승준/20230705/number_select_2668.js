const readline = require("readline");

let n;
let numbers = [0];
let result = new Array();

function dfs(graph, visited, start, current) {
  visited[current] = true;
  const next = graph[current];

  if (!visited[next]) {
    dfs(graph, visited, start, next);
  } else if (start == next) {
    result.push(start);
  }
}

readline
  .createInterface(process.stdin, process.stdout)
  .on("line", (line) => {
    if (!n) {
      n = parseInt(line);
    } else {
      numbers.push(parseInt(line));
    }
  })
  .on("close", () => {
    for (let i = 1; i < n + 1; i++) {
      let visited = new Array(n+1).fill(false);
      dfs(numbers, visited, i, i);
    }

    result.sort();
    console.log(result.length);
    result.forEach((element) => {
      console.log(element);
    });
    process.exit();
  });
