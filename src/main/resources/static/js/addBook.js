var isNew = true;
	function addStudent() {
		if ($("#frmBook")) {
			var url = "";
			var data = "";
			var method;
			if(document.frmBook.bookName.value.length == 0 
					|| document.frmBook.seriesName.value.length == 0 || document.frmBook.description.value.length == 0){
				swal({
					title:"Writer did not add",
					text:"Please fill all blanks !!!",
					icon:"error",
					buttons: false
				});
				setTimeout(() => {
					location.href = "http://localhost:8080/admin/book/add";
				}, 2000);
				return ;
			}
			if(isNaN(document.frmBook.isbn.value)){
				swal({
					title:"Writer did not add",
					text:"Please fill all blanks !!! ISBN must be number!!!",
					icon:"error",
					buttons: false
				});
				setTimeout(() => {
					location.href = "http://localhost:8080/admin/book/add";
				}, 2000);
				return ;
			}
			if (isNew == true) {
				url = 'http://localhost:8080/rest/book/save';
				data = $("#frmBook").serialize();
				method = 'POST';
			}
			$.ajax({
				type : method,
				url : url,
				dataType : "JSON",
				data : data,
				success : function(data) {
					$('#bookName').val("");
					$('#seriesName').val("");
					$('#isbn').val("");
					$('#publisher').val("");
					$('#writer').val("");
					$('#description').val("");
					if (data.status == "success") {
						swal({
							title:"Book Added",
							text:"You are redirecting to of book list page",
							icon:"success",
							buttons: false
						});
						setTimeout(() => {
							location.href = "http://localhost:8080/admin/book/list";
						}, 2000);
						
					} else {
						alert("Error");
					}
				},
				error : function(jqXHR) {
					swal({
						title:"Book did not add",
						text:"Please fill all blanks !!! you are redirecting to of book add page",
						icon:"error",
						buttons: false
					});
					setTimeout(() => {
						location.href = "http://localhost:8080/admin/book/add";
					}, 4000);
				}
			});
		}
	}