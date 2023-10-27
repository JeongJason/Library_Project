//팝업 띄우기
function openPop() {
    document.getElementById("popup_layer").style.display = "block";
// AJAX 요청을 보냅니다.
//    $.ajax({
//        type: "GET",
//        url: "/getUserInfo",
//        data: { userId: userId },
//        success: function (data) {
//            if(data.status === 200 && data.body.length > 0){
//                            var user = data.body[0];
//                            document.getElementById("popup_layer").style.display = "block";
//                            document.getElementById("userIdField").value = userId.userId;
//                            document.getElementById("userNameField").value = userId.userName;
//                            document.getElementById("userEmailField").value = userId.userEmail;
//                            document.getElementById("userBirthField").value = userId.userBirth;
//                            document.getElementById("userRoleField").value = userId.userRole;
//                            document.getElementById("userRegisterDateField").value = userId.userRegisterDate;
//                            // 필요한 필드를 추가로 작성해주세요
//                        } else {
//                            alert("사용자 정보를 가져오는데 실패했습니다.");
//                        }
//
//        }
//    });

}

//팝업 닫기
function closePop() {
    document.getElementById("popup_layer").style.display = "none";
}