function calcMean(array) {
    return array.reduce((p,c) => p + c)/array.length
}

function calcSt(array, mean){
    let sum = array.map(item=>(item-mean)**2).reduce((p,c)=>p+c)
    let sd = (sum/array.length)**(0.5)
    return sd
}

function parseArray(lines,n) {
    let arr = []
    for(var i = 0; i < n;i++) {
        arr.push(parseFloat(lines[i]))
    }
    return arr
}

function pearsonFunc(x,meanX, stX, y, meanY, stY) {
    let n = x.length
    let sum = 0
    for(var i = 0; i < n; i++) {
        sum += (x[i] - meanX) * (y[i] - meanY)
    }
    return sum/(n * stX * stY)
    
}

function processData(input) {
    //Enter your code here
    let x = [95,85,80,70,60]
    let y = [85,95,70,65,70]
    let meanX = calcMean(x)
    let meanY = calcMean(y)
    let stX = calcSt(x,meanX)
    let stY = calcSt(y,meanY)

    let pearson = pearsonFunc(x,meanX, stX, y, meanY, stY)
    let b = pearson*stY/stX
    let a = meanY - b*meanX


    let ans = a + b*80
    console.log(ans.toFixed(3))
} 

process.stdin.resume();
process.stdin.setEncoding("ascii");
_input = "";
process.stdin.on("data", function (input) {
    _input += input;
});

process.stdin.on("end", function () {
   processData(_input);
});