// ------- 전역변수 ------ //
let sell_no = 0; // 매장번호 / 기본값 0 : 전체보기
// 1. 게시물 출력 [ 1. 페이지 열렸을때 , 2.카테고리버튼 클릭했을때 ]
boardlist()
function boardlist(){
    $.ajax({
        url : "/product",
        type : "get",
        data : { "sell_no" : sell_no },   // sell_no : 매장번호
        success : function(list) {
            let html = '<tr>  <th> 번호 </th> <th> 제목 </th> <th> 작성자 </th></tr>';

            console.log("요청");
            console.log("응답 잘 들어오니?");
            console.log(list);

            list.forEach( (b) => {
                console.log("list 배열의 요소들 잘들어오니??");
                console.log(b);
                html +=
                '<tr>  <td> '+b.sell_no+' </td> <td onclick="getview('+b.sell_no+')">'+b.btitle+' </td> <td> '+b.memail+' </td></tr>';
            })
            document.querySelector(".btable").innerHTML = html;
        }
    })
}


// 2. 게시물 조회 페이지 [ 페이지 전환 -> 클릭한 게시물번호 기록( 1.java(세션-서버가 종료될때 초기화) , 2.템플릿 , 3.js(페이지 전환시 초기화 / 세션,쿠키 )  ]
function getview( sell_no ){
    // 1. 클릭한 게시물번호 저장
    sessionStorage.setItem("sell_no", sell_no );
    // 2. 페이지 전환
    location.href="/board/view";
}
//매장 등록
function setstore(){
        let data={storename:document.querySelector('.storename').value}
        console.log(data);
       $.ajax({
           url:"/setstore",
           type:"post",
           data:JSON.stringify(data),
           contentType:"application/json",
           success:function(re){
           alert(re)
           console.log(re)
           }
       })
}

// 매장
storelist()
function storelist(){
$.ajax({
           url:"/storelist",
           type:"get",
           success:function(re){
                alert(re)
                console.log(re)
                let html  = '';
                for(let i=0; i<re.length; i++){
                    html += '<option value="'+re[i].storeno+'" onclick="StoreNum('+re[i].storeno+')">'+re[i].storename+'</option>'
                }
                document.querySelector('.storelist').innerHTML = html;


           }


})
}

function StoreNum(storeno){
    console.log(storeno);
}
// 매장 리스트
storelistname()
function storelistname(){
$.ajax({
           url:"/storelist",
           type:"get",
           success:function(re){
                alert(re)
                console.log(re)
                let html  = '';
                for(let i=0; i<re.length; i++){
                    html += '<tr><th>'+re[i].storeno+'</th><th>'+re[i].storename+'</th></tr>'
                }
                document.querySelector('.storelistname').innerHTML = html;


           }
})
}
