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

// fileresult.addEventListener("click", function(event){
//     let cn = event.target;

//     if(cn.classList.contains('del')) {
//         let delNum = cn.getAttribute("data-num");
//         document.getElementById(delNum).remove();
//         count--;
//     }
// });

const fileDeleteBtn = document.querySelectorAll(".fileDeleteBtn");
const files = document.querySelector("#files");

// 버튼을 클릭했을 때 각각의 fileNum 콘솔에 출력
files.addEventListener("click", function(event){
    if(event.target.classList.contains('fileDeleteBtn')){
        
        // ajax로 파라미터는 fileNum, method는 post, url은 fileDelete, controller의 메서드 명 : fileDelete
        let check = window.confirm("삭제하시겠습니까?");

        if(!check){
            return;
        }

        let fileNum = event.target.getAttribute("data-fileNum");

        let xhttp = new XMLHttpRequest();

        xhttp.open("POST", "./fileDelete");

        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        xhttp.send("fileNum=" + fileNum);

        xhttp.onreadystatechange=function(){
            if(this.readyState == 4 && this.status == 200){
                let result = this.responseText.trim();
                if(result = '1'){
                    console.log("file 삭제");
                    event.target.parentNode.remove();
                } else {
                    
                }
            }
        }
        
    }
});
