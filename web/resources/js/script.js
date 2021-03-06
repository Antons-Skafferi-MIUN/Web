$(function () {
    // Set the unload message whenever any input element get changed.
    $(':input').on('change', function () {
	setConfirmUnload(true);
    });

    // Turn off the unload message whenever a form get submitted properly.
    $('form').on('submit', function () {
	setConfirmUnload(false);
    });
});

function setConfirmUnload(on) {
    var message = "You have unsaved data. Are you sure to leave the page?";
    window.onbeforeunload = (on) ? function () {
	return message;
    } : null;
}