function solve(n) {
  const dp = Array.from(Array(n + 1), () => Array(n + 1).fill(-1));
  const queue = [];
  queue.push([1, 0]);
  dp[1][0] = 0;

  while (queue.length > 0) {
    const [now, clip] = queue.shift();

    if (now === n) {
      return dp[now][clip];
    }

    if (dp[now][now] === -1) {
      dp[now][now] = dp[now][clip] + 1;
      queue.push([now, now]);
    }

    if (now + clip <= n && dp[now + clip][clip] === -1) {
      dp[now + clip][clip] = dp[now][clip] + 1;
      queue.push([now + clip, clip]);
    }

    if (now - 1 >= 0 && dp[now - 1][clip] === -1) {
      dp[now - 1][clip] = dp[now][clip] + 1;
      queue.push([now - 1, clip]);
    }
  }
}

// 백준에서 입력을 받는 코드
require("readline")
  .createInterface(process.stdin, process.stdout)
  .on("line", (line) => {
    console.log(solve(parseInt(line)));
  })
  .on("close", () => {
    process.exit();
  });
