var command;
if (!command) command = {};
if (!command.ui){
	command.ui={};
	command.ui.setDateRangePicker = function(targetStart, targetEnd, limit) {
		
		 $(targetEnd).val(moment().format("YYYY-MM-DD"));
		 $(targetStart).val(webank.month_minus(moment().format("YYYYMMDD"), 1)); //기본값 : 전월
		 $(targetStart).datepicker({
	        changeMonth: true,
	        dateFormat: 'yy-mm-dd'
	        ,maxDate: moment().format("YYYY-MM-DD")
	    });
		 
	    $(targetEnd).datepicker({
//	        maxDate:  moment().format("YYYY-MM-DD"),
	        changeMonth: true,
	        dateFormat: 'yy-mm-dd',
	        onClose: function (selectedDate, instance) {
	        	if (selectedDate != '') {
		        	var date = $.datepicker.parseDate(instance.settings.dateFormat, selectedDate, instance.settings);
	                date.setMonth(date.getMonth() - limit);
//	                $(targetStart).datepicker("option", "minDate", date);
		            $(targetStart).datepicker("option", "maxDate", selectedDate);
	        	}
	        }
	    });
	    $(targetStart).mask("9999-99-99");
		$(targetEnd).mask("9999-99-99");
	};
};
