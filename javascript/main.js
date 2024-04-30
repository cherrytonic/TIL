// 메뉴 표시
const menu = document.querySelector('.menu');
const main = document.querySelector('main');
const dropName1 = document.getElementById('drop1')
const drop1 = document.querySelector('.dropdown-menu')
dropName1.addEventListener('click', (e) => {
    console.log('클릭됨');
    drop1.style.display = "block";
})


// menuItems.forEach(item => {
//     const menuItem = document.createElement('div');
//     menuItem.classList.add('menu-item');
//     menuItem.innerHTML = `
//         <h2>${item.name}</h2>
//         <button class="order-btn">주문하기</button>
//     `;
//     main.appendChild(menuItem);

//     menuItem.querySelector('.order-btn').addEventListener('click', () => {
//         const confirmed = confirm(`${item.name}를 주문하시겠습니까?`);
//         if (confirmed) {
//             addToOrderHistory(item);
//         }
//     });
// });

// // 주문 내역을 세션 스토리지에 추가
// function addToOrderHistory(item) {
//     let orderHistory = JSON.parse(sessionStorage.getItem('orderHistory')) || [];
//     orderHistory.push(item);
//     sessionStorage.setItem('orderHistory', JSON.stringify(orderHistory));
// }

// // 주문 내역을 세션 스토리지에서 불러오기
// function getOrderHistory() {
//     return JSON.parse(sessionStorage.getItem('orderHistory')) || [];
// }

// // 페이지 로드 시 주문 내역 표시
// window.addEventListener('DOMContentLoaded', () => {
//     const orderHistory = getOrderHistory();
//     if (orderHistory.length > 0) {
//         alert('주문 내역: ' + orderHistory.map(item => item.name).join(', '));
//     }
// });

// // 주문하기 버튼 클릭 시 주문 내역 삭제
// document.querySelector('.clear-orders').addEventListener('click', () => {
//     sessionStorage.removeItem('orderHistory');
//     alert('주문 내역이 삭제되었습니다.');
// });


