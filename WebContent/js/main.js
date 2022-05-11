/**
 * 입력값 검증함수
 */
function employeeCheck(){
	if(document.frm.id.value.length==0){
		alert("아이디를 입력해주세요");
		document.frm.id.focus();
		return false;
	}
	//비밀번호 입력검증
	if(document.frm.pass.value.length==0){
		alert("비밀번호를 입력해주세요");
		document.frm.pass.focus();
		return false;
	}
	//이름입력검증
	if(document.frm.name.value.length==0){
		alert("이름을 입력해주세요");
		document.frm.pass.focus();
		return false;
	}
	//다 null아님=>return ture
	return true;
}