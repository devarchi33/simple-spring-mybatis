/**
 * Created by donghoon on 2016. 7. 26..
 */
$(document).ready(function () {

    function devarchi33App() {
    };

    devarchi33App.prototype = {

        makeDataTable: function (table) {
            var table = $(table.selector).DataTable(table.option);
            return table;
        }

    };

    var devarchi33App = new devarchi33App();

    var option1 = {
        "scrollY": "400px",
        "scrollCollapse": true,
        "paging": true
    };

    var dataTableList = [
        {
            "selector": "#user_table",
            "option": option1
        }
    ];

    dataTableList.forEach(function (table) {
        devarchi33App.makeDataTable(table);
    });

});
