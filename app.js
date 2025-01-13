// function printNum(event) {
//     event.preventDefault();
//     console.log("buttonClicked");
//     let inputElement = document.getElementById("textInput");
//     let value = inputElement.value;
//     console.log(value.split("-"));
// }

// const coffee = {
//     myType : "latte",
//     myPrice : 3000,
//     set type(type) {
//         if (type !== null) {
//             this.myType = type
//         }
//     },
//     get type() {
//         return this.myType;
//     },
//     get price() {
//         return this.myPrice;
//     },
//     set price(price) {
//         if (price > 3000) {
//             this.myPrice = price
//         }
//     }
// }
// console.log(coffee.type);
// coffee.type = null;
// console.log(coffee.type);
// console.log(coffee.price);
// coffee.price = 2900
// console.log(coffee.price);

// Object.defineProperty(coffee, 'brand', {
//     value: 'mega',
//     writable: false,
//     enumerable: false,
//     configurable: false
// }) 

// coffee.brand = 'Starbucks'
// console.log(coffee.brand)

// const arr = []
// arr[0] = '1'
// arr[2] = '2'
// console.log(arr);
// console.log(arr.length);

// arr.forEach(element => {
//     console.log(element);
// });

// arr.push(2)
// console.log(arr);
// console.log(arr.pop());
// console.log(arr);

// const myArray = ["사과", "바나나", "수박"]
// myArray.shift()
// console.log(myArray);
// myArray.unshift("오이", "배")
// console.log(myArray);

// const nums = [23, 5, 1000, 42]
// console.log(nums.sort((a, b) => a - b));
// const arr2 = [1, 2, 3]
// const newArr2 = arr2.map(function(item, index) {
//     return item * index
// })
// console.log(newArr2);
let evenSum = 0
for (let i = 0; i < 101; i++) {
    if(i % 2 == 0) {
        evenSum += i
    }
}
console.log(evenSum);

for (let i = 1; i < 10; i++) {
    for (let j = 1; j < 10; j++) {
        console.log(`${i} * ${j} = ${i * j}`);
    }
    console.log("\n");
}

const username = undefined
let result5 = username || '유저 이름이 없습니다.'
console.log(result5);