var isNew = true;
	function addStudent() {
		if ($("#frmWriter")) {
			var url = "";
			var data = "";
			var method;
			
if(document.frmWriter.writerName.value.length == 0 || document.frmWriter.writerSurname.value.length == 0 || document.frmWriter.writerDescription.value.length == 0){
				swal({
					title:"Writer did not add",
					text:"Please fill all blanks !!! ",
					icon:"error",
					buttons: false
				});
				setTimeout(() => {
					location.href = "http://localhost:8080/admin/writer/add";
				}, 2000);
				return ;
			}

			if (isNew == true) {
				url = 'http://localhost:8080/rest/writer/save';
				data = $("#frmWriter").serialize();
				method = 'POST';
			}
			$.ajax({
				type : method,
				url : url,
				dataType : "JSON",
				data : data,
				success : function(data) {
					$('#writerName').val("");
					$('#writerSurname').val("");
					$('#writerDescription').val("");
					if (data.status == "success") {
						swal({
							title:"Writer Added",
							text:"You are redirecting to of writer list page",
							icon:"success",
							buttons: false
						});
						setTimeout(() => {
							location.href = "http://localhost:8080/admin/writer/list";
						}, 2000);
					} else {
						alert("Error");
					}
				},
				error : function(jqXHR) {
					swal({
						title:"Writer did not add",
						text:"Please fill all blanks !!! you are redirecting to of writer add page",
						icon:"error",
						buttons: false
					});
					setTimeout(() => {
						location.href = "http://localhost:8080/admin/writer/add";
					}, 2000);
				}
			});
		}
	}
	
