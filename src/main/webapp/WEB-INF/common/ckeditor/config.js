/*
Copyright (c) 2003-2013, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{  
	//config.docType = '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">';
	//config.docType = '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">';
	config.language = 'ko'; 
	config.uiColor = '#D3D3D3';//툴바칼라 
	// Modify for Mantis Request [0001611: 141223_수정사항(비손_호환성보기 안했을때 글쓰기시 오류)] by seongbae.jeon - start
	config.enterMode = CKEDITOR.ENTER_DIV;//개행태그를 <p>태그에서 <br />태그로 변경 ##익스플로러 11 보안업데이트 후 호환성 체크 해제 시 한글 Enter Key 입력 후 개행문제로 인해 <br>태그에서 <div>태그로 변경##
	// end
	config.skin = 'kama';//스킨변경.'kama', 'office2003', 'v2'의 3가지 패턴  
	config.width = '600px';
	config.height = '300px'; 
	config.resize_enabled = false;  
	config.font_names = '나눔고딕,나눔고딕체;맑은 고딕,맑은고딕체;굴림;돋움;바탕;궁서;Arial;Comic Sans MS;Courier New;Tahoma;Times New Roman;Verdana';
	config.allowedContent= true;
	//['FontName','FontSize','TextColor','BGColor','Bold','Italic','Underline','OrderedList','UnorderedList','Outdent','Indent','JustifyLeft','JustifyCenter','JustifyRight','JustifyFull']
	//,['Link','Unlink','Table','RemoveFormat','PasteWord','Smiley','Source']
	config.toolbar =//툴바 버튼. 불필요한 것은 아래에서 삭제 
	[ 
	   ['Source','TextColor','BGColor','Bold','Italic','Underline','NumberedList','BulletedList','Outdent','Indent','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','Cut','Copy','Paste','PasteText','PasteFromWord','-','Print','SpellChecker']
	   ,'/'
	   ,['Link','Unlink','Table','RemoveFormat','PasteFromWord','Smiley']
	   ,['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat']
	   ,['Styles','Format','Font','FontSize']
	    //['Source','ShowBlocks','-','Save','NewPage','Preview','-','Templates']
	    //,['Cut','Copy','Paste','PasteText','PasteFromWord','-','Print','SpellChecker']
   	    //,'/'
	    //,['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat']
	    //,['Form','Checkbox','Radio','TextField','Textarea','Select','Button','ImageButton','HiddenField'] 
	    //,'/'
	    //,['Bold','Italic','Underline','Strike','-','Subscript','Superscript']
	    //,['NumberedList','BulletedList','-','Outdent','Indent','Blockquote']
	    //,['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock']
	    //,['Link','Unlink','Anchor'],
	    //['Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak'],['TextColor','BGColor']  
	    //,'/'
	    //,['Styles','Format','Font','FontSize']
	];
};
