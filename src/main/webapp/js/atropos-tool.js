var menuTool = {
		
	/* 左边菜单数据列表 */
	leftMenuArray : null ,
	
	/* 创建左边菜单，参数id在哪个元素下创建 */
	createLeftMenu : function(id){
		var arr = this.leftMenuArray;
		
	}
};

var DataGrid = {
		jsonObj : null,
		/**
		 * *获取选中的行 *返回:Row数组
		 */
		getSelectedRows : function(){
			var thisObj = this;
			var array = new Array();
			$('#_dataGridTable input[checkboxgroup]:checked').each(function(){
				array.push(thisObj.getRow(new Number($(this).parent().parent().attr('index'))));
			});
			return array;
		},
		/**
		 * *获取选中行的索引集合 *返回:数字数组
		 */
		getSelectedRowIndexes : function(){
			var array = new Array();
			$('#_dataGridTable input[checkboxgroup]:checked').each(function(){
				array.push(new Number($(this).parent().parent().attr('index')));
			});
			return array;
		},
		/**
		 * 获取所有行的数据 返回:Row数组
		 */
		getAllRow : function(){
			var rowArray = new Array();
			for(var index in this.jsonObj){
				var target = this._getRowObj(new Number(index));
				if(!target) continue;
				var row = new Row(target,this.jsonObj[index],new Number(index));
				rowArray.push(row);
			}
			return rowArray;
		},
		/**
		 * *获取指定的行 *请求:参数为数字索引或者主键值 *返回:row对象
		 */
		getRow : function(key){
			var target = this._getRowObj(key);
			if(!target) return false;
			var index = target.attr('index');
			var row = new Row(target,this.jsonObj[index],new Number(index));
			return row;
		},
		/**
		 * *隐藏行，但不删除数据 请求：该row的key或者index
		 */
		hideRow : function(key){
			this._getRowObj(key).fadeOut('normal');
		},
		/**
		 * *显示行 请求：该row的key或者index
		 */
		showRow : function(key){
			this._getRowObj(key).fadeIn('normal');
		},
		/**
		 * *隐藏行并给数据增加isRemoved变量为true 请求：该row的key或者index 返回：Row对象(删除掉的对象克隆)
		 */
		removeRow : function(key){
			var target = this._getRowObj(key);
			if(!target)return false;
			target.fadeOut('normal');
			if(this.jsonObj){// 处理数据
				var index = target.attr('index');
				var tempData = this.jsonObj[new Number(index)];
				if(tempData){
					var newTempData = new Object();
					$.extend(newTempData,tempData);
					tempData.isRemoved = true;
					return new Row(target,newTempData,new Number(index));
				}
			}
			return new Row(target);
		},
		toggleRowChecked : function(key){
			this._getRowObj(key).find('input:checked').click();
		},
		/**
		 * 回复删除 *显示行并给数据增加isRemoved变量为false 请求：该row的key或者index
		 * 返回：返回回复的对象本身，找不到则返回false
		 */
		recoverRow : function(key){
			var target = this._getRowObj(key);
			if(!target) return false;
			target.fadeIn('normal');
			if(this.jsonObj){
				var index = target.attr('index');
				var tempData = this.jsonObj[new Number(index)];
				if(tempData){
					if(tempData.isRemoved) tempData.isRemoved = false;
					return tempData;
				}
			}
		},
		/**
		 * *追加行，并追加数据(数据追加属性isAppended=true) 请求：1.追加的对象 2.该对象的主键值 3.该对象的按钮集合
		 * 反馈:row对象
		 */
		appendRow : function(obj,primaryKey,buttonArray){
			var cloneTr = $('#_trEmpty').clone();
			var lastIndex = (this.rowNumber() - 1);
			var newTr = null;
			if(lastIndex == -1){// 列表无数据的情况
				$('#_dataGridTable tbody').append(cloneTr);
				newTr = $('#_dataGridTable tbody tr');
				newTr.attr('index','0');
			}else{// 列表至少有一条数据的情况
				var lastTr = this._getRowObj(lastIndex);
				lastTr.after(cloneTr);
				newTr = lastTr.next('tr');
				newTr.attr('index',lastIndex + 1);
			}
			newTr.removeAttr('id');
			if(primaryKey){
				newTr.attr('key',primaryKey);
			}
			
			for(var key in obj){
				// 只展示字符串或者数字的字段
				if(typeof obj[key] == 'string' || !isNaN(obj[key])) {
					newTr.find('td[columnkey="'+key+'"] span').text(obj[key]);
				}
			}
			
			// 处理数据
			obj.isAppended = true;
			this.jsonObj.push(obj);
			
			// 处理按钮
			if(buttonArray){
				if(buttonArray.length){// 数组
					for(var bKey in buttonArray){
						newTr.find('td[columnkey="operations"] span').append(buttonArray[bKey].generate());
					}
				}else{// 单个对象
					newTr.find('td[columnkey="operations"] span').append(buttonArray.generate());
				}
			}
			
			// 显示tr
			newTr.fadeIn('normal');
			
			// 去掉leader选中
			$('input[checkboxleader]').removeAttr('checked');
			
			var row = new Row(newTr,obj,new Number(newTr.attr('index')));
			return row;
		},
		
		/**
		 * 追加空行 请求:1.可编辑区字段名称集合 2.按钮数组 3.字段展示的形式(text/select/span) 反馈:row对象
		 * //FIXME 后续改造：追加的控件不一定为input
		 * 
		 * @param editableCell
		 * @param buttonArray
		 */
		appendEmptyRow : function(editableCell,buttonArray,features){
			var cloneTr = $('#_trEmpty').clone();
			var lastIndex = (this.rowNumber() - 1);
			var newTr = null;
			if(lastIndex == -1){// 列表无数据的情况
				$('#_dataGridTable tbody').append(cloneTr);
				newTr = $('#_dataGridTable tbody tr');
				newTr.attr('index','0');
			}else{// 列表至少有一条数据的情况
				var lastTr = this._getRowObj(lastIndex);
				lastTr.after(cloneTr);
				newTr = lastTr.next('tr');
				newTr.attr('index',lastIndex + 1);
			}
			
			// 设置可编辑区
			if(editableCell){
				var index = newTr.attr('index');
				if(editableCell.length){// 数组
					for(var cKey in editableCell){
						if(typeof editableCell[cKey] != 'string')continue;
						var targetTd = newTr.find('td[columnkey="'+editableCell[cKey]+'"]');
						targetTd.empty();
						if(features && typeof features[editableCell[cKey]] == 'string'){
							if(features[editableCell[cKey]].toLowerCase() == 'text'){
								targetTd.append('<input type="text" id="'+editableCell[cKey]+'Text'+index+'"><div id="'+editableCell[cKey]+'Text'+index+'Tip" ></div>');
							}else if(features[editableCell[cKey]].toLowerCase() == 'select'){
								
							}
						}else{
							targetTd.append('<input type="text" id="'+editableCell[cKey]+'Text'+index+'"><div id="'+editableCell[cKey]+'Text'+index+'Tip" ></div>');
						}
					}
				}else{// 单个字符串
					var targetTd = newTr.find('td[columnkey="'+editableCell+'"]');
					targetTd.empty();
					targetTd.append('<input type="text" id="'+editableCell+'Text'+index+'"><div id="'+editableCell+'Text'+index+'Tip" ></div>');
				}
			}
			newTr.removeAttr('id');
			newTr.attr('editable','');
			
			// 处理按钮
			if(buttonArray){
				if(buttonArray.length){// 数组
					for(var bKey in buttonArray){
						newTr.find('td[columnkey="operations"] span').append(buttonArray[bKey].generate());
					}
				}else{// 单个对象
					newTr.find('td[columnkey="operations"] span').append(buttonArray.generate());
				}
			}
			
			// 显示tr
			newTr.fadeIn('normal');
			
			// 去掉leader选中
			$('input[checkboxleader]').removeAttr('checked');
			var row = new Row(newTr,{},new Number(newTr.attr('index')));
			return row;
		},
		
		/**
		 * 获取可编辑的内容 请求:无 反馈:对象数组
		 * 
		 * @returns {___anonymous5119_5120}
		 */
		getEditableData : function(){
			var array = new Array();
			$('#_dataGridTable tbody tr[editable]:visible').each(function(){
				var data = {};
				$(this).find('td[columnkey] input').each(function(){
					data[$(this).parent().attr('columnkey')] = $(this).val();
				});
				array.push(data);
			});
			return array;
		},
		/**
		 * 开启编辑器 请求：{字段名称:展示类型} text/select
		 */
		enableEditor : function(map){
			// 找到span，将span中text给到input/select的value
			for(var index in this.getAllRow()){
				var row = this.getAllRow()[index];
				row.target.attr('editable','');
				row.enableEditor(map);
			}
		},
		
		/**
		 * 获取行数
		 */
		rowNumber : function(){
			return $('#_dataGridTable tbody tr').size();
		},
		
		/**
		 * 获取改行的tr元素 请求:该row的key或者index 返回:tr对象
		 */
		_getRowObj : function(key){
			if(typeof key == 'string'){
				return $('#_dataGridTable tbody tr[key="'+key+'"]');
			}else if(!isNaN(key)){
				return $('#_dataGridTable tbody tr[index="'+key+'"]');
			}
		},
		
		/**
		 * 列表查询
		 */
		doQuery : function(){
			// 查询条件查询时清空分页参数
			$('#_page').val(0);
			$('#queryForm').submit();
		},
		/**
		 * 刷新列表
		 */
		refresh : function(){
			$('#queryForm').submit();
		},
		/**
		 * 清空查询条件
		 */
		clearQueryCondition : function(){
			$('#choose-no1').find('input,select').val('');
			$('#choose-no1').find(':checkbox,:radio').removeAttr('checked');
		},
		_bindKeypress : function(){
			var dataGrid = this;
			$('[name^="dataGrid.parameters."]').keypress(function(event){
				if(event.keyCode == 13){ // enter
					dataGrid.doQuery();
				}
			});
		},
	};