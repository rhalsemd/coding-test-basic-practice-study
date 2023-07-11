const readline = require("readline");

let n;
const lines = [];

readline
  .createInterface(process.stdin, process.stdout)
  .on("line", (line) => {
    if (!n) {
      n = parseInt(line);
    } else {
      const [x, y] = line.split(" ").map(Number);
      lines.push([x, y]);
    }
  })
  .on("close", () => {
    lines.sort((a, b) => a[0] - b[0]);

    let total = 0;
    let start = lines[0][0];
    let end = lines[0][1];

    for (let i = 1; i < n; i++) {
      if (lines[i][0] > end) {
        total += end - start;
        start = lines[i][0];
        end = lines[i][1];
      } else {
        end = Math.max(end, lines[i][1]);
      }
    }
    total += end - start;
    console.log(total);
    process.exit();
  });
