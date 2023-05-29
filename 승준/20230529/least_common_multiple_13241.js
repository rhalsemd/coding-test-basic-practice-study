const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

rl.on("line", (line) => {
    const input = line.split(' ');
    const gcd = findGCD(input[0], input[1]);
    const ans = ( input[0] * input[1] ) / gcd;

    console.log(ans);
    rl.close();
}).on('close', ()=>{
    process.exit();
});

function findGCD(a, b) {
    while (b !== 0) {
        let temp = a % b;
        a = b;
        b = temp;
    }
    return a;
}
        