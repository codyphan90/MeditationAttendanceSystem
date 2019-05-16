$(document).ready(function () {
    console.log("@@@@@")
    $("#course").change(function () {
        $("#reportTable").innerHTML = '';
        let blockId = $('#course option:selected').val();
        console.log("blockId = " + blockId);
        if (blockId === 0) {
            console.log("testttttt");
        }
        var url= '/faculty/report/' + blockId;
        $("#reportTable").load(url);
    });
});
