const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.on('line', function(line) {
    const boardLine = line;
    const boardArray = boardLine.split("");
    const boards = [];
    let cnt = 0;
    let flag = false;

    for (let i = 0; i < boardArray.length; i++) {
        const board = boardArray[i];
        if (board === "X") {
            cnt++;
        } else {
            if (cnt == 2) {
                boards.push("BB.");
            } else {
                if (cnt >= 1) {
                    flag = true;
                    break;
                } else {
                    boards.push(".");
                }
            }
            cnt = 0;
        }

        if (cnt === 4) {
            cnt = 0;
            boards.push("AAAA");
        } else if (cnt === 2 && i === boardArray.length - 1) {
            cnt = 0;
            boards.push("BB");
        }
    }

    if ( cnt === 1 || cnt === 3) {
        flag = true;
    }

    if ( flag === false) {
        const joinedString = boards.join("");
        console.log(joinedString);
        rl.close();
    } else {
        console.log(-1);
        rl.close();
    }
}).on('close', function() {
    process.exit(0);
});  