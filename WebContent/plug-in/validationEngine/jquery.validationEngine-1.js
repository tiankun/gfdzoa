/*
 * Inline Form Validation Engine 2.2, jQuery plugin
 *
 * Copyright(c) 2010, Cedric Dugas
 * http://www.position-absolute.com
 *
 * 2.0 Rewrite by Olivier Refalo
 * http://www.crionics.com
 *
 * Form validation engine allowing custom regex rules to be added.
 * Licensed under the MIT License
 */
(function($) {

	var methods = {

		init : function(options) {
			var form = this;
			if (!form.data('jqv') || form.data('jqv') == null) {
				methods._saveOptions(form, options);
			}
		},

		attach : function(userOptions) {
			var form = this;
			var options;

			if (userOptions)
				options = methods._saveOptions(form, userOptions);
			else
				options = form.data('jqv');

			var validateAttribute = (form
					.find("[data-validation-engine*=validate]")) ? "data-validation-engine"
					: "class";

			if (!options.binded) {
				if (options.bindMethod == "bind") {

					// bind fields
					var tf = form.find("[class*=validate]:not([type=checkbox])");
					tf.bind(options.validationEventTrigger,
							methods._onFieldEvent);
					tf.bind("keypress", methods._onFieldEvent);
					form
							.find("[class*=validate][type=checkbox],select[class*=validate]")
							.bind("click", methods._onFieldEvent);

					// bind form.submit
					form.bind("submit", methods._onSubmitEvent);
				} else if (options.bindMethod == "live") {
					// bind fields with LIVE (for persistant state)
					form.find("[class*=validate]:not([type=checkbox])").live(
							options.validationEventTrigger,
							methods._onFieldEvent);
					form.find("[class*=validate][type=checkbox]").live("click",
							methods._onFieldEvent);

					// bind form.submit
					form.live("submit", methods._onSubmitEvent);
				}

				options.binded = true;
			}

		},

		detach : function() {
			var form = this;
			var options = form.data('jqv');
			if (options.binded) {

				// unbind fields
				form.find("[class*=validate]").not("[type=checkbox]").unbind(
						options.validationEventTrigger, methods._onFieldEvent);
				form.find("[class*=validate][type=checkbox]").unbind("click",
						methods._onFieldEvent);
				// unbind form.submit
				form.unbind("submit", methods.onAjaxFormComplete);

				// unbind live fields (kill)
				form.find("[class*=validate]").not("[type=checkbox]").die(
						options.validationEventTrigger, methods._onFieldEvent);
				form.find("[class*=validate][type=checkbox]").die("click",
						methods._onFieldEvent);
				// unbind form.submit
				form.die("submit", methods.onAjaxFormComplete);

				form.removeData('jqv');
			}
		},

		validate : function() {
			return methods._validateFields(this);
		},

		validateField : function(el) {
			var options = $(this).data('jqv');
			return methods._validateField($(el), options);
		},

		validateform : function() {
			return methods._onSubmitEvent.call(this);
		},

		showPrompt : function(promptText, type, promptPosition, showArrow) {

			var form = this.closest('form');
			var options = form.data('jqv');
			// No option, take default one
			if (!options)
				options = methods._saveOptions(this, options);
			if (promptPosition)
				options.promptPosition = promptPosition;
			options.showArrow = showArrow == true;

			methods._showPrompt(this, promptText, type, false, options);
		},

		hidePrompt : function() {
			var promptClass = "." + methods._getClassName($(this).attr("id"))
					+ "formError";
			$(promptClass).fadeTo("fast", 0.3, function() {
				$(this).remove();
			});
		},

		hide : function() {
			var closingtag;
			if ($(this).is("form")) {
				closingtag = "parentForm" + $(this).attr('id');
			} else {
				closingtag = $(this).attr('id') + "formError";
			}
			$('.' + closingtag).fadeTo("fast", 0.3, function() {
				$(this).remove();
			});
		},

		hideAll : function() {
			$('.formError').fadeTo("fast", 0.3, function() {
				$(this).remove();
			});
		},

		_onFieldEvent : function() {
			var field = $(this);
			var form = field.closest('form');
			var options = form.data('jqv');
			// validate the current field
			methods._validateField(field, options);
		},

		_onSubmitEvent : function() {
			var form = $(this);
			var options = form.data('jqv');

			var r = methods._validateFields(form, true);

			if (r && options.ajaxFormValidation) {
				methods._validateFormWithAjax(form, options);
				return false;
			}

			if (options.onValidationComplete) {
				options.onValidationComplete(form, r);
				return false;
			}
			return r;
		},

		_checkAjaxStatus : function(options) {
			var status = true;
			$.each(options.ajaxValidCache, function(key, value) {
				if (!value) {
					status = false;
					// break the each
					return false;
				}
			});
			return status;
		},

		_validateFields : function(form, skipAjaxValidation) {
			var options = form.data('jqv');

			// this variable is set to true if an error is found
			var errorFound = false;

			// Trigger hook, start validation
			form.trigger("jqv.form.validating");
			// first, evaluate status of non ajax fields
			form.find('[class*=validate]').not(':hidden').each(
					function() {
						var field = $(this);
						errorFound |= methods._validateField(field, options,
								skipAjaxValidation);
					});
			// thrird, check status and scroll the container accordingly
			form.trigger("jqv.form.result", [ errorFound ]);

			if (errorFound) {

				if (options.scroll) {

					var destination = Number.MAX_VALUE;
					var fixleft = 0;
					var lst = $(".formError:not('.greenPopup')");

					for ( var i = 0; i < lst.length; i++) {
						var d = $(lst[i]).offset().top;
						if (d < destination) {
							destination = d;
							fixleft = $(lst[i]).offset().left;
						}
					}

					if (!options.isOverflown)
						$("html:not(:animated),body:not(:animated)").animate({
							scrollTop : destination,
							scrollLeft : fixleft
						}, 1100);
					else {
						var overflowDIV = $(options.overflownDIV);
						var scrollContainerScroll = overflowDIV.scrollTop();
						var scrollContainerPos = -parseInt(overflowDIV.offset().top);

						destination += scrollContainerScroll
								+ scrollContainerPos - 5;
						var scrollContainer = $(options.overflownDIV
								+ ":not(:animated)");

						scrollContainer.animate({
							scrollTop : destination
						}, 1100);

						$("html:not(:animated),body:not(:animated)").animate({
							scrollTop : overflowDIV.offset().top,
							scrollLeft : fixleft
						}, 1100);
					}
				}
				return false;
			}
			return true;
		},
		_validateFormWithAjax : function(form, options) {

			var data = form.serialize();
			var url = (options.ajaxFormValidationURL) ? options.ajaxFormValidationURL
					: form.attr("action");
			$
					.ajax({
						type : "GET",
						url : url,
						cache : false,
						dataType : "json",
						data : data,
						form : form,
						methods : methods,
						options : options,
						beforeSend : function() {
							return options.onBeforeAjaxFormValidation(form,
									options);
						},
						error : function(data, transport) {
							methods._ajaxError(data, transport);
						},
						success : function(json) {

							if (json !== true) {
								var errorInForm = false;
								for ( var i = 0; i < json.length; i++) {
									var value = json[i];

									var errorFieldId = value[0];
									var errorField = $($("#" + errorFieldId)[0]);

									// make sure we found the element
									if (errorField.length == 1) {

										// promptText or selector
										var msg = value[2];
										// if the field is valid
										if (value[1] == true) {

											if (msg == "" || !msg) {
												// if for some reason,
												// status==true and error="",
												// just close the prompt
												methods
														._closePrompt(errorField);
											} else {
												// the field is valid, but we
												// are displaying a green prompt
												if (options.allrules[msg]) {
													var txt = options.allrules[msg].alertTextOk;
													if (txt)
														msg = txt;
												}
												methods._showPrompt(errorField,
														msg, "pass", false,
														options, true);
											}

										} else {
											// the field is invalid, show the
											// red error prompt
											errorInForm |= true;
											if (options.allrules[msg]) {
												var txt = options.allrules[msg].alertText;
												if (txt)
													msg = txt;
											}
											methods._showPrompt(errorField,
													msg, "", false, options,
													true);
										}
									}
								}
								options.onAjaxFormComplete(!errorInForm, form,
										json, options);
							} else
								options.onAjaxFormComplete(true, form, "",
										options);
						}
					});

		},

		_validateField : function(field, options, skipAjaxValidation) {
			if (!field.attr("id"))
				$.error("jQueryValidate: an ID attribute is required for this field: "
								+ field.attr("name")
								+ " class:"
								+ field.attr("class"));

			var rulesParsing = field.attr('class');
			var getRules = /validate\[(.*)\]/.exec(rulesParsing);
			if (!getRules)
				return false;
			var str = getRules[1];
			var rules = str.split(/\[|,|\]/);

			// true if we ran the ajax validation, tells the logic to stop
			// messing with prompts
			var isAjaxValidator = false;
			var fieldName = field.attr("name");
			var promptText = "";
			var required = false;
			options.isError = false;
			options.showArrow = true;

			for ( var i = 0; i < rules.length; i++) {

				var errorMsg = undefined;
				switch (rules[i]) {

				case "required":
					required = true;
					errorMsg = methods._required(field, rules, i, options);
					break;
				case "custom":
					errorMsg = methods._customRegex(field, rules, i, options);
					break;
				case "ajax":
					// ajax has its own prompts handling technique
					if (!skipAjaxValidation) {
						methods._ajax(field, rules, i, options);
						isAjaxValidator = true;
					}
					break;
				case "minSize":
					errorMsg = methods._minSize(field, rules, i, options);
					break;
				case "maxSize":
					errorMsg = methods._maxSize(field, rules, i, options);
					break;
				case "min":
					errorMsg = methods._min(field, rules, i, options);
					break;
				case "max":
					errorMsg = methods._max(field, rules, i, options);
					break;
				case "past":
					errorMsg = methods._past(field, rules, i, options);
					break;
				case "future":
					errorMsg = methods._future(field, rules, i, options);
					break;
				case "maxCheckbox":
					errorMsg = methods._maxCheckbox(field, rules, i, options);
					field = $($("input[name='" + fieldName + "']"));
					break;
				case "minCheckbox":
					errorMsg = methods._minCheckbox(field, rules, i, options);
					field = $($("input[name='" + fieldName + "']"));
					break;
				case "equals":
					errorMsg = methods._equals(field, rules, i, options);
					break;
				case "funcCall":
					errorMsg = methods._funcCall(field, rules, i, options);
					break;

				default:
					// $.error("jQueryValidator rule not found"+rules[i]);
				}
				if (errorMsg !== undefined) {
					promptText += errorMsg + "<br/>";
					options.isError = true;

				}

			}
			// If the rules required is not added, an empty field is not
			// validated
			if (!required) {
				if (field.val() == "")
					options.isError = false;
			}
			// Hack for radio/checkbox group button, the validation go into the
			// first radio/checkbox of the group
			var fieldType = field.attr("type");

			if ((fieldType == "radio" || fieldType == "checkbox")
					&& $("input[name='" + fieldName + "']").size() > 1) {
				field = $($("input[name='" + fieldName
						+ "'][type!=hidden]:first"));
				options.showArrow = false;
			}

			if (options.isError) {

				methods._showPrompt(field, promptText, "", false, options);
			} else {
				if (!isAjaxValidator)
					methods._closePrompt(field);
			}
			field.trigger("jqv.field.result", [ field, options.isError,
					promptText ]);
			return options.isError;
		},

		_required : function(field, rules, i, options) {
			switch (field.attr("type")) {
			case "text":
			case "password":
			case "textarea":
			case "file":
			default:
				if (!field.val())
					return options.allrules[rules[i]].alertText;
				break;
			case "radio":
			case "checkbox":
				var name = field.attr("name");
				if ($("input[name='" + name + "']:checked").size() == 0) {

					if ($("input[name='" + name + "']").size() == 1)
						return options.allrules[rules[i]].alertTextCheckboxe;
					else
						return options.allrules[rules[i]].alertTextCheckboxMultiple;
				}
				break;
			// required for <select>
			case "select-one":
				// added by paul@kinetek.net for select boxes, Thank you
				if (!field.val())
					return options.allrules[rules[i]].alertText;
				break;
			case "select-multiple":
				// added by paul@kinetek.net for select boxes, Thank you
				if (!field.find("option:selected").val())
					return options.allrules[rules[i]].alertText;
				break;
			}
		},

		_customRegex : function(field, rules, i, options) {
			var customRule = rules[i + 1];
			var rule = options.allrules[customRule];
			if (!rule) {
				alert("jqv:custom rule not found " + customRule);
				return;
			}

			var ex = rule.regex;
			if (!ex) {
				alert("jqv:custom regex not found " + customRule);
				return;
			}
			var pattern = new RegExp(ex);

			if (!pattern.test(field.val()))
				return options.allrules[customRule].alertText;
		},

		_funcCall : function(field, rules, i, options) {
			var functionName = rules[i + 1];
			var fn = window[functionName];
			if (typeof (fn) == 'function')
				return fn(field, rules, i, options);

		},

		_equals : function(field, rules, i, options) {
			var equalsField = rules[i + 1];

			if (field.val() != $("#" + equalsField).val())
				return options.allrules.equals.alertText;
		},

		_maxSize : function(field, rules, i, options) {
			var max = rules[i + 1];
			var len = field.val().length;

			if (len > max) {
				var rule = options.allrules.maxSize;
				return rule.alertText + max + rule.alertText2;
			}
		},

		_minSize : function(field, rules, i, options) {
			var min = rules[i + 1];
			var len = field.val().length;

			if (len < min) {
				var rule = options.allrules.minSize;
				return rule.alertText + min + rule.alertText2;
			}
		},

		_min : function(field, rules, i, options) {
			var min = parseFloat(rules[i + 1]);
			var len = parseFloat(field.val());

			if (len < min) {
				var rule = options.allrules.min;
				if (rule.alertText2)
					return rule.alertText + min + rule.alertText2;
				return rule.alertText + min;
			}
		},

		_max : function(field, rules, i, options) {
			var max = parseFloat(rules[i + 1]);
			var len = parseFloat(field.val());

			if (len > max) {
				var rule = options.allrules.max;
				if (rule.alertText2)
					return rule.alertText + max + rule.alertText2;
				// orefalo: to review, also do the translations
				return rule.alertText + max;
			}
		},

		_past : function(field, rules, i, options) {

			var p = rules[i + 1];
			var pdate = (p.toLowerCase() == "now") ? new Date() : methods
					._parseDate(p);
			var vdate = methods._parseDate(field.val());

			if (vdate < pdate) {
				var rule = options.allrules.past;
				if (rule.alertText2)
					return rule.alertText + methods._dateToString(pdate)
							+ rule.alertText2;
				return rule.alertText + methods._dateToString(pdate);
			}
		},

		_future : function(field, rules, i, options) {

			var p = rules[i + 1];
			var pdate = (p.toLowerCase() == "now") ? new Date() : methods
					._parseDate(p);
			var vdate = methods._parseDate(field.val());

			if (vdate > pdate) {
				var rule = options.allrules.future;
				if (rule.alertText2)
					return rule.alertText + methods._dateToString(pdate)
							+ rule.alertText2;
				return rule.alertText + methods._dateToString(pdate);
			}
		},

		_maxCheckbox : function(field, rules, i, options) {

			var nbCheck = rules[i + 1];
			var groupname = field.attr("name");
			var groupSize = $("input[name='" + groupname + "']:checked").size();
			if (groupSize > nbCheck) {
				options.showArrow = false;
				if (options.allrules.maxCheckbox.alertText2)
					return options.allrules.maxCheckbox.alertText + " "
							+ nbCheck + " "
							+ options.allrules.maxCheckbox.alertText2;
				return options.allrules.maxCheckbox.alertText;
			}
		},
		_minCheckbox : function(field, rules, i, options) {

			var nbCheck = rules[i + 1];
			var groupname = field.attr("name");
			var groupSize = $("input[name='" + groupname + "']:checked").size();
			if (groupSize < nbCheck) {
				options.showArrow = false;
				return options.allrules.minCheckbox.alertText + " " + nbCheck
						+ " " + options.allrules.minCheckbox.alertText2;
			}
		},
		_ajax : function(field, rules, i, options) {

			var errorSelector = rules[i + 1];
			var rule = options.allrules[errorSelector];
			var extraData = rule.extraData;
			var extraDataDynamic = rule.extraDataDynamic;

			if (!extraData)
				extraData = "";

			if (extraDataDynamic) {
				var tmpData = [];
				var domIds = String(extraDataDynamic).split(",");
				for ( var i = 0; i < domIds.length; i++) {
					var id = domIds[i];
					if ($(id).length) {
						var inputValue = field.closest("form").find(id).val();
						var keyValue = id.replace('#', '') + '='
								+ escape(inputValue);
						tmpData.push(keyValue);
					}
				}
				extraDataDynamic = tmpData.join("&");
			} else {
				extraDataDynamic = "";
			}

			if (!options.isError) {
				$
						.ajax({
							type : "GET",
							url : rule.url,
							cache : false,
							dataType : "json",
							data : "fieldId=" + field.attr("id")
									+ "&fieldValue=" + field.val()
									+ "&extraData=" + extraData + "&"
									+ extraDataDynamic,
							field : field,
							rule : rule,
							methods : methods,
							options : options,
							beforeSend : function() {
								// build the loading prompt
								var loadingText = rule.alertTextLoad;
								if (loadingText)
									methods._showPrompt(field, loadingText,
											"load", true, options);
							},
							error : function(data, transport) {
								methods._ajaxError(data, transport);
							},
							success : function(json) {
								var errorFieldId = json[0];
								var errorField = $($("#" + errorFieldId)[0]);
								// make sure we found the element
								if (errorField.length == 1) {
									var status = json[1];
									// read the optional msg from the server
									var msg = json[2];
									if (!status) {
										options.ajaxValidCache[errorFieldId] = false;
										options.isError = true;
										if (msg) {
											if (options.allrules[msg]) {
												var txt = options.allrules[msg].alertText;
												if (txt)
													msg = txt;
											}
										} else
											msg = rule.alertText;

										methods._showPrompt(errorField, msg,
												"", true, options);
									} else {
										if (options.ajaxValidCache[errorFieldId] !== undefined)
											options.ajaxValidCache[errorFieldId] = true;

										if (msg) {
											if (options.allrules[msg]) {
												var txt = options.allrules[msg].alertTextOk;
												if (txt)
													msg = txt;
											}
										} else
											msg = rule.alertTextOk;
										if (msg)
											methods._showPrompt(errorField,
													msg, "pass", true, options);
										else
											methods._closePrompt(errorField);
									}
								}
							}
						});
			}
		},

		_ajaxError : function(data, transport) {
			if (data.status == 0 && transport == null)
				alert("The page is not served from a server! ajax call failed");
			else if (typeof console != "undefined")
				console.log("Ajax error: " + data.status + " " + transport);
		},

		_dateToString : function(date) {

			return date.getFullYear() + "-" + (date.getMonth() + 1) + "-"
					+ date.getDate();
		},

		_parseDate : function(d) {

			var dateParts = d.split("-");
			if (dateParts == d)
				dateParts = d.split("/");
			return new Date(dateParts[0], (dateParts[1] - 1), dateParts[2]);
		},

		_showPrompt : function(field, promptText, type, ajaxed, options,
				ajaxform) {
			var prompt = methods._getPrompt(field);
			if (ajaxform)
				prompt = false;
			if (prompt)
				methods._updatePrompt(field, prompt, promptText, type, ajaxed,
						options);
			else
				methods._buildPrompt(field, promptText, type, ajaxed, options);
		},

		_buildPrompt : function(field, promptText, type, ajaxed, options) {

			var prompt = $('<div>');
			prompt.addClass(methods._getClassName(field.attr("id"))
					+ "formError");
			if (field.is(":input"))
				prompt.addClass("parentForm"
						+ methods._getClassName(field.parents('form')
								.attr("id")));
			prompt.addClass("formError");

			switch (type) {
			case "pass":
				prompt.addClass("greenPopup");
				break;
			case "load":
				prompt.addClass("blackPopup");
			}
			if (ajaxed)
				prompt.addClass("ajaxed");

			var promptContent = $('<div title="鼠标移开将自动隐藏。">').addClass(
					"formErrorContent").html(promptText).appendTo(prompt).mouseout(function(){$(this.parentNode).remove()});
			if (options.showArrow) {
				var arrow = $('<div>').addClass("formErrorArrow");

				switch (options.promptPosition) {
				case "bottomLeft":
				case "bottomRight":
					prompt.find(".formErrorContent").before(arrow);
					arrow
							.addClass("formErrorArrowBottom")
							.html(
									'<div class="line1"><!-- --></div><div class="line2"><!-- --></div><div class="line3"><!-- --></div><div class="line4"><!-- --></div><div class="line5"><!-- --></div><div class="line6"><!-- --></div><div class="line7"><!-- --></div><div class="line8"><!-- --></div><div class="line9"><!-- --></div><div class="line10"><!-- --></div>');
					break;
				case "topLeft":
				case "topRight":
					arrow
							.html('<div class="line10"><!-- --></div><div class="line9"><!-- --></div><div class="line8"><!-- --></div><div class="line7"><!-- --></div><div class="line6"><!-- --></div><div class="line5"><!-- --></div><div class="line4"><!-- --></div><div class="line3"><!-- --></div><div class="line2"><!-- --></div><div class="line1"><!-- --></div>');
					prompt.append(arrow);
					break;
				}

			}
			if (options.isOverflown)
				field.before(prompt);
			else
				$("body").append(prompt);

			var pos = methods._calculatePosition(field, prompt, options);
			prompt.css({
				"top" : pos.callerTopPosition,
				"left" : pos.callerleftPosition,
				"marginTop" : pos.marginTopSize,
				"opacity" : 0
			});

			return prompt.animate({
				"opacity" : 0.87
			});

		},

		_updatePrompt : function(field, prompt, promptText, type, ajaxed,
				options) {

			if (prompt) {
				if (type == "pass")
					prompt.addClass("greenPopup");
				else
					prompt.removeClass("greenPopup");

				if (type == "load")
					prompt.addClass("blackPopup");
				else
					prompt.removeClass("blackPopup");

				if (ajaxed)
					prompt.addClass("ajaxed");
				else
					prompt.removeClass("ajaxed");

				prompt.find(".formErrorContent").html(promptText);

				var pos = methods._calculatePosition(field, prompt, options);
				prompt.animate({
					"top" : pos.callerTopPosition,
					"marginTop" : pos.marginTopSize
				});
			}
		},

		_closePrompt : function(field) {

			var prompt = methods._getPrompt(field);
			if (prompt)
				prompt.fadeTo("fast", 0, function() {
					prompt.remove();
				});
		},
		closePrompt : function(field) {
			return methods._closePrompt(field);
		},

		_getPrompt : function(field) {

			var className = "." + methods._getClassName(field.attr("id"))
					+ "formError";
			var match = $(className)[0];
			if (match)
				return $(match);
		},

		_calculatePosition : function(field, promptElmt, options) {

			var promptTopPosition, promptleftPosition, marginTopSize;
			var fieldWidth = field.width();
			var promptHeight = promptElmt.height();

			var overflow = options.isOverflown;
			if (overflow) {
				// is the form contained in an overflown container?
				promptTopPosition = promptleftPosition = 0;
				// compensation for the arrow
				marginTopSize = -promptHeight;
			} else {
				var offset = field.offset();
				promptTopPosition = offset.top;
				promptleftPosition = offset.left;
				marginTopSize = 0;
			}

			switch (options.promptPosition) {

			default:
			case "topRight":
				if (overflow)
					// Is the form contained in an overflown container?
					promptleftPosition += fieldWidth;
				else {
					promptleftPosition += fieldWidth;
					promptTopPosition += -promptHeight;
				}
				break;
			case "topLeft":
				promptTopPosition += -promptHeight + 10;
				break;
			case "centerRight":
				promptleftPosition += fieldWidth + 13;
				break;
			case "bottomLeft":
				promptTopPosition = promptTopPosition + field.height() + 15;
				break;
			case "bottomRight":
				promptleftPosition += fieldWidth - 30;
				promptTopPosition += field.height() + 5;
			}

			return {
				"callerTopPosition" : promptTopPosition + "px",
				"callerleftPosition" : promptleftPosition - 10 + "px",
				"marginTopSize" : marginTopSize + "px"
			};
		},

		_saveOptions : function(form, options) {

			if ($.validationEngineLanguage)
				var allRules = $.validationEngineLanguage.allRules;
			else
				$.error("jQuery.validationEngine rules are not loaded, plz add localization files to the page");

			var userOptions = $.extend({
				validationEventTrigger : "blur",
				scroll : true,
				promptPosition : "topLeft",
				bindMethod : "bind",
				inlineAjax : false,
				ajaxFormValidation : false,
				ajaxFormValidationURL : false,
				onAjaxFormComplete : $.noop,
				onBeforeAjaxFormValidation : $.noop,
				onValidationComplete : false,
				isOverflown : false,
				overflownDIV : "",
				allrules : allRules,
				binded : false,
				showArrow : true,
				isError : false,
				ajaxValidCache : {}

			}, options);

			form.data('jqv', userOptions);
			return userOptions;
		},

		_getClassName : function(className) {
			return className.replace(":", "_").replace(".", "_");
		}
	};

	$.fn.validationEngine = function(method) {

		var form = $(this);
		if (!form[0])
			return false; // stop here if the form does not exist

		if (typeof (method) == 'string' && method.charAt(0) != '_'
				&& methods[method]) {

			// make sure init is called once
			if (method != "showPrompt" && method != "hidePrompt"
					&& method != "hide" && method != "hideAll")
				methods.init.apply(form);

			return methods[method].apply(form, Array.prototype.slice.call(
					arguments, 1));
		} else if (typeof method == 'object' || !method) {
			// default constructor with or without arguments
			methods.init.apply(form, arguments);
			return methods.attach.apply(form);
		} else {
			$.error('Method ' + method
					+ ' does not exist in jQuery.validationEngine');
		}
	};
})(jQuery);

(function($) {
	$.fn.validationEngineLanguage = function() {
	};
	$.validationEngineLanguage = {
		newLang : function() {
			$.validationEngineLanguage.allRules = {
				"required" : { // Add your regex rules here, you can take
					// telephone as an example
					"regex" : "none",
					"alertText" : "该项为必填",
					"alertTextCheckboxMultiple" : "必须选择一项",
					"alertTextCheckboxe" : "必须选择此项"
				},
				"minSize" : {
					"regex" : "none",
					"alertText" : "至少",
					"alertText2" : "个字符"
				},
				"maxSize" : {
					"regex" : "none",
					"alertText" : "最多 ",
					"alertText2" : "个字符"
				},
				"min" : {
					"regex" : "none",
					"alertText" : "不能小于",
					"alertText2" : ""
				},
				"max" : {
					"regex" : "none",
					"alertText" : "不能大于 ",
					"alertText2" : ""
				},
				"past" : {
					"regex" : "none",
					"alertText" : "* Date prior to "
				},
				"future" : {
					"regex" : "none",
					"alertText" : "* Date past "
				},
				"maxCheckbox" : {
					"regex" : "none",
					"alertText" : "* Maximum ",
					"alertText2" : " options allowed"
				},
				"minCheckbox" : {
					"regex" : "none",
					"alertText" : "* Please select ",
					"alertText2" : " options"
				},
				"equals" : {
					"regex" : "none",
					"alertText" : " 密码不一致"
				},
				"phone" : {
					// credit: jquery.h5validate.js / orefalo
					"regex" : /^([\+][0-9]{1,3}[ \.\-])?([\(]{1}[0-9]{2,6}[\)])?([0-9 \.\-\/]{3,20})((x|ext|extension)[ ]?[0-9]{1,4})?$/,
					"alertText" : "电话号码格式有误"
				},
				"email" : {
					"regex" : /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i,
					"alertText" : "邮箱格式有误"
				},
				"integer" : {
					"regex" : /^[\-\+]?\d+$/,
					"alertText" : " 必须为整数"
				},
				"postalcode" : {
					"regex" : /^[0-9]{6}$/,
					"alertText" : "邮编格式有误"
				},
				"tell" : {
					"regex" : /^(1[3,5,8][0-9]{9}|[0-9]{7,8}|0[0-9]{2,3}\-[0-9]{7,8}(\-[0-9]{0-4})?)$/,
					"alertText" : "电话号码有误"
				},
				"number" : {
					"regex" : /^[\-\+]?(([0-9]+)([\.,]([0-9]+))?|([\.,]([0-9]+))?)$/,
					"alertText" : "必须为数字"
				},
				"cardid" : {
					"regex" : /[\d]{6}(19|20)*[\d]{2}((0[1-9])|(11|12))([012][\d]|(30|31))[\d]{3}[xX\d]*/,
					"alertText" : "格式有误"
				},
				"date" : {
					"regex" : /^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])$/,
					"alertText" : "* Invalid date, must be in YYYY-MM-DD format"
				},
				"ipv4" : {
					"regex" : /^((([01]?[0-9]{1,2})|(2[0-4][0-9])|(25[0-5]))[.]){3}(([0-1]?[0-9]{1,2})|(2[0-4][0-9])|(25[0-5]))$/,
					"alertText" : "* Invalid IP address"
				},
				"url" : {
					"regex" : /^(https?|ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i,
					"alertText" : "* Invalid URL"
				},
				"onlyNumberSp" : {
					"regex" : /^[0-9\ ]+$/,
					"alertText" : "* Numbers only"
				},
				"onlyLetterSp" : {
					"regex" : /^[a-zA-Z\ \']+$/,
					"alertText" : "* Letters only"
				},
				"onlyLetterNumber" : {
					"regex" : /^[0-9a-zA-Z]+$/,
					"alertText" : "* No special characters allowed"
				},
				// --- CUSTOM RULES -- Those are specific to the demos, they can
				// be removed or changed to your likings
				"ajaxUserCall" : {
					"url" : "ajaxValidateFieldUser",
					// you may want to pass extra data on the ajax call
					"extraData" : "name=eric",
					"alertText" : "* This user is already taken",
					"alertTextLoad" : "* Validating, please wait"
				},
				"ajaxUserCallPhp" : {
					"url" : "phpajax/ajaxValidateFieldUser.php",
					// you may want to pass extra data on the ajax call
					"extraData" : "name=eric",
					// if you provide an "alertTextOk", it will show as a green
					// prompt when the field validates
					"alertTextOk" : "* This username is available",
					"alertText" : "* This user is already taken",
					"alertTextLoad" : "* Validating, please wait"
				},
				"ajaxNameCall" : {
					// remote json service location
					"url" : "ajaxValidateFieldName",
					// error
					"alertText" : "* This name is already taken",
					// if you provide an "alertTextOk", it will show as a green
					// prompt when the field validates
					"alertTextOk" : "* This name is available",
					// speaks by itself
					"alertTextLoad" : "* Validating, please wait"
				},
				"ajaxNameCallPhp" : {
					// remote json service location
					"url" : "phpajax/ajaxValidateFieldName.php",
					// error
					"alertText" : "* This name is already taken",
					// speaks by itself
					"alertTextLoad" : "* Validating, please wait"
				},
				"validate2fields" : {
					"alertText" : "* Please input HELLO"
				}
			};

		}
	};
	$.validationEngineLanguage.newLang();
})(jQuery);