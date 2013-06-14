function updateTimes() {
	var elements = document.getElementsByClassName("dateColumn");
	
	for(var i=0; i<elements.length; i++) {
		var content = elements[i].getElementsByTagName("span")[0].innerHTML;
	    
	    var values = content.split(':');
	    
	    if (values.length > 3) {
	        var seconds = parseInt(values[3]);
		    var minutes = parseInt(values[2]);
		    var hours = parseInt(values[1]);
		    
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
		    
		    if (hours < 10) {
		    	hours = "0"+hours;
		    }
		    
		    elements[i].getElementsByTagName("span")[0].innerHTML = "Active: "+hours+":"+minutes+":"+seconds;
	    }
	}
}