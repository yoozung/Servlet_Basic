// 페이지 로드하자마자 실행되는 js
$(document).ready(function(){
	console.log('start');
});

$(document).on('click', '#test1_submit', function(){
	$('.text-muted').css('display', 'none');
	if(!$('#userID').val()) {
		$('#idHelp').css('display', 'block');
		$('#userID').focus();
		return false;
	}
	if(!$('#userPW').val()) {
		$('#pwHelp').css('display', 'block');
		$('#userPW').focus();
		return false;
	}
	if(!$('#userName').val()) {
		$('#nameHelp').css('display', 'block');
		$('#userName').focus();
		return false;
	}
	var userID = $('#userID').val();
	var userPW = $('#userPW').val();
	var userName = $('#userName').val();
	// id를 이용해서 함수로 이동 (동기식)
	// document.getElementById("test1").submit();
	
	// 비동기식 .ajax
	$.ajax({
		url: "controller?action=sign_up", 
		type: "get", 
		data : {
			'userID': userID, 
			'userPW': userPW, 
			'userName': userName
		}, 
		success: function(data){
			const $userDataset = document.getElementById('userDataset');
			$userDataset.innerHTML = '';
			if (data.list.length == 0){
				$userDataset.innerHTML = '<tr><td colspan=4>Empty</td></tr>'
			}else{
				for(var i=0; i<data.list.length; i++){
					$userDataset.innerHTML += '<tr><td>'+(i+1)+'</td><td>'+data.list[i].userID+'</td><td>'+data.list[i].userName+'</td><td>'+data.list[i].date+'</td></tr>';
				}
			}
		}, 
		error: function(){
			alert('에러다');
		}
	});
});

$(document).on('click', '#test1_reset', function(){
	if(confirm('Reset?')){
		document.getElementById('test1').reset();
	}else{
		return false;
	}
});