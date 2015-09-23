var api = frameElement ? frameElement.api : frameElement;

$(function(){
	$("input[readonly='readonly'],textarea[readonly='readonly']").live('keydown',function(event){
		if(event.keyCode==8){
			return false;
		}
	});
});

/**
 * 
 * @param id
 * @param title
 * @param url
 * @param w
 * @param h
 */
function toAdd(title, url, tagId, w, h) {
	openWin(title, url, w, h);
}

/**
 * 
 * @param id
 * @param title
 * @param url
 * @param w
 * @param h
 */
function toUpdate(title, url, tagId, w, h) {
	var obj = $("#" + tagId).datagrid("getSelected");
	if (obj && obj.id) {
		if (url.indexOf("?") == -1) {
			url += "?id=" + obj.id;
		} else {
			url += "&id=" + obj.id;
		}
		openWin(title, url, w, h);
	} else {
		tip("请选择要操作的数据！");
	}
}
/**
 * 
 * @param tagId
 * @param title
 * @param url
 * @param w
 * @param h
 */
function delOne(tagId, title, url, w, h) {
	var obj = $("#" + tagId).datagrid("getSelected");
	if (obj && obj.id) {
		$.messager.confirm('系统提示', '您确定删除选中的数据吗？', function(r) {
			if (r) {
				$.ajax({
					type : "POST",
					url : url,
					data : {
						'id' : obj.id
					},
					beforeSend : function(XMLHttpRequest) {
						$.messager.progress({
							title : '操作提示',
							msg : '正在处理中...',
							interval : 2000
						});
					},
					success : function(data) {
						if (!data.success) {
							$.messager.progress('close');
							error(data.msg);
						} else {
							$.messager.progress('close');
							refreshGrid();
							tip(data.msg);

						}
					},
					error : function(req) {
						$.messager.progress('close');
						error(req.status + ":" + req.statusText);
					}
				});
			}
		});
	} else {
		tip("请选择要操作的数据！");
	}
}

function openWin(title, url, w, h) {
	var listWin = window;
	w = w ? w : 800;
	h = h ? h : 500;
	if (w == "100%" || h == "100%") {
		w = window.top.document.body.offsetWidth;
		h = window.top.document.body.offsetHeight - 100;
	}
	if (api) {
		$.dialog({
			title : title,
			opacity : 0.5,
			width : w,
			height : h,
			content : 'url:' + url,
			lock : true,
			cache : false,
			parent : api,
			ok : function() {
				var frame = this.iframe.contentWindow;
				var form = $("form", frame.document);
				if (form && form.length > 0) {
					frame.ajaxSubmit(form, top, listWin);
				}
				return false;
			},
			cancel : true
		});
	} else {
		$.dialog({
			title : title,
			opacity : 0.5,
			width : w,
			height : h,
			content : 'url:' + url,
			lock : true,
			cache : false,
			ok : function() {
				var frame = this.iframe.contentWindow;
				var form = $("form", frame.document);
				if (form && form.length > 0) {
					frame.ajaxSubmit(form, top, listWin);
				}
				return false;
			},
			cancel : true
		});
	}
}

function toTip(msg) {
	$.messager.show({
		title : '系统提示',
		msg : msg,
		showType : 'slide'
	});
}

function error(msg) {
	$.messager.alert('错误提示', msg, 'error');
}

/**
 * 表单提交
 * 
 * @param form
 * @returns
 */
function ajaxSubmit(form, win, listWin) {
	$(form).validationEngine();
	var rel = $(form).validationEngine('validate');
	$.ajax({
		type : "POST",
		url : $(form).attr("action"),
		data : $(form).serialize(),
		dataType : "json",
		beforeSend : function(XMLHttpRequest) {
			var lock=$(form).attr("lock");
			if(lock=="lock"){
				return false;
			}else{
				if (!rel) {
					$(form).shake();
					return false;
				} else {
					$(form).attr("lock","lock");
					$.messager.progress({
						title : '系统提示',
						msg : '数据提交中...'
					});
				}
			}
		},
		success : function(data) {
			$(form).attr("lock","");
			$.messager.progress('close');
			if (!data.success) {
				window.error(data.msg);
			} else {
				listWin.refreshGrid();
				frameElement.api.close();
				win.toTip(data.msg);
			}
		},
		error : function(req) {
			$(form).attr("lock","");
			$.messager.progress('close');
			window.error("操作异常！" + req.status);
		}
	});
}

/**
 * 抖动效果
 */
jQuery.fn.shake = function() {
	var style = $(this)[0].style, p = [ 3, 6, 3, 0, -3, -6, -3, 0 ], fx = function() {
		style.marginLeft = p.shift() + 'px';
		if (p.length <= 0) {
			style.marginLeft = 0;
			clearInterval(timerId);
		}
	};
	p = p.concat(p.concat(p));
	timerId = setInterval(fx, 20);
};

function delFile(url,obj){
	$.dialog.setting.zIndex =1990;
	$.dialog.confirm("确认删除该条记录?", function(){
	  	$.ajax({
			async : false,
			cache : false,
			type : 'POST',
			url : url,// 请求的action路径
			error : function() {// 请求失败处理函数
			},
			success : function(data) {
				var d = $.parseJSON(data);
				if (d.success) {
					var msg = d.msg;
					tip(msg);
					$(obj).closest("tr").hide("slow");
				}
			}
		});  
	}, function(){
	});
}

Array.prototype.remove = function(dx) {
	if (isNaN(dx) || dx > this.length) {
		return false;
	}
	for ( var i = 0, n = 0; i < this.length; i++) {
		if (this[i] != this[dx]) {
			this[n++] = this[i];
		}
	}
	this.length -= 1;
}; 
