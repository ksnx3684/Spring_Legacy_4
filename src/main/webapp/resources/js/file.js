const fileAdd = document.getElementById("fileAdd");
const fileresult = document.getElementById("fileresult");
const del = document.getElementsByClassName("del");

let count = 0;
let num = 0; // id용도

fileAdd.addEventListener("click", function(){

    
    if(count > 4) {
        alert('첨부파일은 최대 5개까지 가능합니다');
        return;
    }

    count++;

    let div = document.createElement('div'); // <div></div>
    div.setAttribute("id", "del" + num);

    let file = document.createElement("input"); // <input>
    file.setAttribute("type", "file"); // <input type="file">
    file.setAttribute("name", "files"); // <input type=""file name="files">

    let button = document.createElement('button'); // <button></button>
    button.setAttribute("type", "button");
    button.className = "del";
    button.setAttribute("data-num", "del" + num);
    button.innerHTML = "DEL";

    div.append(file);
    div.append(button);

    fileresult.append(div);
    
    num++;
});

fileresult.addEventListener("click", function(event){
    let cn = event.target;

    if(cn.classList.contains('del')) {
        let delNum = cn.getAttribute("data-num");
        document.getElementById(delNum).remove();
        count--;
    }
});