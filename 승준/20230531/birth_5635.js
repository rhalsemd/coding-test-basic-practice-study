const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let n = 0;
const userInfoLst = [];

rl.on('line', (line) => {
    if (n === 0) {
      n = parseInt(line);
    } else {
      const tokens = line.split(' ');
      userInfoLst.push(tokens);
  
      if (userInfoLst.length === n) {
        processInput(userInfoLst);
        rl.close();
      }
    }
  }
);

function processInput(userInfoLst) {
    const mx_age = [0, 0, 0];
    const mn_age = [1000, 1000, 1000];
    let oldest = "";
    let youngest = "";

    for (let i = 0; i < userInfoLst.length; i++) {
        const birthYear = parseInt(userInfoLst[i][3]);
        const birthMonth = parseInt(userInfoLst[i][2]);
        const birthDay = parseInt(userInfoLst[i][1]);

        const currentDate = new Date();
        const birthDate = new Date(birthYear, birthMonth - 1, birthDay);

        const age = calculateAge(birthDate, currentDate);

        if (isGreater(age, mx_age)) {
            mx_age[0] = age[0];
            mx_age[1] = age[1];
            mx_age[2] = age[2];
            oldest = userInfoLst[i][0];
        }

        if (isSmaller(age, mn_age)) {
            mn_age[0] = age[0];
            mn_age[1] = age[1];
            mn_age[2] = age[2];
            youngest = userInfoLst[i][0];
        }
    }

    console.log(youngest);
    console.log(oldest);
}

function calculateAge(birthDate, currentDate) {
    const yearsDiff = currentDate.getFullYear() - birthDate.getFullYear();
    const monthsDiff = currentDate.getMonth() - birthDate.getMonth();
    const daysDiff = currentDate.getDate() - birthDate.getDate();

    let years = yearsDiff;
    let months = monthsDiff;
    let days = daysDiff;

    if (monthsDiff < 0 || (monthsDiff === 0 && daysDiff < 0)) {
        years--;
        months += 12;
    }

    if (daysDiff < 0) {
        months--;
        const prevMonthDte = new Date(currentDate.getFullYear(), currentDate.getMonth() -1, 0);
        days += prevMonthDte.getDate();
    }

    return [years, months, days];
}

function isGreater(age1, age2) {
  if (age1[0] > age2[0]) {
    return true;
  } else if (age1[0] === age2[0] && age1[1] > age2[1]) {
    return true;
  } else return age1[0] === age2[0] && age1[1] === age2[1] && age1[2] > age2[2];
}

function isSmaller(age1, age2) {
  if (age1[0] < age2[0]) {
    return true;
  } else if (age1[0] === age2[0] && age1[1] < age2[1]) {
    return true;
  } else return age1[0] === age2[0] && age1[1] === age2[1] && age1[2] < age2[2];
}