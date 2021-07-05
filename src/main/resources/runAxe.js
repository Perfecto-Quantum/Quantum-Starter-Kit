document.perfectoAxeError = document.perfectoAxeResult = null;
var callback = arguments[arguments.length - 1];
axe.run(function(err, results) {
	document.perfectoAxeError = err;
	document.perfectoAxeResults = results;
	callback(true);
});
