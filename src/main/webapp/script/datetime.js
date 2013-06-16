function updateTimes() {
	var elements = document.getElementsByClassName("dateColumn");
	
	for(var i=0; i<elements.length; i++) {
		var content = elements[i].getElementsByTagName("span")[0].innerHTML;
	    
	    var values = content.split(':');
	    
	    if (values.length > 2) {
	        var seconds = parseInt(values[2]);
		    var minutes = parseInt(values[1]);
		    //var hours = parseInt(values[1]);
		    
		    seconds++;
		    
		    if (seconds >= 60) {
		    	minutes++;
		    	seconds = 0;
		    }
		    
		    if (minutes >= 60) {
		    	minutes = 0;
		    	hours++;
		    }
		    
		    if (seconds < 10) {
		    	seconds = "0"+seconds;
		    }
		    
		    if (minutes < 10) {
		    	minutes = "0"+minutes;
		    }
		    		    
		    elements[i].getElementsByTagName("span")[0].innerHTML = "Active: "+minutes+":"+seconds;
	    }
	}
}