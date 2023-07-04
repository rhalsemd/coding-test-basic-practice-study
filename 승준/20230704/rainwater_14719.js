const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

function calculateRainwater(h, w, blocks) {
  let total = 0;
  for (let i = 1; i < w - 1; i++) {
    const leftMax = Math.max(...blocks.slice(0, i));
    const rightMax = Math.max(...blocks.slice(i + 1));

    if (blocks[i] < leftMax && blocks[i] < rightMax) {
      total += Math.min(leftMax, rightMax) - blocks[i];
    }
  }
  return total;
}

rl.on("line", (line) => {
  const input = line.split(" ");
  const h = parseInt(input[0]);
  const w = parseInt(input[1]);

  rl.on("line", (line) => {
    const blocks = line.split(" ").map(Number);
    const result = calculateRainwater(h, w, blocks);
    console.log(result);
    rl.close();
  });
});
