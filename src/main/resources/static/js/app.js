$(function(){
	$("a.confirmDeletion").click(function(){
		if(!confirm("Are you sure to delete?")) return false;
	});
});