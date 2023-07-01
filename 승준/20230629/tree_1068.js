function dfs(num, parent) {
  parent[num] = -2;
  for (let i = 0; i < parent.length; i++) {
    if (parent[i] === num) {
      dfs(i, parent);
    }
  }
}

function contains(parent, num) {
  for (let n of parent) {
    if (n === num) {
      return true;
    }
  }
  return false;
}

function main() {
  const readline = require("readline");
  const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
  });

  rl.question("Enter the number: ", (num) => {
    const parent = new Array(num);
    rl.question("Enter the parent array: ", (parentInput) => {
      const parentTokens = parentInput.trim().split(" ");
      for (let i = 0; i < parent.length; i++) {
        parent[i] = parseInt(parentTokens[i]);
      }
      rl.question("Enter the delete node: ", (deleteInput) => {
        const deleteNode = parseInt(deleteInput);

        dfs(deleteNode, parent);
        let count = 0;
        for (let i = 0; i < parent.length; i++) {
          if (parent[i] !== -2 && !contains(parent, i)) {
            count++;
          }
        }
        console.log(count);
        rl.close();
      });
    });
  });
}

main();
