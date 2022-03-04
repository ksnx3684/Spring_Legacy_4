const id = document.getElementById("id");
const pw = document.getElementById("pw");
const pw2 = document.getElementById("pw2");
const name = document.getElementById("name");
const email = document.getElementById("email");
const phone = document.getElementById("phone");

let idCheck = false;
let pwCheck = false;
let nameCheck = false;
let emailCheck = false;
let phoneCheck = false;

const frm = document.getElementById("frm");
const btn = document.getElementById("btn");

// 아이디
id.addEventListener("blur", function(){
    let message = "필수입력사항입니다"
    if(id.value == ""){
        idResult.innerHTML = message;
        idCheck = false;
    } else {
        idCheck = true;
    }
});

// 비번
pw.addEventListener("keyup", function(){
    let message = "비번은 8~12자 입니다"
    if(pw.value.length > 7 && pw.value.length < 13){
        pwResult.innerHTML = "조건충족";
        pwCheck = true;
    } else {
        pwResult.innerHTML = message;
        pwCheck = false;
    }
});

pw.addEventListener("change", function(){
	pwCheck = false;
	pw2.value = "";
	pwResultCheck.innerHTML = "";
	pw2.focus();
});

pw2.addEventListener("blur", function(){
    let message = "비번불일치"
    if(pw.value != pw2.value){
        pwResultCheck.innerHTML = message;
        pwCheck = false;
    } else {
        pwResultCheck.innerHTML = "비번일치";
        pwCheck = true;
    }
});

// 이름
name.addEventListener("blur", function(){
    if(name.value == ""){
        nameCheck = false;
    } else {
        nameCheck = true;
    }
});

//이메일
email.addEventListener("blur", function(){
    if(email.value == ""){
        emailCheck = false;
    } else {
        emailCheck = true;
    }
});

// 전화
phone.addEventListener("blur", function(){
    if(phone.value == ""){
        phoneCheck = false;
    } else {
        phoneCheck = true;
    }
});


// 가입버튼
btn.addEventListener("click", function(){
    if(id.value == ""){
        alert("id 입력요망");
        id.focus();
        return;
    }
    if(pw.value == ""){
        alert("pw 입력요망");
        pw.focus();
        return;
    }
    if(pwCheck == false){
        alert("pw 일치확인요망");
        pw2.focus();
        return;
    }
    if(name.value == ""){
        alert("name 입력요망");
        name.focus();
        return;
    }
    if(email.value == ""){
        alert("email 입력요망");
        email.focus();
        return;
    }
    if(phone.value == ""){
        alert("phone 입력요망");
        phone.focus();
        return;
    }
    frm.submit();
})