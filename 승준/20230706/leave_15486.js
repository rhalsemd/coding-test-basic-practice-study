const readline = require('readline');

let n;
let t;
let p;
let dp;
let inputT = [];
let inputP = [];

readline
    .createInterface(process.stdin, process.stdout)
    .on('line', (line) => {
        if (!n) {
            n = parseInt(line);
            t = Array(n + 2).fill(0);
            p = Array(n + 2).fill(0);
            dp = Array(n + 2).fill(0);
        } else {
            const [a, b] = line.split(" ").map(Number);
            inputT.push(a);
            inputP.push(b);
        }
    })
    .on('close', () => {
        inputT.push(0);
        inputP.push(0);

        for (let i = 0; i < n + 2; i++) {
            t[i] = inputT[i];
            p[i] = inputP[i];
        }

        for (let i = 1; i < n + 1; i++) {
            if (i + t[i] <= n + 1) {
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }

        console.log(Math.max(...dp));
        process.exit();
    });
