const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});
rl.on('line', function (line) {
  const n = parseInt(line);

  if (n === 1) {
    console.log('0 0');
    rl.close();
    return;
  }

  const newArray = [];
  rl.on('line', function (row) {
    newArray.push(row.split(''));
    if (newArray.length === n){
      const r_cnt = countLyingPlaces(newArray, n);
      const c_cnt = countLyingPlaces(transpose(newArray), n);
      console.log(`${r_cnt} ${c_cnt}`)
      rl.close();
    }
  });
}).on('close', function () {
  process.exit(0);
});

function countLyingPlaces(arr, n) {
  let cnt = 0;
  for (let i = 0; i < n; i++) {
    let spaceCnt = 0;
    for (let j = 0; j < n; j++) {
      if (arr[i][j] === '.') {
        spaceCnt++;
      } else {
        if (spaceCnt >=2 ) {
          cnt++;
        }
        spaceCnt = 0;
      }
    }
    if (spaceCnt >= 2) {
      cnt++;
    }
  }
  return cnt;
}

function transpose(arr) {
  const n = arr.length;
  const transposed = [];
  for (let i = 0; i < n; i++) {
    transposed.push([]);
    for (let j = 0; j < n; j++) {
      transposed[i][j] = arr[j][i];
    }
  }
  return transposed;
}