const readline = require("readline");

let n;

function generateCombinations(combinations, current, start, n, r) {
  if (r == 0) {
    combinations.push([...current]);
    return;
  }

  for (let i = start; i < n; i++) {
    current.push(i);
    generateCombinations(combinations, current, i + 1, n, r - 1);
    current.pop();
  }
}

readline
  .createInterface(process.stdin, process.stdout)
  .on("line", (line) => {
    n = parseInt(line);
  })
  .on("close", () => {
    let nums = [];

    for (let i = 1; i < 11; i++) {
      let combinations = [];
      generateCombinations(combinations, [], 0, 10, i);

      for (let combination of combinations) {
        const reverseCombination = combination.sort((a, b) => b - a);
        const num = parseInt(reverseCombination.join(""));
        nums.push(num);
      }
    }

    nums.sort((a, b) => a - b);

    if (n >= 0 && n < nums.length) {
      console.log(nums[n]);
    } else {
      console.log(-1);
    }
  });
