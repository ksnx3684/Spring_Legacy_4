const title = document.getElementById("title");
const writer = document.getElementById("writer");

const btn = document.getElementById("btn");

let titleCheck;
let writerCheck;

title.addEventListener("", function(){

});

writer.addEventListener("", function(){

});


btn.addEventListener("click", function(){
    if(title.value == '' && writer == ''){
        alert("필수 항목을 입력하십시오");
    }
})