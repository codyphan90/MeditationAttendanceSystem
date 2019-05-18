$(document).ready(function () {
    $("#block").change(function () {

        $("#reportTable").empty();
        $("#csvLink").empty();
        let blockId = $('#block option:selected').val();
        if (blockId !== '0') {
            var urlTable = '/faculty/block/' + blockId;
            var linkCSV = 'http://localhost:8080/faculty/block/csv/' + blockId;

            var downloadButton = '<button><a href="'+ linkCSV +'">Download CSV</a></button>';
            $("#csvLink").append(downloadButton);
            $("#reportTable").load(urlTable);
        }
    });

    $("#entry").change(function () {

        $("#reportTable").empty();
        $("#csvLink").empty();
        let entryId = $('#entry option:selected').val();
        if (entryId !== '0') {
            var urlTable = '/faculty/entry/' + entryId;
            var linkCSV = 'http://localhost:8080/faculty/entry/csv/' + entryId;

            var downloadButton = '<button><a href="'+ linkCSV +'">Download CSV</a></button>';
            $("#csvLink").append(downloadButton);
            $("#reportTable").load(urlTable);
        }
    });

});
