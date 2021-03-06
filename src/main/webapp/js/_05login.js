/*
		Designed by: SELECTO
		Original image: https://dribbble.com/shots/5311359-Diprella-Login
*/


let switchCtn = document.querySelector("#switch-cnt");
let switchC1 = document.querySelector("#switch-c1");
let switchC2 = document.querySelector("#switch-c2");
let switchCircle = document.querySelectorAll(".switch__circle");
let switchBtn = document.querySelectorAll(".switch-btn");
let aContainer = document.querySelector("#a-container");
let bContainer = document.querySelector("#b-container");
let allButtons = document.querySelectorAll(".submit");

let cookieObj = {};
const cookieAry = document.cookie.split(';');
for (var i = 0, l = cookieAry.length; i < l; ++i) {
	const list = cookieAry[i].trim().split('=');
	cookieObj[list[0]] = list[1];
}
$("#rmAccount").val(cookieObj.user);
$("#rmPassword").val(cookieObj.password);
$('input[name="rememberMe"]').prop("checked", cookieObj.rm == "true");

let getButtons = (e) => e.preventDefault()
let changeForm = (e) => {

	switchCtn.classList.add("is-gx");
	setTimeout(function() {
		switchCtn.classList.remove("is-gx");
	}, 1500)

	switchCtn.classList.toggle("is-txr");
	switchCircle[0].classList.toggle("is-txr");
	switchCircle[1].classList.toggle("is-txr");

	switchC1.classList.toggle("is-hidden");
	switchC2.classList.toggle("is-hidden");
	aContainer.classList.toggle("is-txl");
	bContainer.classList.toggle("is-txl");
	bContainer.classList.toggle("is-z200");
}

let mainF = (e) => {
	for (var i = 0; i < allButtons.length; i++)
		allButtons[i].addEventListener("click", getButtons);
	for (var i = 0; i < switchBtn.length; i++)
		switchBtn[i].addEventListener("click", changeForm)
}

window.addEventListener("load", mainF);



//生日初始化
var ops = {
	todayHighlight: true, //设置当天日期高亮 
	language: 'zh-CN', //语言
	autoclose: false, //选择后自动关闭
	clearBtn: true, //清除按钮
	format: "yyyy-mm-dd", //日期格式 
};
$("#birthday").datepicker(ops);

