$(document)
		.ready(
				function() {

					$("#addButton")
							.click(
									function() {
										if (($('.form-horizontal .control-group').length + 1) > 2) {
											alert("Only 2 control-group allowed");
											return false;
										}
										var id = ($('.form-horizontal .control-group').length + 1)
												.toString();
										$('.form-horizontal')
												.append(
														'<div class="control-group" id="control-group'
																+ id
																+ '"><label class="control-label" for="inputEmail'
																+ id
																+ '">Email'
																+ id
																+ '</label><div class="controls'
																+ id
																+ '"><input type="text" id="inputEmail'
																+ id
																+ '" placeholder="Email"></div></div>');
									});

					$("#removeButton").click(function() {
						if ($('.form-horizontal .control-group').length == 1) {
							alert("No more textbox to remove");
							return false;
						}

						$(".form-horizontal .control-group:last").remove();
					});
				});