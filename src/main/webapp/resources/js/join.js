const id = document.getElementById("id");
const pw = document.getElementById("pw");
const pw2 = document.getElementById("pw2");
const name = document.getElementById("name");
const phone = document.getElementById("phone");
const email = document.getElementById("email");

let idCheck = false; // check O : True, check X : False
let pwCheck = false;
let nameCheck = false;
let phoneCheck = false;
let emailCheck = false;

const frm = document.getElementById("frm");
const btn = document.getElementById("btn");



// id가 비어 있으면 메세지 출력
id.onblur = function(){
	let message = "ID는 필수입니다"
	if(id.value == ""){ // js에서 null은 하나의 datatype이다. 비어있는것을 의미하지는 않는다
		idResult.innerHTML = message;
		idCheck = false;
	} else {
		idCheck = true;
	}
};

// 비밀번호 글자 수 판독
pw.addEventListener("keyup", function(){
	let pwtotal = pw.value.length;
	let message = "비밀번호는 8자 이상 12자 이하로 설정해 주세요";
	pwResult.innerHTML = message;
	if(pwtotal > 7 && pwtotal < 13){
		pwResult.innerHTML = "비밀번호가 조건에 충족합니다";		
	}
});

pw.addEventListener("change", function(){
	pwCheck = false;
	pw2.value = "";
	pwResultCheck.innerHTML = "";
	pw2.focus();
});

// 비밀번호 확인 판독
pw2.addEventListener("blur", function(){
	let pass = pw.value;
	let message = "비밀번호가 일치합니다"
	if(pass == pw2.value){
		pwResultCheck.innerHTML = message;
		pwCheck = true;
	} else {
		message = "비밀번호가 일치하지 않습니다"
		pwResultCheck.innerHTML = message;
		pwCheck = false;
	}
})

// 이름
name.addEventListener("blur", function(){
	if(name.value == ""){
		nameCheck = false;
	} else {
		nameCheck = true;
	}
})

// 전화번호
phone.addEventListener("blur", function(){
	if(phone.value == ""){
		phoneCheck = false;
	} else {
		phoneCheck = true;
	}
})

// 이메일
email.addEventListener("blur", function(){
	if(email.value == ""){
		emailCheck = false;
	} else {
		emailCheck = true;
	}
})

// 버튼
btn.addEventListener("click", function(){
	if(idCheck && pwCheck && nameCheck && phoneCheck && emailCheck){
		frm.submit();
	} else {
		alert('필수요건을 확인 하세요');
	}
});