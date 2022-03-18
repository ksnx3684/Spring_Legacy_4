const checkAll = document.getElementById("checkAll");
const check = document.getElementsByClassName("check");
const rules = document.getElementById("rules");
const btn = document.getElementById("btn");


// 전체동의 선택 시 약관 전부 동의
checkAll.addEventListener("click", function(){
    for(joincheck of check){
        joincheck.checked = checkAll.checked;
    }
});


// rules.addEventListener("click", function(event){
//	let final = true;
//	for(joincheck of check){
//		if(!joincheck.checked){
//			final = false;
//		}
//	}
//	checkAll.checked = final;
//});



// 하나라도 약관 동의가 안되어있으면 전체동의 체크 해제
for(ch of check){
    ch.addEventListener("click", function(){
        let final = true;
        for(joincheck of check){
           if(!joincheck.checked){
                final = false;
            }
        }
        checkAll.checked = final;
    })
};

// 약관에 모두 동의해야 join.jsp로 이동
btn.addEventListener("click", function(){
    if(checkAll.checked){
        window.location.href="./join";
    } else {
        alert("약관에 모두 동의 하셔야 합니다");
    }
});