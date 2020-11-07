var isNew = true;
	function addStudent() {
		if ($("#frmPublisher")) {
			var url = "";
			var data = "";
			var method;
			
			if(document.frmPublisher.publisherName.value.length == 0 || document.frmPublisher.publisherDescription.value.length == 0){
				swal({
					title:"Publisher did not add",
					text:"Please fill all blanks !!! ",
					icon:"error",
					buttons: false
				});
				setTimeout(() => {
					location.href = "http://localhost:8080/admin/publisher/add";
				}, 2000);
				return ;
			}
			
			if (isNew == true) {
				url = 'http://localhost:8080/rest/publisher/save';
				data = $("#frmPublisher").serialize();
				method = 'POST';
			}
			$.ajax({
				type : method,
				url : url,
				dataType : "JSON",
				data : data,
				success : function(data) {
					$('#publisherName').val("");
					$('#publisherDescription').val("");
					console.log(data);
					if (data.status == "success") {
						swal({
							title:"Publisher Added",
							text:"You are redirecting to of publisher list page",
							icon:"success",
							buttons: false
						});
						setTimeout(() => {
							location.href = "http://localhost:8080/admin/publisher/list";
						}, 2000);
					} else {
						alert("Error");
					}
				},
				error : function(jqXHR) {
					swal({
						title:"Publisher did not add",
						text:"Please fill all blanks !!! you are redirecting to of publisher add page",
						icon:"error",
						buttons: false
					});
					setTimeout(() => {
						location.href = "http://localhost:8080/admin/publisher/add";
					}, 2000);
				}
			});
		}
	}