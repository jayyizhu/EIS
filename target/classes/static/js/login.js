/**
 * 
 */
function ajaxSubmit(frm, success_callbackfunc, error_callbackfunc) {
		var dataPara = getFormJson(frm);
		$.ajax({
			url: frm.action,
			type: frm.method,
			dataType: 'html',
			contentType: "application/json",
			data: JSON.stringify(dataPara),
			success: success_callbackfunc,
			error: error_callbackfunc
		});
	}

	//将form中的值转换为键值对。
	function getFormJson(frm) {
		var o = {};
		var a = $(frm).serializeArray();
		$.each(a, function () {
			if (o[this.name] !== undefined) {
				if (!o[this.name].push) {
					o[this.name] = [o[this.name]];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});

		return o;
	}
	//调用
    $(document).ready(function(){
		$('#loginForm').bind('submit', function(){
			ajaxSubmit(this, 
					function(data){
						//alert(data);
						window.location.href = "/home";
					},
					function(data){
						alert(data);
					});
			return false;
		});
    });	