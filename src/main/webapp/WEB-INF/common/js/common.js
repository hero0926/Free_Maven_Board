/**
 * 공통함수
 */
var Common = {
    popup: function (name, url, left, top, width, height, toolbar, menubar, statusbar, scrollbar, resizable) {
        toolbar_str   = toolbar   ? "yes" : "no";
        menubar_str   = menubar   ? "yes" : "no";
        statusbar_str = statusbar ? "yes" : "no";
        scrollbar_str = scrollbar ? "yes" : "no";
        resizable_str = resizable ? "yes" : "no";
        
        window.open(url, name, "left="+left+",top="+top+",width="+width+",height="+height+",toolbar="+toolbar_str+",menubar="+menubar_str+",status="+statusbar_str+",scrollbars="+scrollbar_str+",resizable="+resizable_str);
    },
    modal : function(name, url, left, top, width, height, center, help, scroll, resizable, status){
    	center_str    = center    ? "yes" : "no";
        help_str      = help      ? "yes" : "no";
        scroll_str    = scroll    ? "yes" : "no";
        resizable_str = resizable ? "yes" : "no";
        status_str    = status    ? "yes" : "no";
        
        var option = "dialogLeft:"+ left +"px;dialogTop:"+ top +"px;dialogWeight:"+ width +"px;dialogHeight:"+ height +"px;center:"+ center_str +";help:"+ help_str +";scroll:"+ scroll_str +";resizable:"+ resizable_str +";status:"+ status_str;
        returnValue = window.showModalDialog(url, name, option);
    },
    redirect: function(url){
    	location.href = url;
    },
    toggle: function(id){
    	$('#' + id).toggle();
    },
    getFileExt: function(file){
    	var extension = file.replace( /%/,"%25").substr(file.replace( /%/,"%25").lastIndexOf(".")+1).toLowerCase();
        
    	return extension;
    },
    comma: function(str){
    	var num = new String(str).replace(/,/g, "");
   	    while(num != (num = num.replace(/^(-?\d+)(\d{3})/, "$1,$2")));
    	
   	    return num;
    },
    
    
 /*  우편번호 API 수정으로 주석 처리  2017.03.13 */  
/*    zipcode: function(zip01, zip02, addr01, addr02){
        var url = "/postal/index.do?zip01="+zip01+"&zip02="+zip02+"&addr01="+addr01+"&addr02="+addr02;
    	
    	
        Common.popup("postal", url, 100, 100, 550, 460, 0, 0, 0, 0, 0);
    },
    
    *
    *
    *
    */
    
    
    // 배열 내 중복값 제거
    unique: function(array) {
        var storage = {};
        var uniqueArray = [];
        var i,value;
        for ( i=0; i<array.length; i++) {
            value = array[i];
            if (!(value in storage)) {
                storage[value] = true;
                uniqueArray.push(value);
            }
        }
        return uniqueArray;
    },
    // 하이픈(-) 제거
    delHyphen: function(oj) {
        var ojvalue = oj.value;
        oj.value    = ojvalue.split('-').join('');
        if(isNaN(oj.value)) {
            alert('숫자만입력해 주십시요.');
            oj.value = "";
            return false;
        }
    },
    // 음수일경우0반환
    chkMinus: function(n) {
        if (n < 0){
        	n = 0;
        }
        return n;
    },
    // 문자바이트수계산
    getByte: function(element) {
        var ls_str = element.val();
        var li_str_len = ls_str.length;
        var i = 0;
        var li_byte = 0;
        var ls_one_char = "";
        for (i = 0; i < li_str_len; i++) {
            ls_one_char = ls_str.charAt(i);
            if (escape(ls_one_char).length > 4){
            	li_byte += 2;
            }
            else{
            	li_byte++;
            }
        }
        return li_byte; 
    },
    getByteString: function(ls_str) {
        var li_str_len = ls_str.length;
        var i = 0;
        var li_byte = 0;
        var ls_one_char = "";
        for (i = 0; i < li_str_len; i++) {
            ls_one_char = ls_str.charAt(i);
            if (escape(ls_one_char).length > 4){
            	li_byte += 2;
            }
            else{
            	li_byte++;
            }
        }
        return li_byte; 
    },
    // 바이트단위로 문자열 자르기
    cutStr: function(str, limit){
        var tmpStr = str;
        var byteCount = 0;
        var len = str.length;

        for(var i = 0; i < len; i++){
            if (escape(str.charAt(i)).length > 4){
            	byteCount += 2;
            }
            else{
            	byteCount++;
            }
            if(byteCount == limit-1){
                if(chr_byte(str.charAt(i+1)) == 2){
                    tmpStr = str.substring(0,i+1);
                }
                else {
                    tmpStr = str.substring(0,i+2);
                }
                break;
            }
            else if(byteCount == limit){
                tmpStr = str.substring(0,i+1);
                break;
            }
        }
        return (tmpStr);
    }
};

/**
 * alert함수
 */
var Alert = {
    focus: function(id, msg){
    	$('#alert').html(msg).dialog({
            title: '알림',
            modal: true,
            height:'200',
            position:'center',
            close: function(){
                $(this).dialog('destroy');
                $('#' + id).focus();
            },
	        buttons:{
	            '닫기':function(){
	                $(this).dialog('destroy');
	                $('#' + id).focus();
	            }
	        }
    	});
    },
    message: function(msg){
    	$('#alert').html(msg).dialog({
            title: '알림',
            modal: true,
            height:'200',
            position:'center',
            close: function(){
                $(this).dialog('destroy');
            },
	        buttons:{ 
	            '닫기':function(){
	                $(this).dialog('destroy');
	            }
	        }
    	});
     },
     clipBoard: function(msg){
     	$('#alert').html(msg).dialog({
             title: '알림',
             modal: true,            
             height:'260',
             position:'center',
             close: function(){
                 $(this).dialog('destroy');
             },
 	        buttons:{
 	            '닫기':function(){
 	                $(this).dialog('destroy');
 	            }
 	        }
     	});
      },
     comfirm: function(msg){
    	 $('#alert').html(msg).dialog({
             title: '알림',
             modal: true,
             height:'200',
             position:'center',
             close: function(){
                 $(this).dialog('destroy');

                 // 창이 닫힐때 처리할 내용을 여기에 구현한다.
             },
             buttons:{
                 '확인':function(){
                     $(this).dialog('destroy');

                     // 확인 버튼 클릭시 처리할 내용을 여기에 구현한다.
                 },
                 '취소':function(){
                     $(this).dialog('destroy');

                     // 취소 버튼 클릭시 처리할 내용을 여기에 구현한다.
                }
            }
        });    	 
    },
    show: function(msg){
        $('#dialog').html(msg).dialog({
            title: '알림',
            modal: true,
            resizable: false,
            draggable: true,
            height:'200',      
            position:'center',
            show: 'blind',
            close: function () {
                $('#dialog').dialog('destroy').empty();
                clearTimeout(timeout);
            }
        });
        timeout = setTimeout(function () {
            $('#dialog').dialog('close').empty();
        }, 2500);
    },
    open: function(msg){
    	$('#dialog').html(msg).dialog({
            title: '알림',
            modal: true,
            height:'200',
            position:'center',
            close: function(){
                $(this).dialog('destroy');
            }
    	});
    },
    close: function(){
    	$('#dialog').dialog('close');
    }
};

/**
 * 날짜함수
 */
var Hiduke = {
	/**
	 * 년월을 지정하여 해당월의 말일을 구한다.
	 * @param year
	 * @param month
	 * @returns
	 */
	getMonthEndDay: function (year, month) {
	    var dt = new Date(year, month, 0);
	    return dt.getDate();
	},
    /**
     * 지정한 년월일의 n개월후, n개월전 날짜를 구한다.
     * @param year
     * @param month
     * @param day
     * @param addMonths
     * @returns {Date}
     */
	computeMonth: function (year, month, day, addMonths) {
	    month += addMonths;
	    var endDay = Hiduke.getMonthEndDay(year, month);
	    if(day > endDay){
	    	day = endDay;
	    }
	    var dt = new Date(year, month - 1, day);
	    var yy = dt.getFullYear();
	    var mm = dt.getMonth() + 1;
	    var dd = dt.getDate();

	    if(mm < 10){
	    	mm = '0' + mm;
	    }
	    if(dd < 10){
	    	dd = '0' + dd;
	    }
	    
	    var str = yy + "/" + mm + "/" + dd; 
	    
	    return str;
	},
	/**
	 *  지정한 년월일의 nd일후, n일전 날짜를 구한다.
	 * @param year
	 * @param month
	 * @param day
	 * @param addDays
	 * @returns {String}
	 */
	computeDate: function (year, month, day, addDays) {
	    var dt = new Date(year, month - 1, day);
	    var baseSec = dt.getTime();
	    var addSec = addDays * 86400000; //일수 * 1일 밀리초수
	    var targetSec = baseSec + addSec;
	    dt.setTime(targetSec);
	    
	    var yy = dt.getFullYear();
	    var mm = dt.getMonth() + 1;
	    var dd = dt.getDate();

	    if(mm < 10){
	    	mm = '0' + mm;
	    }
	    if(dd < 10){
	    	dd = '0' + dd;
	    }
	    
	    var str = yy + "/" + mm + "/" + dd; 

	    return str;
	},
	/**
	 * 날짜를 년월일 문자열로 반환
	 * @param strDate YYYY/MM/DD 또는 YYYY-MM-DD형식의 날짜 문자열
	 * @returns {String}
	 */
	convDateString: function(strDate){
		return strDate.substring(0, 4) + "년 " + strDate.substring(5, 7) + "월 " + strDate.substring(8, 10) + "일";
	},
	convDateHypen: function(strDate){
		return strDate.substring(0, 4) + "-" + strDate.substring(5, 7) + "-" + strDate.substring(8, 10);
	}
};

/**
 * 메인메뉴설정 및 디자인 미리보기 팝업
 */
var popupMain = function(){
	Common.popup('MainMenuSet','/index.act?mode=EDIT&sync=OK', 50, 50, 1020, 900, 0, 0, 0, 1, 1);
};

var GetE = function(id){
	return $('#' + id);
};

/**
 * 화면프린트
 */
var initBody;
var beforePrint = function(){ 
    initBody = document.body.innerHTML; 
    document.body.innerHTML = print_area.innerHTML;
};

var afterPrint = function(){ 
    document.body.innerHTML = initBody; 
};
var pageprint = function(){ 
    window.onbeforeprint = beforePrint; 
    window.onafterprint = afterPrint; 
    window.print(); 
};


