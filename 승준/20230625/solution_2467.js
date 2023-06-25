const readline = require("readline");

const input = [];
let n = null;

readline
  .createInterface(process.stdin, process.stdout)
  .on("line", (line) => {
    if (!n) {
      n = parseInt(line);
    } else {
      input.push(...line.split(" ").map(Number));
    }
  })
  .on("close", () => {
    const solution = input;
    solution.sort((a, b) => a - b);

    let left = 0;
    let right = n - 1;
    let diff = Math.abs(solution[left] + solution[right]);
    let diff_match = [solution[left], solution[right]];

    while (left < right) {
      let sum_val = solution[left] + solution[right];
      if (Math.abs(sum_val) < diff) {
        diff = Math.abs(sum_val);
        diff_match = [solution[left], solution[right]];
      }

      if (sum_val < 0) {
        left++;
      } else if (sum_val > 0) {
        right--;
      } else {
        break;
      }
    }

    console.log(diff_match.join(" "));
    process.exit();
  });
