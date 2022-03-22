const reply = document.querySelector("#reply");
const num = document.querySelector("#num");
const writer = document.querySelector("#writer");
const contents = document.querySelector("#contents");
const replyResult = document.querySelector("#replyResult");
const del = document.querySelectorAll(".del");

//---------------------
// ***** DELETE *****

replyResult.addEventListener("click", function(event){
    if(event.target.classList.contains('del')){
        let replyNum = event.target.getAttribute("data-num");
        
        // url "/noticeReply/delete" method : post parameter : replyNum
        const xhttp = new XMLHttpRequest();

        xhttp.open("POST", "../noticeReply/delete");

        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        xhttp.send("replyNum=" + replyNum);

        xhttp.onreadystatechange=function(){
            if(this.readyState == 4 && this.status == 200){
                if(this.responseText.trim() == '1'){
                    alert('삭제성공');
                    getList();
                } else {
                    alert('삭제실패');
                }
            }
        }
    }
});

//---------------------

getList();

function getList(){
    const xhttp2 = new XMLHttpRequest();

    xhttp2.open("GET", "../noticeReply/list?num=" + num.value);

    xhttp2.send();

    xhttp2.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){
            console.log(this.responseText);
            replyResult.innerHTML = this.responseText.trim();
        }
    }
}


reply.addEventListener("click", function(){
    console.log(num.value);
    console.log(writer.value);
    console.log(contents.value);

    // 1. JS에서 요청 객체 생성(준비)
    const xhttp = new XMLHttpRequest();

    // 2. 요청 정보 입력
    // open('메서드형식', 'URL주소')
    xhttp.open("POST", "../noticeReply/add");

    // 3. 요청 header 정보
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    // 4. 요청 전송
    // post 요청시 파라미터
    // send("이름=값&이름2=값2...")
    xhttp.send("num=" + num.value + "&writer=" + writer.value + "&contents=" + contents.value);

    // 5. 응답 처리
    xhttp.onreadystatechange = function(){
        // readyState는 4way Handshake 단계를 의미
        // status는 http 상태번호를 의미, 200은 정상상태, 404, 500...은 에러
        if(this.readyState == 4 && this.status == 200){
            console.log(this.responseText);
            let result = this.responseText.trim();
            if(result == '1'){
                alert("댓글이 등록되었습니다");
                getList();
            } else {
                alert("댓글 등록에 실패했습니다");
            }
        }
    }
});