$(document).ready(function(){
		$(".mainForm1").show();
		//$(".mainForm2").hide();
});

function ajaxSubmit(frm, success_callbackfunc, error_callbackfunc) {
	var dataPara = getFormJson(frm);
	$.ajax({
		url : frm.action,
		type : frm.method,
		dataType : 'html',
		contentType : "application/json",
		data : JSON.stringify(dataPara),
		success : success_callbackfunc,
		error : error_callbackfunc
	});
}

//将form中的值转换为键值对。
function getFormJson(frm) {
	var o = {};
	var a = $(frm).serializeArray();
	$.each(a, function() {
		if (o[this.name] !== undefined) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});

	return o;
}

$(function(){
	// $(".number1").click(function(){
	// $(".mainForm1").show();
	// $(".mainForm2").hide();
	// });
	// $(".number2").click(function(){
	// $(".mainForm1").hide();
	// $(".mainForm2").show();
	//	});
	
	//�ֻ����ʧȥ����
	$(".login_button").click(function(){
		//$(".mainForm1").hide();
		var form=document.getElementById("loginForm");
		ajaxSubmit(form, function(data) {
			//alert(data);
			window.location.href = '/home';
		}, function(data) {
			alert(data);
		});
		return false;
	});
	
	$(".phone").blur(function(){
		reg=/^1[3|4|5|8][0-9]\d{4,8}$/i;//��֤�ֻ�����(����ǰ7λ��11λ)

		if( $(".phone").val()=="")
		{ 
			$(".phone").parent().addClass("errorC");
			$(".error1").html("�������ֻ��");
			$(".error1").css("display","block");
		}
		else if($(".phone").val().length<11)
        {   
        	$(".phone").parent().addClass("errorC");
            $(".error1").html("�ֻ�ų�������");
            $(".error1").css("display","block");
        }
        else if(!reg.test($(".phone").val()))
        {   
        	$(".phone").parent().addClass("errorC");
            $(".error1").html("�����ذɣ���ȷ����������ֻ��!!");
            $(".error1").css("display","block");
        }
        else
        {
        	$(".phone").parent().addClass("checkedN");
        }
	});
});