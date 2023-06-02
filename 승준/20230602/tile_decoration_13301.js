const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.on('line', (input) => {
  const n = parseInt(input);
  const dp = new Array(n + 1);

  dp[0] = BigInt(4);
  dp[1] = BigInt(6);

  for (let i = 2; i < n + 1; i++) {
    dp[i] = dp[i-1] + dp[i-2];
  }

  console.log(dp[n-1].toString());

  rl.close();
}).on("close", () => {
  process.exit();
});