$(function () {
    "use strict";
    var geekCols = [false, false, false, true, true, false, true, true, false, false, false, false, false, true, false, false],
        humanCols = [false, false, false, false, false, true, false, false, true, true, true, true, true, false, true, false],
        geekColName = "geek-col",
        humanColName = "human-col";

    // add case insensitive contains (note the final i)
    $.extend($.expr[':'], {
        'containsi': function (elem, i, match, array) {
            return (elem.textContent || elem.innerText || '').toLowerCase()
                .indexOf((match[3] || "").toLowerCase()) >= 0;
        }
    });


    function inputToSearch(jqObj, onLiveSearch, onSearch, onClear) {
        var onSearchEvent = function (event) {
            var query = jqObj.val();

            if (query === "") {
                if (onClear) {
                    onClear(query);
                }
            } else if (event.keyCode === 13) {
                if (onSearch) {
                    onSearch(query);
                }
            } else if (onLiveSearch) {
                onLiveSearch(query);
            }
        };

        jqObj.keyup(onSearchEvent).on("search", onSearchEvent);
    }

    (function () {
        var
            $table = $("#bares"),
            $filter = $("#filter"),
            $zona = $("#zona");

        $table.tablesorter();

        function filterTable(query) {
            if (query === "") {
                $table.find("tbody>tr").show();
            } else {
                $table.find("tbody>tr").hide().filter(":containsi(" + query + ")").show();
            }
        }

        function fillSelectZona() {
            var items = [""], i, option;

            $table.find("tbody>tr").find("td:nth(2)").each(function (index, node) {
                var item = $.trim($(node).html());

                if ($.inArray(item, items) === -1) {
                    items.push(item);
                }
            });

            function displayByZone(zone) {
            }

            for (i = 0; i < items.length; i += 1) {
                option = $("<option>")
                    .attr("value", items[i])
                    .html(items[i]);

                $zona.append(option);
            }
        }

        function filterByZone(zone) {
            $filter.val(zone);
            filterTable(zone);
        }

        $zona.change(function () {
            filterByZone($(this).children(":selected").html());
        });

        function setGeekHumanClasses() {
            $table.find("tr").each(function (i, row) {
                $(row).children().each(function (index, node) {
                    node = $(node);

                    if (geekCols[index]) {
                        node.addClass(geekColName);
                    }

                    if (humanCols[index]) {
                        node.addClass(humanColName);
                    }
                });
            });
        }

        function toggleCols(cls) {
            return function () {
                if ($(this).attr("checked")) {
                    $("." + cls).show();
                } else {
                    $("." + cls).hide();
                }
            };
        }

        $("#humano").click(toggleCols(humanColName));
        $("#geek").click(toggleCols(geekColName));

        inputToSearch($filter, filterTable, filterTable, filterTable);
        fillSelectZona();
        setGeekHumanClasses();
        $("." + humanColName).hide();
        $("." + geekColName).hide();
    }());
});
