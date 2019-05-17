$(document).ready(function () {
    $("#block").change(function () {
        console.log("$$$$$$$")
        $("#reportTable").innerHTML = '';
        let blockId = $('#block option:selected').val();
        var url= '/faculty/block/' + blockId;
        console.log(url)
        $("#reportTable").load(url);
    });

    $("#entry").change(function () {
        $("#reportTable").innerHTML = '';
        let entryId = $('#entry option:selected').val();
        var url= '/faculty/entry/' + entryId;
        $("#reportTable").load(url);
    });
});
